package com.openmarket.architecture.study.order.controller

import com.openmarket.architecture.study.order.dto.OrderControllerResponse
import com.openmarket.architecture.study.order.dto.OrderProductRequest
import com.openmarket.architecture.study.order.service.OrderDtoConverter
import com.openmarket.architecture.study.order.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController (private val orderService: OrderService){

    @PostMapping
    fun order(@RequestBody body: OrderProductRequest): OrderControllerResponse {
        /**
         * 주문 하기
         */
        val dtoConverter = OrderDtoConverter()
        return OrderControllerResponse(success = true, order = orderService.order(dtoConverter.convert(body)))
    }

    @DeleteMapping("/{id}")
    fun cancel(@PathVariable("id") orderId: Long): OrderControllerResponse {
        /**
         * 주문 취소
         */
        return OrderControllerResponse(success = true, order = orderService.cancel(orderId))
    }

    @GetMapping("/{id}")
    fun getOrderInfo(@PathVariable("id") orderId: Long): OrderControllerResponse {
        /**
         * 주문 조회
         */
        return OrderControllerResponse(success = true, order = orderService.getInfo(orderId))
    }
}