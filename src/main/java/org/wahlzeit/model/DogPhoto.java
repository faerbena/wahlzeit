package org.wahlzeit.model;

public class DogPhoto extends Photo {
	// attributes for name, age, coat color and breed of the dog
	protected String name;
	protected double age;
	protected String coatColor;
	protected String breed;

	/**
	 * @methodtype constructor
	 */
	public DogPhoto() {
		super();
	}

	/**
	 * @methodtype constructor @methodproperty convenience
	 */
	public DogPhoto(PhotoId myId) {
		this(myId, null, "", 0, "", "");
	}
	
	/**
	 * @methodtype constructor @methodproperty convenience
	 */
	public DogPhoto(PhotoId myId, Location location) {
		this(myId, location, "", 0, "", "");
	}
	
	/**
	 * @methodtype constructor @methodproperty primitive
	 */
	public DogPhoto(PhotoId myId, Location location, String name, double age, String coatColor, String breed) {
		super(myId);
		
		this.location = location;
		this.name = name;
		this.age = age;
		this.coatColor = coatColor;
		this.breed = breed;
	}
		
}
