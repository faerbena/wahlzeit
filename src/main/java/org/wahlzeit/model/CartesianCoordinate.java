package org.wahlzeit.model;
import static java.lang.Math.*;

public class CartesianCoordinate extends AbstractCoordiante {
	private double x;
	private double y;
	private double z;

	/**
	 * @methodtype constructor 
	 */
	private CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static CartesianCoordinate getInstance(double x, double y, double z) {
		// Preconditions
		assertIsValidValue(x);
		assertIsValidValue(y);
		assertIsValidValue(z);
		
		CartesianCoordinate tmp = new CartesianCoordinate(x,y,z);
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
		return result.toCartesian();
	}
	
	/**
	 * @methodtype get
	 */	
	public double getX() {
		assertClassInvariants();
	
		return this.x;
	}
	
	/**
	 * @methodtype set
	 */	
	public CartesianCoordinate setX(double x) {	
		// Precondition
		assertIsValidValue(x);
		
		return getInstance(x, this.y, this.z);
	}
	
	/**
	 * @methodtype get
	 */	
	public double getY() {
		assertClassInvariants();
		
		return this.y;
	}
	
	/**
	 * @methodtype set
	 */	
	public CartesianCoordinate setY(double y) {
		// Precondition
		assertIsValidValue(y);
		
		return getInstance(this.x, y, this.z);
	}
	
	/**
	 * @methodtype get
	 */	
	public double getZ() {
		assertClassInvariants();
		
		return this.z;
	}
	
	/**
	 * @methodtype set
	 */	
	public CartesianCoordinate setZ(double z) {
		// Precondition
		assertIsValidValue(z);
		
		return getInstance(this.x, this.y, z);
	}

	@Override
	public CartesianCoordinate toCartesian() {
		return this;
	}

	@Override
	public SphericCoordinate toSpheric() {
		
		if (this.getX() == 0 && this.getY() == 0 && this.getZ() == 0) {
			return SphericCoordinate.getInstance(0,0,0);
		}
		double radius = sqrt(pow(this.getX(),2) + pow(this.getY(),2) + pow(this.getZ(),2));
		double latRad = acos(this.getZ()/radius);
		double longRad = atan2(this.getY(),this.getX());
		
		double latitude = toDegrees(latRad) % 90;
		double longitude = toDegrees(longRad) % 180;
		
		return SphericCoordinate.getInstance(latitude,longitude,radius);
	}
	
	@Override
	public void assertClassInvariants() {
		assertNotNull();
		
		assertIsValidValue(x);
		assertIsValidValue(y);
		assertIsValidValue(z);
	}	

}
