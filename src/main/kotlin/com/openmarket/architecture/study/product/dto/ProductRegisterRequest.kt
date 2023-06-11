package com.openmarket.architecture.study.product.dto

data class ProductRegisterRequest (
    var name: String,
    var price: Int,
    var description: String
)