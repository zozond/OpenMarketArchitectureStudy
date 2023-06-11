package com.openmarket.architecture.study.order.service

import com.openmarket.architecture.study.entity.Order
import com.openmarket.architecture.study.order.dto.OrderProductRequest

class OrderDtoConverter {
    fun convert(orderProductRequest: OrderProductRequest): Order {
        val productIdList = mutableListOf<Long>()
        val productCountList = mutableListOf<Int>()

        for (orderItem in orderProductRequest.orderItemList){
            productIdList.add(orderItem.productId)
            productCountList.add(orderItem.count)
        }

        return Order(
            orderId = null,
            userId = orderProductRequest.userId,
            shipmentId = null,
            paymentId = null,
            productIdList = productIdList,
            productCountList = productCountList
        )
    }

}