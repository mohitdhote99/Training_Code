package com.cart.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cart.demo.model.ShoppingCart;

/**
 * Repository to ShoppingCart Entity responsible for CRUD operations
 * @author Harshit Srivastava
 */
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{

	/**
	 * Custom method to fetch the details using cartId
	 * @param cartId
	 * @return ShoppingCart
	 */
	ShoppingCart findByCartId(Long cartId);
	
}
