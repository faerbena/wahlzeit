/**
 * 
 */
package org.wahlzeit.model;
import static java.lang.Math.*;

/**
 * @author faerbena
 *
 */
class SphericCoordinate implements Coordinate {
	private double latitude;
	private double longitude;
	private double radius = 6371000;

	/**
	 * @methodtype constructor @methodproperty convenience
	 */
	public SphericCoordinate(double latitude, double longitude) throws IllegalArgumentException {
		if (latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException(" The latitude needs to be between -90 and 90.");
		}
		if (longitude < -180 || latitude > 180) {
			throw new IllegalArgumentException(" The longitude needs to be between -180 and 180.");
		}
		if (radius < 0) {
			throw new IllegalArgumentException(" The radius needs to be greater than 0.");
		}
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @methodtype constructor 
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException {
		this(latitude, longitude);
		
		if (radius < 0) {
			throw new IllegalArgumentException(" The radius needs to be greater than 0.");
		}
		this.radius = radius;
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
	 * @methodtype get
	 */	
	public double getRadius() {
		return this.radius;
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
	 * @methodtype set
	 */	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getDistance(Coordinate c) {
		if (this.isEqual(c)) {
			return 0;
		}
		
		SphericCoordinate sc = c.toSpheric();
		
		// latitude and longitude of both Coordinates in Radiant
		double thisLatRad = toRadians(this.getLatitude());
		double thisLongRad = toRadians(this.getLongitude());
		double cLatRad = toRadians(sc.getLatitude());
		double cLongRad = toRadians(sc.getLongitude());
		
		double centralAngle = acos(sin(thisLatRad)*sin(cLatRad) + cos(thisLongRad)*cos(cLongRad)*cos(abs(thisLongRad-cLongRad)));
		return radius*centralAngle;
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLatitudinalDistance(SphericCoordinate c) {
		double dist = this.getLatitude() - c.getLatitude();
		return abs(dist);
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLongitudinalDistance(SphericCoordinate c) {
		double dist = this.getLongitude() - c.getLongitude();
		return abs(dist);
	}
	
	@Override	
	public boolean isEqual(Coordinate c) {
		SphericCoordinate sc = c.toSpheric();
		
		if (this.getLatitude() == sc.getLatitude() && this.getLongitude() == sc.getLongitude() && this.getRadius() == sc.getRadius()) {
			return true;
		}
		return false;
	}
	
	@Override
	public SphericCoordinate toSpheric() {	
		return this;
	}
	
	@Override
	public CartesianCoordinate toCartesian() {
		double x = this.getRadius() * sin(toRadians(this.getLatitude())) * cos(toRadians(this.getLongitude()));
		double y = this.getRadius() * sin(toRadians(this.getLatitude())) * sin(toRadians(this.getLongitude()));
		double z = this.getRadius() * cos(toRadians(this.getLatitude()));
		
		return new CartesianCoordinate(x, y, z);
	}

}
