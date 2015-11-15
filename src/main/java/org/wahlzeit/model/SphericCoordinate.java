/**
 * 
 */
package org.wahlzeit.model;
import static java.lang.Math.*;

/**
 * @author faerbena
 *
 */
class SphericCoordinate extends AbstractCoordiante {
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
	public SphericCoordinate toSpheric() {	
		return this;
	}
	
//	@Override
//	public CartesianCoordinate toCartesian() {
//		double x = this.getRadius() * sin(toRadians(this.getLatitude())) * cos(toRadians(this.getLongitude()));
//		double y = this.getRadius() * sin(toRadians(this.getLatitude())) * sin(toRadians(this.getLongitude()));
//		double z = this.getRadius() * cos(toRadians(this.getLatitude()));
//		
//		return new CartesianCoordinate(x, y, z);
//	}

}
