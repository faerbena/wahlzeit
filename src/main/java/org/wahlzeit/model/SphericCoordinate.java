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
		
		// Preconditions
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		
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
		
		// Precondition
		assertIsValidRadius(radius);

		this.radius = radius;
		
		assertClassInvariants();
	}	
	
	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		assertClassInvariants();
		
		// Postcondition
		assertIsValidLatitude(this.latitude);
		
		return this.latitude;
	}

	/**
	 * @methodtype get
	 */	
	public double getLongitude() {
		assertClassInvariants();
		
		// Postcondition
		assertIsValidLongitude(this.longitude);
		
		return this.longitude;
	}
	
	/**
	 * @methodtype get
	 */	
	public double getRadius() {
		assertClassInvariants();
		
		// Postcondition
		assertIsValidRadius(this.radius);
		
		return this.radius;
	}	
	
	/**
	 * @methodtype set
	 */	
	public void setLatitude(double latitude) {
		assertClassInvariants();
		
		// Precondition
		assertIsValidLatitude(latitude);
		
		this.latitude = latitude;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 */	
	public void setLongitude(double longitude) {
		assertClassInvariants();
		
		// Precondition
		assertIsValidLongitude(longitude);
		
		this.longitude = longitude;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 */	
	public void setRadius(double radius) {
		assertClassInvariants();
		
		// Precondition
		assertIsValidRadius(radius);
		
		this.radius = radius;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLatitudinalDistance(SphericCoordinate c) {
		assertClassInvariants();
		
		double dist = abs(this.getLatitude() - c.getLatitude());
		
		// Postcondition
		assert (dist >= 0);
		
		assertClassInvariants();
		
		return dist;
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLongitudinalDistance(SphericCoordinate c) {
		assertClassInvariants();
		
		double dist = abs(this.getLongitude() - c.getLongitude());

		// Postcondition
		assert (dist >= 0);
		
		assertClassInvariants();
		
		return dist;
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
		
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	private void assertIsValidLatitude(double lat) throws IllegalArgumentException {
		assertIsValidValue(lat);
		
		if (lat < -90 || lat > 90) {
			throw new IllegalArgumentException("The latitude needs to be between -90 and 90.");
		}
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	private void assertIsValidLongitude(double lon) throws IllegalArgumentException {
		assertIsValidValue(lon);
		
		if (lon < -180 || lon > 180) {
			throw new IllegalArgumentException("The longitude needs to be between -180 and 180.");
		}
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	private void assertIsValidRadius(double rad) throws IllegalArgumentException {
		assertIsValidValue(rad);
		
		if (rad < 0) {
			throw new IllegalArgumentException("The radius needs to be greater than 0.");
		}
	}	
}
