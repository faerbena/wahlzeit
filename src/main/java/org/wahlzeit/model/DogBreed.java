package org.wahlzeit.model;

import java.util.ArrayList;

import org.wahlzeit.utils.Pattern;

@Pattern (
		name = "Type Object",
		participants = {
					"ObjectType"
		}
)

/**
 * Class specifying the breed (type) of each Dog
 */
public class DogBreed {
	// the name of the breed, e.g. Labrador Retriever, Golden Retriever, Jack Russell Terrier, ...
	protected String name;
	
	// general description of the breed
	public String description;
	
	// description of the temperament and character of the breed
	public String temperament;
	
	// list of possible coat colors for the breed
	public ArrayList<String> possibleCoatColors;
	
	// instances of the breed
	protected ArrayList<Dog> instances = new ArrayList<Dog>();

	/**
	 * @methodtype constructor
	 */
	public DogBreed(String name, String description, String temperament, ArrayList<String> possibleCoatColors) {
		this.name = name;
		this.description = description;
		this.temperament = temperament;
		this.possibleCoatColors = possibleCoatColors;
		
	}
	
	/**
	 * @methodtype constructor @methodproperty convenience
	 */
	public DogBreed(String name) {
		this(name,"","",new ArrayList<String>());
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @methodtype get
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @methodtype set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @methodtype get
	 */
	public String getTemperament() {
		return this.temperament;
	}
	
	/**
	 * @methodtype set
	 */
	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}
	
	/**
	 * @methodtype get
	 */
	public ArrayList<String> getPossibleCoatColors() {
		return this.possibleCoatColors;
	}
	
	/**
	 * @methodtype set
	 */
	public void setPossibleCoatColors(ArrayList<String> possibleCoatColors) {
		this.possibleCoatColors = possibleCoatColors;
	}
	
	/**
	 * @methodtype boolean
	 */
	public boolean containsPossibleCoatColor(String coatColor) {
		return possibleCoatColors.contains(coatColor);
	}
	
	public void addPossibleCoatColor(String coatColor) {
		if (coatColor != "" && !this.containsPossibleCoatColor(coatColor)){
			this.possibleCoatColors.add(coatColor);
		}
	}
	
	public void removePossibleCoatColor(String coatColor) {
		possibleCoatColors.remove(coatColor);
	}
	
	public void addInstance(Dog dog) {
		instances.add(dog);
		this.addPossibleCoatColor(dog.getCoatColor());
	}
	
	public void removeInstance(Dog dog) {
		instances.remove(dog);
	}

}
