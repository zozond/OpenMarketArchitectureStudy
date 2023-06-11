package com.openmarket.architecture.study.user.dto

import com.openmarket.architecture.study.entity.User

data class GetUserResponse(val success: Boolean, val user: User)