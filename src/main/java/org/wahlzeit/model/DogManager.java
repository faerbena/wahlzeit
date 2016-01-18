package org.wahlzeit.model;

import java.util.HashMap;

import org.wahlzeit.services.ObjectManager;

public class DogManager extends ObjectManager {
	private HashMap<String, DogBreed> breeds = new HashMap<>();
	
	public Dog createDog(String breedName, String name, double age, String coatColor) {
		DogBreed breed = getDogBreed(breedName);
		return new Dog(breed, name, age, coatColor);
	}

	public synchronized DogBreed getDogBreed(String breedName) {
		if (breeds.containsKey(breedName)) {
			return breeds.get(breedName);
		}
		return createDogBreed(breedName);
	}

	public synchronized DogBreed createDogBreed(String breedName) {
		DogBreed breed = new DogBreed(breedName);
		breeds.put(breedName, breed);
		return breed;
	}

}
