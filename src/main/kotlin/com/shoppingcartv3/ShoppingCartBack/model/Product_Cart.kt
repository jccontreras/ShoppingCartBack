package com.shoppingcartv3.ShoppingCartBack.model

import javax.persistence.*

/*
* Created by Ragnarok
* Product Table Model
* */

@Entity
@Table(name = "product_carts")
data class Product_Cart(
    val product_id: Long = 0,
    val cart_id: Long = 0,
    val quantity: Long = 0
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}