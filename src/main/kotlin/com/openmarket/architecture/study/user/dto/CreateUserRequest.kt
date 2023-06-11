package com.openmarket.architecture.study.user.dto

data class CreateUserRequest(
    val type: String,
    val password: String,
    val email: String,
    val name: String
)