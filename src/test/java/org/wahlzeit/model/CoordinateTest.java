package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;

public class CoordinateTest {
	static Coordinate c1 = new Coordinate(80,120);
	static Coordinate c2 = null;
	static Coordinate c3 = new Coordinate(85,80);
	static Coordinate c4 = new Coordinate(30,150);
	
	@BeforeClass
	public static void testPredefinded() {
		assertNotNull(c1);
		assertNull(c2);
		assertNotNull(c3);
		assertNotNull(c4);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLatitudeTooSmall() {		
		Coordinate c5 = new Coordinate(-90.1,0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLatitudeTooBig() {		
		Coordinate c5 = new Coordinate(90.1,0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLongitudeTooSmall() {		
		Coordinate c5 = new Coordinate(-180.1,0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLongitudeTooBig() {		
		Coordinate c5 = new Coordinate(180.1,0);
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
}
