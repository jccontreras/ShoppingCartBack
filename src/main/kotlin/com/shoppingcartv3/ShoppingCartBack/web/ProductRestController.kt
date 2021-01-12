package com.shoppingcartv3.ShoppingCartBack.web

import com.shoppingcartv3.ShoppingCartBack.business.product.IProductBusiness
import com.shoppingcartv3.ShoppingCartBack.exception.BusinessException
import com.shoppingcartv3.ShoppingCartBack.exception.NotFoundException
import com.shoppingcartv3.ShoppingCartBack.model.Product
import com.shoppingcartv3.ShoppingCartBack.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/*
* Created by Ragnarok
* Product Rest Controller
* */
@RestController
@RequestMapping(Constants.URL_BASE_PRODUCTS)
class ProductRestController {

    @Autowired
    val productBusiness: IProductBusiness? = null

    //Call to DB for load all Product list
    @GetMapping("")
    fun list(): ResponseEntity<List<Product>> {
        return try {
            ResponseEntity(productBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for load a Product
    @GetMapping("/{id}")
    fun load(@PathVariable("id") idProduct: Long): ResponseEntity<Product> {
        return try {
            ResponseEntity(productBusiness!!.load(idProduct), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //Call to DB for save a Product
    @PostMapping("")
    fun insert(@RequestBody product: Product): ResponseEntity<Any> {
        return try {
            productBusiness!!.save(product)
            val responeHeaders = HttpHeaders()
            responeHeaders.set("location", Constants.URL_BASE_PRODUCTS + "/" + product.id)
            ResponseEntity(responeHeaders, HttpStatus.CREATED)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for update a Product
    @PutMapping("")
    fun update(@RequestBody product: Product): ResponseEntity<Any> {
        return try {
            productBusiness!!.save(product)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for delete a Product
    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") idProduct: Long): ResponseEntity<Any> {
        return try {
            productBusiness!!.remove(idProduct)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}