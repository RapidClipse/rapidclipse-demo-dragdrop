
package com.company.rapidclipse.demo.dragdrop.dal;

import com.xdev.dal.JPADAO;
import com.company.rapidclipse.demo.dragdrop.entities.Supplier;

/**
 * Home object for domain model class Supplier.
 * 
 * @see Supplier
 */
public class SupplierDAO extends JPADAO<Supplier, Integer> {
	public SupplierDAO() {
		super(Supplier.class);
	}
}