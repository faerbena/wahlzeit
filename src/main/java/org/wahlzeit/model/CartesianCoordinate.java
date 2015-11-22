package org.wahlzeit.model;
import static java.lang.Math.*;

public class CartesianCoordinate extends AbstractCoordiante {
	private double x;
	private double y;
	private double z;

	/**
	 * @methodtype constructor 
	 */
	public CartesianCoordinate(double x, double y, double z) {
		assertClassInvariants();
		
		// Preconditions
		assertIsValidValue(x);
		assertIsValidValue(y);
		assertIsValidValue(z);
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype get
	 */	
	public double getX() {
		assertClassInvariants();
		
		// Postcondition
		assertIsValidValue(this.x);
	
		return this.x;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setX(double x) {
		assertClassInvariants();
		
		// Precondition
		assertIsValidValue(x);
		
		this.x = x;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype get
	 */	
	public double getY() {
		assertClassInvariants();
		
		// Postcondition
		assertIsValidValue(this.y);
		
		return this.y;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setY(double y) {
		assertClassInvariants();
		
		// Precondition
		assertIsValidValue(y);
		
		this.y = y;
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype get
	 */	
	public double getZ() {
		assertClassInvariants();
		
		// Postcondition
		assertIsValidValue(this.x);
		
		return this.z;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setZ(double z) {
		assertClassInvariants();
		
		// Precondition
		assertIsValidValue(z);
		
		this.z = z;
		
		assertClassInvariants();
	}

//	@Override
//	public CartesianCoordinate toCartesian() {
//		return this;
//	}

	@Override
	public SphericCoordinate toSpheric() {
		assertClassInvariants();
		
		if (this.getX() == 0 && this.getY() == 0 && this.getZ() == 0) {
			return new SphericCoordinate(0,0,0);
		}
		double radius = sqrt(pow(this.getX(),2) + pow(this.getY(),2) + pow(this.getZ(),2));
		double latRad = acos(this.getZ()/radius);
		double longRad = atan2(this.getY(),this.getX());
		
		double latitude = toDegrees(latRad) % 90;
		double longitude = toDegrees(longRad) % 180;
		
		assertClassInvariants();
		
		return new SphericCoordinate(latitude,longitude,radius);
	}
	
	@Override
	public void assertClassInvariants() {
		assertNotNull();
		
		assertIsValidValue(x);
		assertIsValidValue(y);
		assertIsValidValue(z);
	}	

}
