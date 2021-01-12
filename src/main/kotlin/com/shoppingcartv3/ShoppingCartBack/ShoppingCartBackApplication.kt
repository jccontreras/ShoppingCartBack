package com.shoppingcartv3.ShoppingCartBack

import com.shoppingcartv3.ShoppingCartBack.dao.CartRepository
import com.shoppingcartv3.ShoppingCartBack.dao.ProductCartRepository
import com.shoppingcartv3.ShoppingCartBack.dao.ProductRepository
import com.shoppingcartv3.ShoppingCartBack.model.Cart
import com.shoppingcartv3.ShoppingCartBack.model.Product
import com.shoppingcartv3.ShoppingCartBack.model.Product_Cart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShoppingCartBackApplication: CommandLineRunner {

	@Autowired
	val productRepository: ProductRepository? = null
	@Autowired
	val cartRepository: CartRepository? = null
	@Autowired
	val productCarRepository: ProductCartRepository? = null
	override fun run(vararg args: String?) {
		val product1 = Product("laptop", 123, "Asus Core i7")
		productRepository!!.save(product1)
		val cart1 = Cart("pending")
		cartRepository!!.save(cart1)
		val productcart1 = Product_Cart(1, 1, 0)
		productCarRepository!!.save(productcart1)
	}

}

fun main(args: Array<String>) {
	runApplication<ShoppingCartBackApplication>(*args)
}
