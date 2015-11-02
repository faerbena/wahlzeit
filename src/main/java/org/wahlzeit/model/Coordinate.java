/**
 * 
 */
package org.wahlzeit.model;
import static java.lang.Math.*;

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
	public Coordinate(double latitude, double longitude) throws IllegalArgumentException {
		if (latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException(" The latitude needs to be between -90 and 90.");
		}
		if (longitude < -180 || latitude > 180) {
			throw new IllegalArgumentException(" The longitude needs to be between -180 and 180.");
		}
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
	public double getDistance(Coordinate c) {
		if (this.isEqual(c)) {
			return 0;
		}
		// latitude and longitude of both Coordinates in Radiant
		double thisLatRad = PI*this.getLatitude()/180;
		double thisLongRad = PI*this.getLongitude()/180;
		double cLatRad = PI*c.getLatitude()/180;
		double cLongRad = PI*c.getLongitude()/180;
		
		double centralAngle = acos(sin(thisLatRad)*sin(cLatRad) + cos(thisLongRad)*cos(cLongRad)*cos(abs(thisLongRad-cLongRad)));
		return 6371000*centralAngle;
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLatitudinalDistance(Coordinate c) {
		double dist = this.getLatitude() - c.getLatitude();
		return abs(dist);
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLongitudinalDistance(Coordinate c) {
		double dist = this.getLongitude() - c.getLongitude();
		return abs(dist);
	}
	
	/**
	 * @methodtype boolean-query
	 */		
	public boolean isEqual(Coordinate c) {
		if (this.getLatitude() == c.getLatitude() && this.getLongitude() == c.getLongitude()) {
			return true;
		}
		return false;
	}

}
