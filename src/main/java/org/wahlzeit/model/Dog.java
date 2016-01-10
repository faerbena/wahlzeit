package org.wahlzeit.model;

import org.wahlzeit.utils.Pattern;

@Pattern (
		name = "Type Object",
		participants = {
					"Object"
		}
)

public class Dog {
	protected DogBreed breed;
	
	// attributes for name, age, coat color of the dog
	protected String name = "";
	protected double age = 0;
	protected String coatColor = "";

	/**
	 * @methodtype constructor
	 */
	public Dog(DogBreed breed, String name, double age, String coatColor) {
		this.breed = breed;
		breed.addInstance(this);
		
		this.name = name;
		this.age = age;
		this.coatColor = coatColor;
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
	public void setName(double age) {
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
	}

}
