package org.wahlzeit.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DogBreedTest {

	private DogBreed b1, b2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		b1 = new DogBreed("Labrador Retriever");
		
		b2 = new DogBreed("Jack Russell Terrier",
				"The Jack Russell Terrier is a small terrier that has its origins in fox hunting.",
				"Their high energy and drive make these dogs ideally suited to a number of different dog sports.",
				new LinkedList<String>());
	}

	@Test
	public void testGetInstances() {
		assertTrue(b1.getInstances().isEmpty());
		Dog d1 = new Dog(b1, "Hasso", 0.5, "");
		assertTrue(b1.getInstances().contains(d1));
		Dog d2 = new Dog(b1, "Waldi", 3, "");
		assertTrue(b1.getInstances().contains(d2));
		
		assertTrue(b2.getInstances().isEmpty());
		d1.setBreed(b2);
		assertTrue(!b1.getInstances().contains(d1));
		assertTrue(b2.getInstances().contains(d1));	
	}
	
	@Test
	public void testGetPossibleCoatColor() {
		assertTrue(b1.getPossibleCoatColors().isEmpty());
		Dog d0 = new Dog(b1, "Bello", 10, "");
		assertTrue(b1.getPossibleCoatColors().isEmpty());
		
		Dog d1 = new Dog(b1, "Hasso", 0.5, "black");
		assertTrue(b1.getPossibleCoatColors().contains("black"));
		
		Dog d2 = new Dog(b1, "Waldi", 3, "brown");
		assertTrue(b1.getPossibleCoatColors().contains("brown"));
		d2.setCoatColor("yellow");
		assertTrue(b1.getPossibleCoatColors().contains("brown"));
		assertTrue(b1.getPossibleCoatColors().contains("yellow"));
		
		Dog d3 = new Dog(b2, "Jack", 1, "white");
		d3.setBreed(b1);
		assertTrue(b1.getPossibleCoatColors().contains("white"));
	}

}
