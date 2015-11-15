package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Container;
import org.wahlzeit.services.DataObject;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Location extends DataObject {
	@Id private String name;
	@Container public Coordinate coordinate;
	
	/**
	 * @methodtype constructor
	 */
	public Location(String name) {
		this.name = name;
		coordinate = null;
	}

	/**
	 * @methodtype constructor
	 */
	public Location(String name, double latitude, double longitude) {
		this.name = name;
		this.coordinate = new SphericCoordinate(latitude,longitude);
	}
	
	/**
	 * @methodtype constructor
	 */
	public Location(String name, Coordinate c) {
		this.name = name;
		this.coordinate = c;
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @methodtype set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @methodtype get
	 */
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCoordinate(SphericCoordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * @methodtype set @methodproperty convenience
	 */
	public void setCoordinate(double latitude, double longitude) {
		SphericCoordinate coordinate = new SphericCoordinate(latitude,longitude);
		this.coordinate = coordinate;
	}
}
