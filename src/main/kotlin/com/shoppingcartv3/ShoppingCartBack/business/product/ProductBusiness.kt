package com.shoppingcartv3.ShoppingCartBack.business.product

import com.shoppingcartv3.ShoppingCartBack.exception.BusinessException
import com.shoppingcartv3.ShoppingCartBack.exception.NotFoundException
import com.shoppingcartv3.ShoppingCartBack.dao.ProductRepository
import com.shoppingcartv3.ShoppingCartBack.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.*
import java.util.*

@Service
class ProductBusiness : IProductBusiness {

    @Autowired
    val productRepository: ProductRepository? = null

    //get all products from DB
    @Throws(BusinessException::class)
    override fun list(): List<Product> {
        try {
            return productRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    //get one product from DB
    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idProduct: Long): Product {
        val op: Optional<Product>
        try {
            op = productRepository!!.findById(idProduct)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("Not found product with id $idProduct")
        }
        return op.get()
    }

    // Save Prodcut on DB
    @Throws(BusinessException::class)
    override fun save(product: Product): Product {
        try {
            return productRepository!!.save(product)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    //Delete a product on DB
    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idProduct: Long) {
        val op: Optional<Product>
        try {
            op = productRepository!!.findById(idProduct)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("Not found product with id $idProduct")
        } else {
            try {
                return productRepository!!.deleteById(idProduct)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}