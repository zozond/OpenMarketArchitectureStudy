package com.openmarket.architecture.study.order.dto

data class OrderProductRequest (
    var userId: Long,
    var orderItemList: List<OrderItem>
)