package com.shoppingcartv3.ShoppingCartBack.business.cart

import com.shoppingcartv3.ShoppingCartBack.dao.CartRepository
import com.shoppingcartv3.ShoppingCartBack.exception.BusinessException
import com.shoppingcartv3.ShoppingCartBack.exception.NotFoundException
import com.shoppingcartv3.ShoppingCartBack.model.Cart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.*

@Service
class CartBusiness : ICartBusiness {

    @Autowired
    val cartRepository: CartRepository? = null

    //get all carts from DB
    @Throws(BusinessException::class)
    override fun list(): List<Cart> {
        try {
            return cartRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    //get one cart from DB
    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idCart: Long): Cart {
        val op: Optional<Cart>
        try {
            op = cartRepository!!.findById(idCart)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("Not found product with id $idCart")
        }
        return op.get()
    }

    // Save a Cart on DB
    @Throws(BusinessException::class)
    override fun save(cart: Cart): Cart {
        try {
            return cartRepository!!.save(cart)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    //Delete a Cart on DB
    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idCart: Long) {
        val op: Optional<Cart>
        try {
            op = cartRepository!!.findById(idCart)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("Not found product with id $idCart")
        } else {
            try {
                return cartRepository!!.deleteById(idCart)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}