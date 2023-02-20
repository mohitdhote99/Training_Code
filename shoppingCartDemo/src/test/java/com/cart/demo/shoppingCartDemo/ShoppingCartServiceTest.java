package com.cart.demo.shoppingCartDemo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cart.demo.model.Products;
import com.cart.demo.model.ShoppingCart;
import com.cart.demo.repo.ProductsRepository;
import com.cart.demo.repo.ShoppingCartRepository;
import com.cart.demo.service.ShoppingCartService;

public class ShoppingCartServiceTest {
/*	
	@InjectMocks
	ShoppingCartService service;
	@Mock
	ProductsRepository prodRepo;
	@Mock
	ShoppingCartRepository cartRepo;
	@Mock
	ShoppingCart cart;
	@Mock
	Products prod;
	UUID pId = new UUID(3, 2);
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void testCart() {
		assertNotNull(service.getCart(1L));
		Mockito.when(cartRepo.existsById(1L)).thenReturn(true);
		assertTrue(service.cartExists(1L));
		Mockito.when(cartRepo.findByCartId(2L)).thenReturn(cart);
		assertNotNull(service.findByCartId(2L));
		Mockito.when(cartRepo.findAll()).thenReturn(new ArrayList<ShoppingCart>());
		assertNotNull(service.findCarts());
		service.saveCart(cart);
		service.createShoppingCart(cart);
		
	}
	@Test
	public void testProduct() {
		Mockito.when(prodRepo.existsById(pId)).thenReturn(true);
		assertTrue(service.productExists(pId));
		Mockito.when(prodRepo.findByProductId(pId)).thenReturn(new ArrayList<Products>());
		assertNotNull(service.findProductById(pId));
		assertNotNull(service.getProduct(pId));
		service.deleteProduct(prod);
		service.saveProduct(prod);
	}
*/
}
