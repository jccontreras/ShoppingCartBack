package com.shoppingcartv3.ShoppingCartBack.business.productcart

import com.shoppingcartv3.ShoppingCartBack.dao.ProductCartRepository
import com.shoppingcartv3.ShoppingCartBack.exception.BusinessException
import com.shoppingcartv3.ShoppingCartBack.exception.NotFoundException
import com.shoppingcartv3.ShoppingCartBack.model.Product_Cart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.*

@Service
class ProductCartBusiness : IProductCartBusiness {

    @Autowired
    val productCartRepository: ProductCartRepository? = null

    //get all product_carts from DB
    @Throws(BusinessException::class)
    override fun list(): List<Product_Cart> {
        try {
            return productCartRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    //get all products into a cart from DB
    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idProduct: Long, idCart: Long): List<Product_Cart> {
        val op: List<Product_Cart>
        try {
          // Iterator<Product_Cart>
            //op = productCartRepository!!.findById(idCart)
            op = productCartRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isEmpty()) {
            throw NotFoundException("Not found products with product id $idProduct and cart id $idCart")
        }
        return op
    }

    // Save a Product_cart on DB
    @Throws(BusinessException::class)
    override fun save(productCart: Product_Cart): Product_Cart {
        try {
            return productCartRepository!!.save(productCart)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    //Delete a Product_Cart on DB
    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idProduct: Long, idCart: Long) {
        val op: Optional<Product_Cart>
        try {
            op = productCartRepository!!.findById(idCart)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("Not found product_cart with product id $idProduct and cart id $idCart")
        } else {
            try {
                return productCartRepository!!.deleteById(idCart)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}