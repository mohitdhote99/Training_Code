package com.cart.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Shopping Cart Entity. 
 * This entity establish a one-to-many relationship with Products entity.
 * @author Harshit Srivastava
 * @version 1.0
 */
@Entity
@Table(name = "shoppingCart")
@ApiModel(description = "All details about the Shopping Cart")
public class ShoppingCart extends Audit implements Serializable {

	private static final long serialVersionUID = 1L;

	 /**
	 *  Using GenerationType.IDENTITY will indicate the persistence provider will assign 
	 * primary keys for this entity using a database identity column.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Auto Generated unique ID")
	private long cartId;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "currency")
	private String currency;
	
	/**
	 * Specifying a relationship to a collection of Products.
	 * A foreign key column 'productIdfk' will be created in Products
	 * table referring cartId of ShoppingCart table.
	 * NOTE: This is a unidirectional relationship
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "productIdfk", referencedColumnName = "cartId")
	private List<Products> products;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ShoppingCart [countryCode:" + countryCode + ", currency:" + currency + ", products:" + products + "]";
	}

}
