package com.shoppingcartv3.ShoppingCartBack.utils

/*
* Created by Ragnarok
* */
class Constants {

    companion object {
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION

        //url for products
        const val URL_BASE_PRODUCTS = "$URL_BASE/products"
        //url for cart
        const val URL_BASE_CARTS = "$URL_BASE/carts"
        //url for product_cart
        const val URL_BASE_PRODUCTCARTS = "$URL_BASE/productcarts"
    }
}