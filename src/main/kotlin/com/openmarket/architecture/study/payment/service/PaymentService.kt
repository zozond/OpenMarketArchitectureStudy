package com.openmarket.architecture.study.payment.service

import com.openmarket.architecture.study.entity.Payment
import com.openmarket.architecture.study.entity.PaymentState
import com.openmarket.architecture.study.payment.repository.PaymentRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PaymentService (private val paymentRespository: PaymentRepository){

    fun getPaymentInfoList(userId: Long): List<Payment>{
        return paymentRespository.findByUserId(userId)
    }

    fun pay(userId: Long, priceToPay: Int): Payment{
        /**
         * 비지니스 로직 이후 재작성
         */
        return paymentRespository.save(Payment(id = null,
            userId = userId,
            price = priceToPay,
            state = PaymentState.Done,
            createdAt = LocalDateTime.now()
        ))
    }

    fun cancel(paymentId: Long): Payment{
        /**
         * 비지니스 로직 이후 재작성
         */
        val payment = paymentRespository.findById(paymentId).get()
        payment.state = PaymentState.Cancel
        return paymentRespository.save(payment)
    }
}