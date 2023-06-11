package com.openmarket.architecture.study.entity

import jakarta.persistence.*

@Entity
@Table(name="products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var productId: Long?,
    var name: String,
    var price: Int,
    var description: String
)


val EMPTY_PRODUCT = Product(
    productId = null,
    name="empty",
    price=0,
    description = "Empty Product"
)