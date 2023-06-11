package com.openmarket.architecture.study.user.service

import com.openmarket.architecture.study.entity.EMPTY_USER
import com.openmarket.architecture.study.entity.User
import com.openmarket.architecture.study.entity.UserType
import com.openmarket.architecture.study.user.repository.UserRepositoryV2
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepositoryV2){

    fun getUser(id: Long): User{
        val user = userRepository.findById(id)

        return if (user.isEmpty){
            EMPTY_USER
        }else{
            user.get()
        }
    }

    fun createUser(user: User): User{
        return userRepository.save(user)
    }

    fun deleteUser(id: Long): User{
        val user = userRepository.findById(id)
        userRepository.deleteById(id)

        return if (user.isEmpty){
            EMPTY_USER
        }else{
            user.get()
        }
    }

    fun updateUser(user: User): User{
        return userRepository.save(user)
    }

    fun isAvailableToOrder(userId: Long): Boolean{
        val user = userRepository.findById(userId)

        return if (user.isEmpty){
            false
        }else if(user.get().type == UserType.Buyer || user.get().type == UserType.All){
            true
        }else{
            false
        }
    }
}