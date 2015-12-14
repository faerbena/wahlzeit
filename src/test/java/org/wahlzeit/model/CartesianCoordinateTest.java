package org.wahlzeit.model;
import static java.lang.Math.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CartesianCoordinateTest {
	static CartesianCoordinate c1 = CartesianCoordinate.getInstance(0,0,0);
	static CartesianCoordinate c2 = null;
	static CartesianCoordinate c3 = CartesianCoordinate.getInstance(-1,1,-sqrt(2));

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
	public void testIsEqual() {
		assertTrue(c1.isEqual(CartesianCoordinate.getInstance(0,0,0)));
		assertTrue(c3.isEqual(CartesianCoordinate.getInstance(-1,1,-sqrt(2))));
		
		assertTrue(c1.isEqual(SphericCoordinate.getInstance(0,0,0)));
		assertTrue(c3.isEqual(SphericCoordinate.getInstance(45,135,2)));
	}

}
