package com.openmarket.architecture.study.order.repository

import com.openmarket.architecture.study.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Order, Long> {
}