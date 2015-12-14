/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author faerbena
 *
 */
interface Coordinate {
	/**
	 * @methodtype query
	 * 
	 * Calculates the great-circle distance of two coordinates.
	 */	
	public double getDistance(Coordinate c);
	
	/**
	 * @methodtype boolean-query
	 * 
	 * Returns true, if both coordinates identify the same point
	 * regardless their representation.
	 */		
	public boolean isEqual(Coordinate c);
	
	/**
	 * @methodtype conversion-helper
	 * 
	 * Converts the coordinate to cartesian
	 */		
	public CartesianCoordinate toCartesian();
	
	/**
	 * @methodtype conversion-helper
	 * 
	 * Converts the coordinate to spheric
	 */		
	public SphericCoordinate toSpheric();
	
	/**
	 * @methodtype assertion
	 * 
	 * asserts class invariant
	 */	
	void assertClassInvariants();
}
