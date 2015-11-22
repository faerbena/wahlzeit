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
		assertClassInvariants();
		
		this.latitude = latitude;
		this.longitude = longitude;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype constructor 
	 */
	public SphericCoordinate(double latitude, double longitude, double radius){
		this(latitude, longitude);
		
		assertClassInvariants();

		this.radius = radius;
		
		assertClassInvariants();
	}	
	
	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		assertClassInvariants();
		
		return this.latitude;
	}

	/**
	 * @methodtype get
	 */	
	public double getLongitude() {
		assertClassInvariants();
		
		return this.longitude;
	}
	
	/**
	 * @methodtype get
	 */	
	public double getRadius() {
		assertClassInvariants();
		
		return this.radius;
	}	
	
	/**
	 * @methodtype set
	 */	
	public void setLatitude(double latitude) {
		assertClassInvariants();
		
		this.latitude = latitude;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 */	
	public void setLongitude(double longitude) {
		assertClassInvariants();
		
		this.longitude = longitude;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 */	
	public void setRadius(double radius) {
		assertClassInvariants();
		
		this.radius = radius;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLatitudinalDistance(SphericCoordinate c) {
		assertClassInvariants();
		
		double dist = this.getLatitude() - c.getLatitude();
		
		assertClassInvariants();
		
		return abs(dist);
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLongitudinalDistance(SphericCoordinate c) {
		assertClassInvariants();
		
		double dist = this.getLongitude() - c.getLongitude();
		
		assertClassInvariants();
		
		return abs(dist);
	}
	
	@Override
	public SphericCoordinate toSpheric() {	
		assertClassInvariants();
		
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
	
	@Override
	public void assertClassInvariants() {
		assertNotNull();
		
		assertIsValidLatitude();
		assertIsValidLongitude();
		assertIsValidRadius();
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	private void assertIsValidLatitude() throws IllegalArgumentException {
		if (latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException("The latitude needs to be between -90 and 90.");
		}
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	private void assertIsValidLongitude() throws IllegalArgumentException {
		if (longitude < -180 || latitude > 180) {
			throw new IllegalArgumentException("The longitude needs to be between -180 and 180.");
		}
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	private void assertIsValidRadius() throws IllegalArgumentException {
		if (radius < 0) {
			throw new IllegalArgumentException("The radius needs to be greater than 0.");
		}
	}	
}
