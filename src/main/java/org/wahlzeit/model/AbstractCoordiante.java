package org.wahlzeit.model;

import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import org.wahlzeit.services.DataObject;

public abstract class AbstractCoordiante extends DataObject implements Coordinate {

	/**
	 * @methodtype composed-conversion
	 */	
	@Override
	public double getDistance(Coordinate c) throws IllegalArgumentException {
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
		return sThis.getRadius()*centralAngle;
	}

	/**
	 * @methodtype composed-conversion
	 */		
	@Override
	public boolean isEqual(Coordinate c) {
		SphericCoordinate sThis = this.toSpheric();
		SphericCoordinate sc = c.toSpheric();
		
		if (sThis.getLatitude() == sc.getLatitude() && sThis.getLongitude() == sc.getLongitude() && sThis.getRadius() == sc.getRadius()) {
			return true;
		}
		return false;
	}

//	@Override
//	abstract public CartesianCoordinate toCartesian();

	@Override
	abstract public SphericCoordinate toSpheric();

}
