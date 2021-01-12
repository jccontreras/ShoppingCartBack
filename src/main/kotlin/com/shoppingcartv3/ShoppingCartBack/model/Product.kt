package com.shoppingcartv3.ShoppingCartBack.model

import javax.persistence.*

/*
* Created by Ragnarok
* Product Table Model
* */
@Entity
@Table(name = "products")
data class Product(
    val name: String = "",
    val sku: Long = 0, val description: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}