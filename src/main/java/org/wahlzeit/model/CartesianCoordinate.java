package org.wahlzeit.model;
import static java.lang.Math.*;

public class CartesianCoordinate implements Coordinate {
	private double x;
	private double y;
	private double z;

	/**
	 * @methodtype constructor 
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * @methodtype get
	 */	
	public double getX() {
		return this.x;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * @methodtype get
	 */	
	public double getY() {
		return this.y;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @methodtype get
	 */	
	public double getZ() {
		return this.z;
	}
	
	/**
	 * @methodtype set
	 */	
	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public double getDistance(Coordinate c) {
		if (this.isEqual(c)) {
			return 0;
		}
		
		// convert both coordinates to spheric
		SphericCoordinate sThis = this.toSpheric();
		SphericCoordinate sc = c.toSpheric();
		
		// latitude and longitude of both Coordinates in Radiant
		double thisLatRad = toRadians(sThis.getLatitude());
		double thisLongRad = toRadians(sThis.getLongitude());
		double cLatRad = toRadians(sc.getLatitude());
		double cLongRad = toRadians(sc.getLongitude());
		
		double centralAngle = acos(sin(thisLatRad)*sin(cLatRad) + cos(thisLongRad)*cos(cLongRad)*cos(abs(thisLongRad-cLongRad)));
		return sThis.getRadius()*centralAngle;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		CartesianCoordinate cc = c.toCartesian();
		
		if (this.getX() == cc.getX() && this.getY() == cc.getY() && this.getZ() == cc.getZ()) {
			return true;
		}
		return false;
	}

	@Override
	public CartesianCoordinate toCartesian() {
		return this;
	}

	@Override
	public SphericCoordinate toSpheric() {
		if (this.getX() == 0 && this.getY() == 0 && this.getZ() == 0) {
			return new SphericCoordinate(0,0,0);
		}
		double radius = sqrt(pow(this.getX(),2) + pow(this.getY(),2) + pow(this.getZ(),2));
		double latRad = acos(this.getZ()/radius);
		double longRad = atan2(this.getY(),this.getX());
		
		double latitude = toDegrees(latRad) % 90;
		double longitude = toDegrees(longRad) % 180;
		
		return new SphericCoordinate(latitude,longitude,radius);
	}

}
