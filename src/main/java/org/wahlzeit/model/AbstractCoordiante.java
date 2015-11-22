package org.wahlzeit.model;

import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import org.wahlzeit.services.DataObject;

public abstract class AbstractCoordiante extends DataObject implements Coordinate {

	private static final double DELTA = 0.00001; // constant for comparing double values
	/**
	 * @methodtype composed-conversion
	 */	
	@Override
	public double getDistance(Coordinate c) throws IllegalArgumentException {
		assertClassInvariants();
		
		if (this.isEqual(c)) {
			return 0;
		}
		
		// convert both coordinates to spheric
		SphericCoordinate sThis = this.toSpheric();
		SphericCoordinate sc = c.toSpheric();
		
		// 
		if (sThis.getRadius() != sc.getRadius()) {
			throw new IllegalArgumentException("The radiuses must match to calculate the great-circle distance.");
		}
		
		// latitude and longitude of both Coordinates in Radiant
		double thisLatRad = toRadians(sThis.getLatitude());
		double thisLongRad = toRadians(sThis.getLongitude());
		double cLatRad = toRadians(sc.getLatitude());
		double cLongRad = toRadians(sc.getLongitude());
		
		double centralAngle = acos(sin(thisLatRad)*sin(cLatRad) + cos(thisLongRad)*cos(cLongRad)*cos(abs(thisLongRad-cLongRad)));
		
		assertClassInvariants();
		
		return sThis.getRadius()*centralAngle;
	}

	/**
	 * @methodtype composed-conversion
	 */		
	@Override
	public boolean isEqual(Coordinate c) {
		assertClassInvariants();
		
		SphericCoordinate sThis = this.toSpheric();
		SphericCoordinate sc = c.toSpheric();
		
		assertClassInvariants();
		
		if (abs(sThis.getLatitude() - sc.getLatitude()) < DELTA 
				&& abs(sThis.getLongitude() - sc.getLongitude()) < DELTA 
				&& abs(sThis.getRadius() - sc.getRadius()) < DELTA) {
			return true;
		}
		return false;
	}

//	@Override
//	abstract public CartesianCoordinate toCartesian();

	@Override
	abstract public SphericCoordinate toSpheric();

	@Override
	public void assertClassInvariants() {
		assertNotNull();
	}
	
	/**
	 * @methodtype assertion-helper
	 */	
	protected void assertNotNull() throws NullPointerException {
		assert (this != null);
	}

}
