package com.openmarket.architecture.study.payment.dto

import com.openmarket.architecture.study.entity.Payment

data class PaymentControllerResponse (
    val success: Boolean,
    val payment: Payment
)

