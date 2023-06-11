package com.openmarket.architecture.study.user.dto

data class UpdateUserRequest(
    val id: String,
    val type: String,
    val password: String,
    val email: String,
    val name: String
)
