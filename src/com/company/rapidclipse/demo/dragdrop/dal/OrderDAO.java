
package com.company.rapidclipse.demo.dragdrop.dal;

import com.xdev.dal.JPADAO;
import com.company.rapidclipse.demo.dragdrop.entities.Order;

/**
 * Home object for domain model class Order.
 * 
 * @see Order
 */
public class OrderDAO extends JPADAO<Order, Integer> {
	public OrderDAO() {
		super(Order.class);
	}
}