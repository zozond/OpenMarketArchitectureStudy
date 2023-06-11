package com.openmarket.architecture.study.shipment.dto

import com.openmarket.architecture.study.entity.Shipment

data class ShipmentControllerResponse (val success: Boolean,
                                       val shipment: Shipment)
