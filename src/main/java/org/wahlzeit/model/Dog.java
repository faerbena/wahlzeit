package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;
import org.wahlzeit.utils.Pattern;

@Pattern (
		name = "Type Object",
		participants = {
					"Object"
		}
)

public class Dog  extends DataObject {
	protected DogBreed breed;
	
	// attributes for name, age, coat color of the dog
	protected String name;
	protected double age;
	protected String coatColor;

	/**
	 * @methodtype constructor
	 */
	protected Dog(DogBreed breed, String name, double age, String coatColor) {
		this.breed = breed;		
		this.name = name;
		this.age = age;
		this.coatColor = coatColor;
		
		breed.addInstance(this);
	}
	
	/**
	 * @methodtype get
	 */
	public DogBreed getBreed() {
		return this.breed;
	}
	
	/**
	 * @methodtype set
	 */
	public void setBreed(DogBreed newBreed) {
		breed.removeInstance(this);
		
		this.breed = newBreed;
		newBreed.addInstance(this);
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @methodtype set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @methodtype get
	 */
	public double getAge() {
		return this.age;
	}
	
	/**
	 * @methodtype set
	 */
	public void setAge(double age) {
		this.age = age;
	}
	/**
	 * @methodtype get
	 */
	public String getCoatColor() {
		return this.coatColor;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
		
		this.breed.addPossibleCoatColor(coatColor);
	}

}
