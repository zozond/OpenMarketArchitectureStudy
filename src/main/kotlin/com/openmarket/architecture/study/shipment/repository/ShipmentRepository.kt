package com.openmarket.architecture.study.shipment.repository

import com.openmarket.architecture.study.entity.Shipment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShipmentRepository: JpaRepository<Shipment, Long> {
}