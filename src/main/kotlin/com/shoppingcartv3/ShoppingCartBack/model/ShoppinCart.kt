package com.shoppingcartv3.ShoppingCartBack.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class ShoppinCart (
    val quantity: Long = 0,
    val sku: Long = 0,
    val productname: String = ""
        ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}