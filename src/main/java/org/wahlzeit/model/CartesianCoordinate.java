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
	
		return this.x;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setX(double x) {
		assertClassInvariants();
		
		this.x = x;
		
		assertClassInvariants();
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
	public void setY(double y) {
		assertClassInvariants();
		
		this.y = y;
		
		assertClassInvariants();
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
	public void setZ(double z) {
		assertClassInvariants();
		
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

}
