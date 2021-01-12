package com.shoppingcartv3.ShoppingCartBack.dao

import com.shoppingcartv3.ShoppingCartBack.model.Product_Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/*
* Created by Ragnarok
* Product_Cart Repository
* */
@Repository
interface ProductCartRepository: JpaRepository<Product_Cart, Long> {
}