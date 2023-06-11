package com.openmarket.architecture.study.payment.dto

data class PaymentRequest(
    var userId: Long,
    var priceToPay: Int
)
