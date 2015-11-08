package org.wahlzeit.model;

public class Location {
	private String name;
	public Coordinate coordinate;
	
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
		this.coordinate = new Coordinate(latitude,longitude);
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
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * @methodtype set @methodproperty convenience
	 */
	public void setCoordinate(double latitude, double longitude) {
		Coordinate coordinate = new Coordinate(latitude,longitude);
		this.coordinate = coordinate;
	}
}
