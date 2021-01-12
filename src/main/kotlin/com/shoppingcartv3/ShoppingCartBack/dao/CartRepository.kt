package com.shoppingcartv3.ShoppingCartBack.dao

import com.shoppingcartv3.ShoppingCartBack.model.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/*
* Created by Ragnarok
* Cart Repository
* */
@Repository
interface CartRepository: JpaRepository<Cart, Long> {
}