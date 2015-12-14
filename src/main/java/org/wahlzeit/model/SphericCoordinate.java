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
	 * @methodtype constructor 
	 */
	private SphericCoordinate(double latitude, double longitude, double radius){
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	public static SphericCoordinate getInstance(double latitude, double longitude, double radius) {
		// Preconditions
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		
		SphericCoordinate tmp = new SphericCoordinate(latitude,longitude,radius);
		Coordinate result;
		if (instances.containsKey(tmp.hashCode())) {
			result = instances.get(tmp.hashCode());
		} else {
			synchronized(instances) {
				if (instances.containsKey(tmp.hashCode())) {
					result = instances.get(tmp.hashCode());
				} else {
					instances.put(tmp.hashCode(),tmp);
					result = tmp;
				}
			}
		}
		
		result.assertClassInvariants();
		return result.toSpheric();
	}
	
	/**
	 * @methodproperty convenience
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude) {
		return getInstance(latitude, longitude, 6371000);
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
	public SphericCoordinate setLatitude(double latitude) {
		// Precondition
		assertIsValidLatitude(latitude);
		
		return getInstance(latitude, this.longitude, this.radius);
	}
	
	/**
	 * @methodtype set
	 */	
	public SphericCoordinate setLongitude(double longitude) {
		// Precondition
		assertIsValidLongitude(longitude);
		
		return getInstance(this.latitude, longitude, this.radius);
	}
	
	/**
	 * @methodtype set
	 */	
	public SphericCoordinate setRadius(double radius) {
		// Precondition
		assertIsValidRadius(radius);
		
		return getInstance(this.latitude, this.longitude, radius);
	}
	
	/**
	 * @methodtype query
	 */	
	public double getLatitudinalDistance(SphericCoordinate c) {
		
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
	
	@Override
	public CartesianCoordinate toCartesian() {
		double x = this.getRadius() * sin(toRadians(this.getLatitude())) * cos(toRadians(this.getLongitude()));
		double y = this.getRadius() * sin(toRadians(this.getLatitude())) * sin(toRadians(this.getLongitude()));
		double z = this.getRadius() * cos(toRadians(this.getLatitude()));
		
		return CartesianCoordinate.getInstance(x, y, z);
	}
	
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
	private static void assertIsValidLatitude(double lat) throws IllegalArgumentException {
		assertIsValidValue(lat);
		
		if (lat < -90 || lat > 90) {
			throw new IllegalArgumentException("The latitude needs to be between -90 and 90.");
		}
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	private static void assertIsValidLongitude(double lon) throws IllegalArgumentException {
		assertIsValidValue(lon);
		
		if (lon < -180 || lon > 180) {
			throw new IllegalArgumentException("The longitude needs to be between -180 and 180.");
		}
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	private static void assertIsValidRadius(double rad) throws IllegalArgumentException {
		assertIsValidValue(rad);
		
		if (rad < 0) {
			throw new IllegalArgumentException("The radius needs to be greater than 0.");
		}
	}	
}
