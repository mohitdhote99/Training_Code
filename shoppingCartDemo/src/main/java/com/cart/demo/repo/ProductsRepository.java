package com.cart.demo.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.demo.model.Products;

/**
 * Repository to Products Entity responsible for CRUD operations
 * @author Harshit Srivastava
 */
@Repository
public interface ProductsRepository extends JpaRepository<Products, UUID>{
	
	/**
	 * Custom method to fetch the details using productID
	 * @param productId
	 * @return List<Products>
	 */
	List<Products> findByProductId(UUID productId);
	
}
