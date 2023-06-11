package com.openmarket.architecture.study.entity

import jakarta.persistence.*

@Entity
@Table(name="shipments")
data class Shipment(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long?,
    var shipmentState: ShipmentState
)

enum class ShipmentState(s: String) {
    Prepare("Prepare"),
    Payment("Payment"),
    Ship("Ship"),
    Done("Done"),
    Cancelled("Cancelled")
}