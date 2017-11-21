
package com.company.rapidclipse.demo.dragdrop.dal;

import com.company.rapidclipse.demo.dragdrop.entities.Orderdetail;
import com.company.rapidclipse.demo.dragdrop.entities.OrderdetailId;
import com.xdev.dal.JPADAO;

/**
 * Home object for domain model class Orderdetail.
 * 
 * @see Orderdetail
 */
public class OrderdetailDAO extends JPADAO<Orderdetail, OrderdetailId> {
	public OrderdetailDAO() {
		super(Orderdetail.class);
	}
}