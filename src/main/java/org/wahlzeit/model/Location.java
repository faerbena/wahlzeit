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

}
