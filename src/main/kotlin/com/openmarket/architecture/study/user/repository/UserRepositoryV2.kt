package com.openmarket.architecture.study.user.repository

import com.openmarket.architecture.study.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepositoryV2 : JpaRepository<User, Long> {

}