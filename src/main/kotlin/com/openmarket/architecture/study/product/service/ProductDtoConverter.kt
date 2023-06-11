package com.openmarket.architecture.study.product.service

import com.openmarket.architecture.study.entity.Product
import com.openmarket.architecture.study.product.dto.ProductRegisterRequest
import com.openmarket.architecture.study.product.dto.ProductUpdateRequest

class ProductDtoConverter {
    fun convert(productRegisterRequest: ProductRegisterRequest): Product{

        return Product(
            productId = null,
            name = productRegisterRequest.name,
            price = productRegisterRequest.price,
            description = productRegisterRequest.description
        )
    }

    fun convert(productUpdateRequest: ProductUpdateRequest): Product{

        return Product(
            productId = productUpdateRequest.productId,
            name = productUpdateRequest.name,
            price = productUpdateRequest.price,
            description = productUpdateRequest.description
        )
    }
}