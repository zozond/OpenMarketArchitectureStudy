package com.openmarket.architecture.study.user.controller

import com.openmarket.architecture.study.entity.EMPTY_USER
import com.openmarket.architecture.study.user.dto.CreateUserRequest
import com.openmarket.architecture.study.user.dto.GetUserResponse
import com.openmarket.architecture.study.user.dto.UpdateUserRequest
import com.openmarket.architecture.study.user.service.UserDtoConverter
import com.openmarket.architecture.study.user.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService){

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") userId: Long): GetUserResponse{
        /**
         * 유저 정보 조회
         */
        val isSuccess = when (userService.getUser(userId)) {
            EMPTY_USER -> false
            else -> true
        }

        return GetUserResponse(isSuccess, userService.getUser(userId))
    }

    @PostMapping
    fun createUser(@RequestBody body: CreateUserRequest): GetUserResponse{
        /**
         * 유저 생성
         */
        val userDtoConverter = UserDtoConverter()
        return GetUserResponse(true, userService.createUser(userDtoConverter.convert(body)))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") userId: Long): GetUserResponse{
        /**
         * 유저 삭제
         */
        return GetUserResponse(true, userService.deleteUser(userId))
    }

    @PutMapping
    fun updateUser(@RequestBody body: UpdateUserRequest): GetUserResponse{
        /**
         * 유저 정보 변경
         */
        val userDtoConverter = UserDtoConverter()
        return GetUserResponse(true, userService.updateUser(userDtoConverter.convert(body)))
    }
}
