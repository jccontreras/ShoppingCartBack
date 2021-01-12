package com.shoppingcartv3.ShoppingCartBack.model

import javax.persistence.*

/*
* Created by Ragnarok
* Cart Table Model
* */
@Entity
@Table(name = "carts")
data class Cart(
    val status: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}