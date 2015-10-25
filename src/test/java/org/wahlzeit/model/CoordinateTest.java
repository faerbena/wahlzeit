package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;

public class CoordinateTest {
	static Coordinate c1 = new Coordinate(120,90);
	static Coordinate c2 = null;
	static Coordinate c3 = new Coordinate(80,140);
	static Coordinate c4 = new Coordinate(150,30);
	
	@BeforeClass
	public static void testPredefinded() {
		assertNotNull(c1);
		assertNull(c2);
		assertNotNull(c3);
		assertNotNull(c4);
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
	public void testGetDistanceToSelf() {
		Coordinate distance = c1.getDistance(c1);
		assertNotNull(distance);
		assertTrue(distance.isEqualTo(new Coordinate(0,0)));
	}
	
	@Test
	public void testGetLatitudinalDistanceToSelf() {
		double distance = c1.getLatitudinalDistance(c1);
		assertEquals(0,distance,0);
	}
	
	@Test
	public void testGetLongitudinalDistanceToSelf() {
		double distance = c1.getLongitudinalDistance(c1);
		assertEquals(0,distance,0);
	}
	
	@Test
	public void testGetDistanceToc3() {
		Coordinate distance = c1.getDistance(c3);
		assertNotNull(distance);
		assertTrue(distance.isEqualTo(new Coordinate(40,-50)));
	}
	
	@Test
	public void testGetLatitudinalDistanceToc3() {
		double distance = c1.getLatitudinalDistance(c3);
		assertEquals(40,distance,0);
	}
	
	@Test
	public void testGetLongitudinalDistanceToc3() {
		double distance = c1.getLongitudinalDistance(c3);
		assertEquals(-50,distance,0);
	}
	
	@Test
	public void testGetDistanceToc4() {
		Coordinate distance = c1.getDistance(c4);
		assertNotNull(distance);
		assertTrue(distance.isEqualTo(new Coordinate(-30,60)));
	}
	
	@Test
	public void testGetLatitudinalDistanceToc4() {
		double distance = c1.getLatitudinalDistance(c4);
		assertEquals(-30,distance,0);
	}
	
	@Test
	public void testGetLongitudinalDistanceToc4() {
		double distance = c1.getLongitudinalDistance(c4);
		assertEquals(60,distance,0);
	}	

}
