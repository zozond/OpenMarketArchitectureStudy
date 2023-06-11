package com.openmarket.architecture.study.product.dto

import com.openmarket.architecture.study.entity.Product

data class ProductControllerResponse (
    val success: Boolean,
    val product: Product
)