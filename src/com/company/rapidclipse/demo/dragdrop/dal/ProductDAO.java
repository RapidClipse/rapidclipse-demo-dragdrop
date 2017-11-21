
package com.company.rapidclipse.demo.dragdrop.dal;

import com.xdev.dal.JPADAO;
import com.company.rapidclipse.demo.dragdrop.entities.Product;

/**
 * Home object for domain model class Product.
 * 
 * @see Product
 */
public class ProductDAO extends JPADAO<Product, Integer> {
	public ProductDAO() {
		super(Product.class);
	}
}