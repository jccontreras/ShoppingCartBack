package com.shoppingcartv3.ShoppingCartBack.business.productcart

import com.shoppingcartv3.ShoppingCartBack.model.Product_Cart


interface IProductCartBusiness {

    fun list(): List<Product_Cart>
    fun load(idProduct: Long, idCart: Long): List<Product_Cart>
    fun save(product_cart: Product_Cart): Product_Cart
    fun remove(idProduct: Long, idCart: Long)
}