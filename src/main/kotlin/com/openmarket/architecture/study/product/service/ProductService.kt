package com.openmarket.architecture.study.product.service

import com.openmarket.architecture.study.entity.EMPTY_PRODUCT
import com.openmarket.architecture.study.entity.Product
import com.openmarket.architecture.study.product.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ProductService(private val productRepository: ProductRepository) {

    private fun isAvailableProduct(productId: Long): Boolean{
        val product = productRepository.findById(productId)

        return !product.isEmpty
    }

    fun getProductInfo(productId: Long): Product {
        return if (isAvailableProduct(productId)){
            productRepository.findById(productId).get()
        }else{
            EMPTY_PRODUCT
        }
    }

    fun register(product: Product): Product{
        val savedProduct = Optional.ofNullable(productRepository.save(product))

        return if (savedProduct.isEmpty){
            EMPTY_PRODUCT
        }else{
            savedProduct.get()
        }
    }

    fun deleteProduct(productId: Long): Product{
        val product = productRepository.findById(productId)

        return if (isAvailableProduct(productId)){
            productRepository.deleteById(productId)
            product.get()
        }else{
            EMPTY_PRODUCT
        }
    }

    fun updateProduct(product: Product): Product{
        val productId = product.productId!!
        return if (isAvailableProduct(productId = productId)){
            productRepository.save(product)
        }else{
            EMPTY_PRODUCT
        }
    }
}