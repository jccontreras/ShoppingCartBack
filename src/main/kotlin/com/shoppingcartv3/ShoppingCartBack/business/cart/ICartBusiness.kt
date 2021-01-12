package com.shoppingcartv3.ShoppingCartBack.business.cart

import com.shoppingcartv3.ShoppingCartBack.model.Cart

interface ICartBusiness {

    fun list(): List<Cart>
    fun load(idCart: Long): Cart
    fun save(cart: Cart): Cart
    fun remove(idCart: Long)
}