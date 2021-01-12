package com.shoppingcartv3.ShoppingCartBack.business.product

import com.shoppingcartv3.ShoppingCartBack.model.Product


interface IProductBusiness {

    fun list(): List<Product>
    fun load(idProduct: Long): Product
    fun save(product: Product): Product
    fun remove(idProduct: Long)
}