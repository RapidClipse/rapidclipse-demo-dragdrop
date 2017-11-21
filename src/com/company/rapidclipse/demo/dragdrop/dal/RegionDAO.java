
package com.company.rapidclipse.demo.dragdrop.dal;

import com.company.rapidclipse.demo.dragdrop.entities.Region;
import com.xdev.dal.JPADAO;

/**
 * Home object for domain model class Region.
 * 
 * @see Region
 */
public class RegionDAO extends JPADAO<Region, Integer> {
	public RegionDAO() {
		super(Region.class);
	}
}