package com.shoppingcartv3.ShoppingCartBack.web

import com.shoppingcartv3.ShoppingCartBack.business.cart.ICartBusiness
import com.shoppingcartv3.ShoppingCartBack.exception.BusinessException
import com.shoppingcartv3.ShoppingCartBack.exception.NotFoundException
import com.shoppingcartv3.ShoppingCartBack.model.Cart
import com.shoppingcartv3.ShoppingCartBack.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/*
* Created by Ragnarok
* Cart Rest Controller
* */
@RestController
@RequestMapping(Constants.URL_BASE_CARTS)
class CartRestController {

    @Autowired
    val cartBusiness: ICartBusiness? = null

    //Call to DB for load all Carts list
    @CrossOrigin
    @GetMapping("")
    fun list(): ResponseEntity<List<Cart>> {
        return try {
            ResponseEntity(cartBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for load a Cart
    @CrossOrigin
    @GetMapping("/{id}")
    fun load(@PathVariable("id") idCart: Long): ResponseEntity<Cart> {
        return try {
            ResponseEntity(cartBusiness!!.load(idCart), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //Call to DB for save a Cart
    @CrossOrigin
    @PostMapping("")
    fun insert(@RequestBody cart: Cart): ResponseEntity<Cart> {
        return try {
            cartBusiness!!.save(cart)
            val responeHeaders = HttpHeaders()
            responeHeaders.set("location", Constants.URL_BASE_CARTS + "/" + cart.id)
            ResponseEntity(responeHeaders, HttpStatus.CREATED)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for update a Cart
    @CrossOrigin
    @PutMapping("")
    fun update(@RequestBody cart: Cart): ResponseEntity<Any> {
        return try {
            cartBusiness!!.save(cart)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for delete a Cart
    @CrossOrigin
    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") idCart: Long): ResponseEntity<Any> {
        return try {
            cartBusiness!!.remove(idCart)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}