
package com.company.rapidclipse.demo.dragdrop.dal;

import com.company.rapidclipse.demo.dragdrop.entities.Territory;
import com.xdev.dal.JPADAO;

/**
 * Home object for domain model class Territory.
 * 
 * @see Territory
 */
public class TerritoryDAO extends JPADAO<Territory, String> {
	public TerritoryDAO() {
		super(Territory.class);
	}
}