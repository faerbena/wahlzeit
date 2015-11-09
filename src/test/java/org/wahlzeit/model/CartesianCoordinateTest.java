package org.wahlzeit.model;
import static java.lang.Math.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CartesianCoordinateTest {
	static CartesianCoordinate c1 = new CartesianCoordinate(0,0,0);
	static CartesianCoordinate c2 = null;
	static CartesianCoordinate c3 = new CartesianCoordinate(-1,1,-sqrt(2));

	@BeforeClass
	public static void testPredefinded() {
		assertNotNull(c1);
		assertNull(c2);
		assertNotNull(c3);
	}

	@Test (expected=NullPointerException.class)
	public void testGetDistanceShouldThrowNullPointerException() {
		c1.getDistance(c2);
	}
	
	@Test
	public void testToSpheric() {
		assertTrue(c1.toSpheric().isEqual(new SphericCoordinate(0,0,0)));
		assertTrue(c3.toSpheric().isEqual(new SphericCoordinate(45,135,2)));
	}

}
