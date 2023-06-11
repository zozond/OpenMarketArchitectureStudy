package com.openmarket.architecture.study.entity

import jakarta.persistence.*


@Entity
@Table(name="users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long?,
    var password: String,
    var name: String,
    var email: String,
    var type: UserType
)


enum class UserType{
    Seller,
    Buyer,
    All,
    None
}

val EMPTY_USER = User(
    id=null,
    name="emptyUser",
    password="emptyUserPassword",
    type=UserType.None,
    email="empty@empty"
)