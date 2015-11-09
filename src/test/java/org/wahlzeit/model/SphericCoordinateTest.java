package org.wahlzeit.model;

import static java.lang.Math.sqrt;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;

public class SphericCoordinateTest {
	static SphericCoordinate c0 = new SphericCoordinate(0,0,0);
	static SphericCoordinate c1 = new SphericCoordinate(80,120);
	static SphericCoordinate c2 = null;
	static SphericCoordinate c3 = new SphericCoordinate(85,80);
	static SphericCoordinate c4 = new SphericCoordinate(30,150);
	static SphericCoordinate c5 = new SphericCoordinate(45,135,2);
	
	@BeforeClass
	public static void testPredefinded() {
		assertNotNull(c1);
		assertNull(c2);
		assertNotNull(c3);
		assertNotNull(c4);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLatitudeTooSmall() {		
		SphericCoordinate c6 = new SphericCoordinate(-90.1,0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLatitudeTooBig() {		
		SphericCoordinate c6 = new SphericCoordinate(90.1,0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLongitudeTooSmall() {		
		SphericCoordinate c6 = new SphericCoordinate(-180.1,0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLongitudeTooBig() {		
		SphericCoordinate c6 = new SphericCoordinate(180.1,0);
	}

	@Test (expected=NullPointerException.class)
	public void testGetDistanceShouldThrowNullPointerException() {		
		c1.getDistance(c2);
	}
	
	@Test (expected=NullPointerException.class)
	public void testGetLatitudinalDistanceShouldThrowNullPointerException() {
		c1.getLatitudinalDistance(c2);
	}
	
	@Test (expected=NullPointerException.class)
	public void testGetLongitudinalDistanceShouldThrowNullPointerException() {
		c1.getLongitudinalDistance(c2);
	}
	
	@Test
	public void testGetLatitudinalDistance() {
		double dist1 = c1.getLatitudinalDistance(c1);
		assertEquals(0,dist1,0);
		
		double dist2 = c1.getLatitudinalDistance(c3);
		assertEquals(5,dist2,0);
		
		double dist3 = c1.getLatitudinalDistance(c4);
		assertEquals(50,dist3,0);
	}
	
	@Test
	public void testGetLongitudinalDistance() {
		double dist1 = c1.getLongitudinalDistance(c1);
		assertEquals(0,dist1,0);
		
		double dist2 = c1.getLongitudinalDistance(c3);
		assertEquals(40,dist2,0);
		
		double dist3 = c1.getLongitudinalDistance(c4);
		assertEquals(30,dist3,0);
	}
	
	@Test
	public void testGetDistance() {
		double dist1 = c1.getDistance(c1);
		assertEquals(0,dist1,0);
		
		double dist2 = c1.getDistance(c3);
		assertEquals(2652912.85,dist2,0.1);
		
		double dist3 = c1.getDistance(c4);
		assertEquals(3318241.13,dist3,0.1);
	}
	
	@Test
	public void testToCartesian() {
		assertTrue(c0.toCartesian().isEqual(new CartesianCoordinate(0,0,0)));
		assertTrue(c5.toCartesian().isEqual(new CartesianCoordinate(-1,1,sqrt(2))));
	}
}
