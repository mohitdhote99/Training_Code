package com.cart.demo.validator;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cart.demo.exception.ProductNotFoundException;
import com.cart.demo.model.Products;
import com.cart.demo.service.ShoppingCartService;

/**
 * This validator validates the inputs(cartID and productID) provided by user and checks if they're valid or not
 * @author Harshit Srivastava
 */
@Component
public class ShoppingCartValidator {
	
	@Autowired
	ShoppingCartService service;
	
	/**
	 * Validates if the input productId is one the subset of the input cartId
	 * @param cartId
	 * @param productId
	 */
	public boolean cartIdProductIdValidation(Long cartId, UUID productId) {
		boolean isValid = false;
		if (!service.cartExists(cartId) && !service.productExists(productId)) {
			throw new ProductNotFoundException("Not found!");
		} else {
			List<Products> products = service.getCart(cartId).map(cart -> cart.getProducts()).get();
			for (Products product : products) {
				UUID tempProductId = product.getProductId();
				if (tempProductId.equals(productId)) {
					isValid = true;
					break;
				}
			}
		}
		return isValid;
	}

}
