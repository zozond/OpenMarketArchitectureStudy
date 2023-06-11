package com.openmarket.architecture.study.product.controller

import com.openmarket.architecture.study.entity.EMPTY_PRODUCT
import com.openmarket.architecture.study.product.dto.ProductControllerResponse
import com.openmarket.architecture.study.product.dto.ProductRegisterRequest
import com.openmarket.architecture.study.product.dto.ProductUpdateRequest
import com.openmarket.architecture.study.product.service.ProductDtoConverter
import com.openmarket.architecture.study.product.service.ProductService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService){
    @GetMapping("/{productId}")
    fun getProduct(@PathVariable("productId") productId: Long): ProductControllerResponse {
        /**
         * 상품 조회
         */

        val isSuccess = when (productService.getProductInfo(productId)) {
            EMPTY_PRODUCT -> false
            else -> true
        }
        return ProductControllerResponse(isSuccess, productService.getProductInfo(productId))
    }

    
    @PostMapping
    fun registerProduct(@RequestBody body: ProductRegisterRequest): ProductControllerResponse {
        /**
         * 상품 등록
         */
        val productDtoConverter = ProductDtoConverter()
        return ProductControllerResponse(true, productService.register(productDtoConverter.convert(body)))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: Long): ProductControllerResponse {
        /**
         * 상품 삭제
         */
        return ProductControllerResponse(true, productService.deleteProduct(id))
    }

    @PutMapping
    fun updateProduct(@RequestBody body: ProductUpdateRequest): ProductControllerResponse {
        /**
         * 상품 정보 변경
         */
        val productDtoConverter = ProductDtoConverter()
        return ProductControllerResponse(true, productService.updateProduct(productDtoConverter.convert(body)))
    }
}