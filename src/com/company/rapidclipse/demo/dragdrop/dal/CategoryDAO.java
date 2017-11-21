
package com.company.rapidclipse.demo.dragdrop.dal;

import com.xdev.dal.JPADAO;
import com.company.rapidclipse.demo.dragdrop.entities.Category;

/**
 * Home object for domain model class Category.
 * 
 * @see Category
 */
public class CategoryDAO extends JPADAO<Category, Integer> {
	public CategoryDAO() {
		super(Category.class);
	}
}