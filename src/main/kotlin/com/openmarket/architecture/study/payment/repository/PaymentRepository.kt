package com.openmarket.architecture.study.payment.repository

import com.openmarket.architecture.study.entity.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<Payment, Long>{
    fun findByUserId(userId: Long): List<Payment>
}