package com.openmarket.architecture.study.product.repository

import com.openmarket.architecture.study.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
}