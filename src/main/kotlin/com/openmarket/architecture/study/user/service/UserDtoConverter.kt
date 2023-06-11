package com.openmarket.architecture.study.user.service

import com.openmarket.architecture.study.entity.User
import com.openmarket.architecture.study.entity.UserType
import com.openmarket.architecture.study.user.dto.CreateUserRequest
import com.openmarket.architecture.study.user.dto.UpdateUserRequest

class UserDtoConverter {
    fun convert(dtoRequest: CreateUserRequest): User {
        var userType = UserType.None

        if ("All".equals(dtoRequest.type)){
            userType = UserType.All
        }else if ("Buyer".equals(dtoRequest.type)){
            userType = UserType.Buyer
        }else if ("Seller".equals(dtoRequest.type)){
            userType = UserType.Seller
        }

        return User(
            id = null,
            password = dtoRequest.password,
            name = dtoRequest.name,
            email = dtoRequest.email,
            type = userType
        )

    }

    fun convert(dtoRequest: UpdateUserRequest): User {
        var userType = UserType.None

        if ("All".equals(dtoRequest.type)){
            userType = UserType.All
        }else if ("Buyer".equals(dtoRequest.type)){
            userType = UserType.Buyer
        }else if ("Seller".equals(dtoRequest.type)){
            userType = UserType.Seller
        }

        var id = -1L
        if (dtoRequest.id.isNotEmpty()){
            id = dtoRequest.id.toLong()
        }

        return User(
            id = id,
            password = dtoRequest.password,
            name = dtoRequest.name,
            email = dtoRequest.email,
            type = userType
        )

    }
}