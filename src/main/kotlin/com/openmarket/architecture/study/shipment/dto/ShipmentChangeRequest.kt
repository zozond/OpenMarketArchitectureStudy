package com.openmarket.architecture.study.shipment.dto

import com.openmarket.architecture.study.entity.ShipmentState

data class ShipmentChangeRequest (
    var shipmentId: Long,
    var shipmentState: ShipmentState
)