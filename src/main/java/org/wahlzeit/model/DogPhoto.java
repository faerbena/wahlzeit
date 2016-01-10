package org.wahlzeit.model;

public class DogPhoto extends Photo {
	protected Dog dog;

	/**
	 * @methodtype constructor
	 */
	public DogPhoto() {
		super();
	}

	/**
	 * @methodtype constructor
	 */
	public DogPhoto(PhotoId myId) {
		super(myId);
	}
	
	/**
	 * @methodtype constructor
	 */
	public DogPhoto(PhotoId myId, Location location, Dog dog) {
		super(myId);
		
		this.location = location;
		this.dog = dog;
	}
	
	/**
	 * @methodtype constructor @methodproperty convenience
	 */
	public DogPhoto(PhotoId myId, Location location) {
		this(myId,location,null);
	}
	
	/**
	 * @methodtype constructor @methodproperty convenience
	 */
	public DogPhoto(PhotoId myId, Dog dog) {
		this(myId,null,dog);
	}
	
	/**
	 * @methodtype constructor @methodproperty convenience
	 */
	public DogPhoto(PhotoId myId, Location location, DogBreed breed, String name, double age, String coatColor) {
		this(myId, location, new Dog(breed, name, age, coatColor));
	}
		
}
