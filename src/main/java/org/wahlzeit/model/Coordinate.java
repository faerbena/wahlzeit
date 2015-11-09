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
	 */	
	public double getDistance(Coordinate c);
	
	/**
	 * @methodtype boolean-query
	 */		
	public boolean isEqual(Coordinate c);
	
	/**
	 * @methodtype helper
	 * 
	 * converts the coordinate to cartesian
	 */		
	public CartesianCoordinate toCartesian();
	
	/**
	 * @methodtype helper
	 * 
	 * converts the coordinate to spheric
	 */		
	public SphericCoordinate toSpheric();

}
