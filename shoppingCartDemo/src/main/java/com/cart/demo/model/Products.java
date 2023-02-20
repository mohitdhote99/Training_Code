package com.cart.demo.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Products Entity. 
 * @author Harshit Srivastava
 * @version 1.0
 */
@Entity
@Table(name = "Products")
@ApiModel(description = "All details about the Products in the Shopping Cart")
public class Products extends Audit implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 *  Using a UUID generator will generate a unique UUID and this UUID 
	 *  will be used as a primary key identifier for Products
	 *  Example: 123e4567-e89b-12d3-a456-426614174000
	 */
	@Id
    @GeneratedValue(generator = "UUID")
	@GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
	@ApiModelProperty(notes = "Auto Generated unique 36-char UUID ")
	private UUID productId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private double price;
	
	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [productId:" + productId + ", description:" + description + ", category:" + category
				+ ", price:" + price + "]";
	}


}
