package com.cart.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for the CRUD operations performed
 * @author Harshit Srivastava
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ProductNotFoundException not found")
public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
