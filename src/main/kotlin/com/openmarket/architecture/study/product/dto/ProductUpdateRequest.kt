package com.openmarket.architecture.study.product.dto

data class ProductUpdateRequest (
    var productId: Long,
    var name: String,
    var price: Int,
    var description: String
)