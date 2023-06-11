package com.openmarket.architecture.study.entity

import jakarta.persistence.*

@Entity
@Table(name="orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var orderId: Long?,
    var paymentId: Long?,
    var shipmentId: Long?,
//    var orderItemList: List<OrderItem>,
    var productIdList: List<Long>,
    var productCountList: List<Int>,
    var userId: Long
)