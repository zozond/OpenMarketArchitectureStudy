package com.openmarket.architecture.study.order.dto

import com.openmarket.architecture.study.entity.Order

data class OrderControllerResponse (
    val success: Boolean,
    val order: Order
)