package com.openmarket.architecture.study.shipment.controller

import com.openmarket.architecture.study.shipment.dto.ShipmentChangeRequest
import com.openmarket.architecture.study.shipment.dto.ShipmentControllerResponse
import com.openmarket.architecture.study.shipment.service.ShipmentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shipment")
class ShipmentController (private val shipmentService: ShipmentService){

    @GetMapping("/{shipmentId}")
    fun getShipment(@PathVariable("shipmentId") shipmentId: Long): ShipmentControllerResponse {
        /**
         * 주문 조회
         */
        return ShipmentControllerResponse(success = true, shipment = shipmentService.getShipment(shipmentId))
    }

    @PutMapping
    fun changeShipmentState(shipmentChangeRequest: ShipmentChangeRequest): ShipmentControllerResponse{
        val shipmentId = shipmentChangeRequest.shipmentId
        val shipmentState = shipmentChangeRequest.shipmentState
        return ShipmentControllerResponse(success = true, shipment = shipmentService.changeShipmentState(shipmentId, shipmentState))
    }
}