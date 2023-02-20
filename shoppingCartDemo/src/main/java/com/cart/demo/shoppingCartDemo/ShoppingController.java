package com.cart.demo.shoppingCartDemo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.demo.exception.ProductNotFoundException;
import com.cart.demo.model.Products;
import com.cart.demo.model.ShoppingCart;
import com.cart.demo.service.ShoppingCartService;

/**
 * Shopping Cart Controller handles all the incoming request to path /api/... 
 * @author Harshit Srivastava
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class ShoppingController {

	@Autowired
	ShoppingCartService service;

	
	/**
	 * Create a shopping cart
	 * @param shoppingCart
	 */
	@PostMapping("/carts")
	public String createShoppingCart(@RequestBody ShoppingCart cart) {
		return service.createShoppingCart(cart);
	}

	/**
	 * Retrieve a shopping cart
	 * @return List of ShoppingCart
	 */
	@GetMapping("/carts")
	public List<ShoppingCart> getShoppingCart() {
		return service.findCarts();
	}
	
	/**
	 * Retrieve a shopping cart on cartId
	 * @param cartId
	 * @return ShoppingCart
	 */
	@GetMapping("/carts/{cartId}")
	public ShoppingCart getShoppingCartByCartId(@PathVariable Long cartId) {
		if (!service.cartExists(cartId)) {
			throw new ProductNotFoundException("CartId: " + cartId + " not found!");
		}
		return service.getCart(cartId)
				.orElseThrow(() -> new ProductNotFoundException("CartID: " + cartId + " not found!"));

	}

	/**
	 * Get ONLY the products of a shopping cart
	 * @param cartId
	 * @return List of Products
	 */
	@GetMapping("/carts/{cartId}/products")
	public List<Products> getAllProducts(@PathVariable Long cartId) {
		if (!service.cartExists(cartId)) {
			throw new ProductNotFoundException("CartId: " + cartId + " not found!");
		}
		return service.getCart(cartId).map(cart -> {
			return cart.getProducts();
		}).orElseThrow(() -> new ProductNotFoundException("CartID: " + cartId + " not found!"));

	}

	/**
	 * Get the product of a shopping cart
	 * @param cartId
	 * @param productId
	 * @return Product associated with the unique productId and cartId
	 */
	@GetMapping("/carts/{cartId}/products/{productId}")
	public List<Products> getProductFromShoppingCart(@PathVariable Long cartId, @PathVariable UUID productId) {
		List<Products> productList = null;
		service.invokeValidator(cartId, productId);
		productList = service.findProductById(productId);
		return productList;
	}
	
	/**
	 * Add a product to the cartId
	 * @param cartId
	 */

	@PostMapping("/carts/{cartId}/products")
	public String addProduct(@PathVariable Long cartId, @RequestBody Products[] products) {
		if (!service.cartExists(cartId)) {
			throw new ProductNotFoundException("CartId: " + cartId + " not found!");
		}
		ShoppingCart shoppingCart = service.findByCartId(cartId);
		List<Products> productList = service.getCart(cartId)
				.filter(cart -> !cart.getProducts().isEmpty()).map(cart -> cart.getProducts()).get();
		for (Products product : products) {
			productList.add(product);
		}
		shoppingCart.setProducts(productList);
		service.saveCart(shoppingCart);
		return "CartID: " + cartId + " updated successfully!";
	}

	/**
	 * Update an existing product of a cart
	 * @param cartId
	 * @param productId
	 */
	@PutMapping("/carts/{cartId}/products/{productId}")
	public String updateProduct(@PathVariable(value = "cartId") Long cartId,
			@PathVariable(value = "productId") UUID productId, @RequestBody Products productRequest) {
			service.invokeValidator(cartId, productId);
			return  service.getProduct(productId).map(product -> {
				product.setCategory(productRequest.getCategory());
				product.setDescription(productRequest.getDescription());
				product.setPrice(productRequest.getPrice());
				service.saveProduct(product);
				return "cartID: " + cartId + " with ProductID: " + productId + " updated successfully!";
			}).orElseThrow(() -> new ProductNotFoundException("ProductId " + productId + "not found"));
		
	}
	
	/**
	 * Remove a product from the cart
	 * @param cartId
	 * @param productId
	 */
	@DeleteMapping("/carts/{cartId}/products/{productId}")
	public String deleteCart(@PathVariable Long cartId, @PathVariable UUID productId) {

		if (!service.cartExists(cartId) && !service.productExists(productId)) {
			throw new ProductNotFoundException("Not found!");
		}
		return service.getProduct(productId).map(product -> {
			service.deleteProduct(product);
			return "Deleted Successfully!";
		}).orElseThrow(() -> new ProductNotFoundException("ProductId " + productId + "not found"));
	}

	
}
