package com.openmarket.architecture.study.payment.controller

import com.openmarket.architecture.study.entity.Payment
import com.openmarket.architecture.study.payment.dto.PaymentControllerResponse
import com.openmarket.architecture.study.payment.dto.PaymentRequest
import com.openmarket.architecture.study.payment.service.PaymentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/payment")
class PaymentController(private val paymentService: PaymentService) {

    @PostMapping
    fun pay(paymentRequest: PaymentRequest): PaymentControllerResponse {
        val userId = paymentRequest.userId
        val priceToPay = paymentRequest.priceToPay
        return PaymentControllerResponse(true, paymentService.pay(userId, priceToPay))
    }

    @GetMapping("/{userId}")
    fun getPaymentInfo(@PathVariable("userId") userId: Long): List<Payment> {
        /**
         * 결제 내역 조회
         */
        return paymentService.getPaymentInfoList(userId)
    }

    @DeleteMapping("/{paymentId}")
    fun cancelPayment(@PathVariable("paymentId") paymentId: Long): PaymentControllerResponse {
        /**
         * 결제 취소
         */
        return PaymentControllerResponse(true, paymentService.cancel(paymentId))
    }
}