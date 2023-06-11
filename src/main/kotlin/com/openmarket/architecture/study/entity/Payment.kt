package com.openmarket.architecture.study.entity

import jakarta.persistence.*
import java.time.LocalDateTime

enum class PaymentState{
    Done,
    Cancel
}

@Entity
@Table(name="payments")
data class Payment (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long?,
    var userId: Long,
    var price: Int,
    var state: PaymentState,
    var createdAt: LocalDateTime
)