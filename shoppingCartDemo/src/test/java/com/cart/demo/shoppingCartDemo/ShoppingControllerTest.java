package com.cart.demo.shoppingCartDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.cart.demo.model.Products;
import com.cart.demo.model.ShoppingCart;
import com.cart.demo.repo.ProductsRepository;
import com.cart.demo.repo.ShoppingCartRepository;
import com.cart.demo.service.ShoppingCartService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class ShoppingControllerTest {
/*	
	@Mock
	ProductsRepository productsRepository;
	
	@Mock
	ShoppingCartRepository shoppingCartRepository;
	
	@Mock
	ShoppingCartService service;
	
	@Mock
	ShoppingController shoppingContoller;
	
	static ShoppingCart shoppingCart=new ShoppingCart();
	
	static MockHttpServletRequest requestMock;
	static MockHttpServletResponse responseMock;
   // AnnotationMethodHandlerAdapter handlerAdapter;
    static ObjectMapper mapper;
	
	@BeforeAll
	private static void setup() {
		requestMock = new MockHttpServletRequest();
        requestMock.setContentType(MediaType.APPLICATION_JSON_VALUE);
        requestMock.addHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        responseMock = new MockHttpServletResponse();
        mapper = new ObjectMapper();
        
		Products product=new Products();
		product.setCategory("Mobile");
		product.setDescription("Mobile Phone");
		product.setPrice(1000.0);
		List<Products> productList=new ArrayList<>();
		productList.add(product);
		shoppingCart.setCountryCode("IN");
		shoppingCart.setCurrency("INR");
		shoppingCart.setProducts(productList);
	}
	
	
	@Test
	public void createShoppingCartTest() throws Exception {
		requestMock.setMethod("POST");
	    requestMock.setRequestURI("/api/carts");
		doNothing().when(service).createShoppingCart(shoppingCart);
		service.createShoppingCart(shoppingCart);
		Mockito.when(shoppingContoller.createShoppingCart(shoppingCart)).thenReturn("Cart created successfully");
		assertEquals(shoppingContoller.createShoppingCart(shoppingCart), "Cart created successfully");
	}
*/
}
