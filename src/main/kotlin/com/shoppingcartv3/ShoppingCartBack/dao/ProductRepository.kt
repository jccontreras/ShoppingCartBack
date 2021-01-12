package com.shoppingcartv3.ShoppingCartBack.dao

import com.shoppingcartv3.ShoppingCartBack.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/*
* Created by Ragnarok
* Product Repository
* */
@Repository
interface ProductRepository: JpaRepository<Product, Long> {
}