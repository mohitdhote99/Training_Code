/**
 * 
 */
package com.cart.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.demo.exception.ProductNotFoundException;
import com.cart.demo.model.Products;
import com.cart.demo.model.ShoppingCart;
import com.cart.demo.repo.ProductsRepository;
import com.cart.demo.repo.ShoppingCartRepository;
import com.cart.demo.validator.ShoppingCartValidator;

/**
 * The service file where all the repository CRUD operations are invoked
 * @author Harshit Srivastava
 * @version 1.0
 *
 */
@Service
public class ShoppingCartService {
	
	@Autowired
	ProductsRepository productsRepository;

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	ShoppingCartValidator shoppingCartValidator;

	public String createShoppingCart(ShoppingCart cart) {
		shoppingCartRepository.saveAndFlush(cart);
		return "Cart created successfully!";
	}

	public List<ShoppingCart> findCarts() {
		return shoppingCartRepository.findAll();
	}

	public boolean cartExists(Long cartId) {
		return shoppingCartRepository.existsById(cartId);
	}

	public Optional<ShoppingCart> getCart(Long cartId) {
		return shoppingCartRepository.findById(cartId);
	}

	public List<Products> findProductById(UUID productId) {
		return productsRepository.findByProductId(productId);
	}
	
	public ShoppingCart findByCartId(Long cartId) {
		return shoppingCartRepository.findByCartId(cartId);
	}

	public void saveCart(ShoppingCart shoppingCart) {
		shoppingCartRepository.save(shoppingCart);
	}

	public boolean productExists(UUID productId) {
		return productsRepository.existsById(productId);
	}

	public Optional<Products> getProduct(UUID productId) {
		return productsRepository.findById(productId);
	}

	public void deleteProduct(Products product) {
		productsRepository.delete(product);

	}
	public void saveProduct(Products product) {
		productsRepository.save(product);
	}
	
	/**
	 * This method invokes the validator to check if the input 
	 * productID is valid for the input cartID
	 * @param cartId
	 * @param productId
	 * @return boolean
	 */
	public boolean invokeValidator(Long cartId, UUID productId) {
		if (!shoppingCartValidator.cartIdProductIdValidation(cartId,productId)) {
			throw new ProductNotFoundException(
					"The productID: " + productId + " is not a valid ID for the provided cartID: " + cartId);
		}else {
			return true;
		}
		
	}

}
