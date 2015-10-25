/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author faerbena
 *
 */
class Coordinate {
	private double latitude;
	private double longitude;

	/**
	 * @methodtype constructor
	 */
	public Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return this.latitude;
	}

	/**
	 * @methodtype get
	 */	
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * @methodtype query
	 */	
	public Coordinate getDistance(Coordinate c) {
		double latitudinalDistance = getLatitudinalDistance(c);
		double longitudinalDistance = getLongitudinalDistance(c);
		Coordinate distance = new Coordinate(latitudinalDistance, longitudinalDistance);
		return distance;
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLatitudinalDistance(Coordinate c) {
		double latitudinalDistance = this.getLatitude() - c.getLatitude();
		return latitudinalDistance;
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLongitudinalDistance(Coordinate c) {
		double longitudinalDistance = this.getLongitude() - c.getLongitude();
		return longitudinalDistance;
	}
	
	/**
	 * @methodtype boolean-query
	 */		
	public boolean isEqualTo(Coordinate c) {
		if (this.getLatitude() == c.getLatitude() && this.getLongitude() == c.getLongitude()) {
			return true;
		}
		return false;
	}

}
