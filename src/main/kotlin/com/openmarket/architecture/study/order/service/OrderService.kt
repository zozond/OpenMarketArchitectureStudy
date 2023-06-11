package com.openmarket.architecture.study.order.service

import com.openmarket.architecture.study.entity.Order
import com.openmarket.architecture.study.entity.ShipmentState
import com.openmarket.architecture.study.order.repository.OrderRepository
import com.openmarket.architecture.study.payment.service.PaymentService
import com.openmarket.architecture.study.product.service.ProductService
import com.openmarket.architecture.study.shipment.service.ShipmentService
import com.openmarket.architecture.study.user.service.UserService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val productService: ProductService,
    private val paymentService: PaymentService,
    private val userService: UserService,
    private val shipmentService: ShipmentService,
    private val orderRepository: OrderRepository) {

    @Transactional
    fun order(order: Order): Order{
        /**
         * 주문 하기
         */
        require(order.productCountList.size == order.productIdList.size)


        // 1. 주문 총액 계산
        val totalAmount = calcAmount(order)

        // 2. 유저가 주문할 수 있는지 체크
        val isAvailableToOrder = userService.isAvailableToOrder(order.userId)

        if (!isAvailableToOrder){
            throw Exception("유저가 주문 가능한 상태가 아닙니다.")
        }

        // 3. 주문 총액 계산된 내용 주문
        val payment = paymentService.pay(userId = order.userId, priceToPay = totalAmount)
        if (payment.id == null){
            throw Exception("주문이 실패하였습니다.")
        }

        // 4. 배송 생성
        val shipment = shipmentService.createShipment()
        if (shipment.id == null){
            throw Exception("주문이 실패하였습니다.")
        }

        order.paymentId = payment.id
        order.shipmentId = shipment.id
        return orderRepository.save(order)
    }

    private fun calcAmount(order: Order): Int{
        var result = 0

        for(index in 0..order.productIdList.size){
            val productId = order.productIdList[index]
            val count = order.productCountList[index]

            val productInfo = productService.getProductInfo(productId = productId)
            result += productInfo.price * count
        }

        return result
    }


    fun cancel(orderId: Long): Order{
        /**
         * 주문 실패
         */
        val order = getInfo(orderId)
        if (order.paymentId != null){
            val paymentId = order.paymentId!!
            paymentService.cancel(paymentId)
        }

        if (order.shipmentId != null){
            val shipmentId = order.shipmentId!!
            shipmentService.changeShipmentState(shipmentId, ShipmentState.Cancelled)
        }
        return orderRepository.save(order)
    }

    fun getInfo(orderId: Long): Order{
        /**
         * 주문 정보 보기
         */

        val optionalOrder = orderRepository.findById(orderId)
        if (optionalOrder.isEmpty){
            throw Exception("주문된 내역이 없습니다.")
        }else{
            return optionalOrder.get()
        }
    }
}