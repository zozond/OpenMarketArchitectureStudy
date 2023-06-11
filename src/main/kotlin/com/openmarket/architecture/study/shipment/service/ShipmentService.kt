package com.openmarket.architecture.study.shipment.service

import com.openmarket.architecture.study.entity.Shipment
import com.openmarket.architecture.study.entity.ShipmentState
import com.openmarket.architecture.study.shipment.repository.ShipmentRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class ShipmentService (private val shipRepository: ShipmentRepository){

    fun getShipment(shipmentId: Long): Shipment {
        val optionalShipment = shipRepository.findById(shipmentId)
        require(optionalShipment.isEmpty) {
            throw Exception("Not Found Shipment Id")
        }
        return optionalShipment.get()
    }

    fun createShipment(): Shipment {
        return shipRepository.save(Shipment(id=null, shipmentState = ShipmentState.Prepare))
    }

    fun changeShipmentState(shipmentId: Long, shipmentState: ShipmentState): Shipment {
        val shipment = shipRepository.findById(shipmentId).get()
        shipment.shipmentState = shipmentState
        return shipRepository.save(shipment)
    }
}
