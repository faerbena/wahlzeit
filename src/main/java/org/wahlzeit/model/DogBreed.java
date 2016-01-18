package org.wahlzeit.model;

import java.util.LinkedList;

import org.wahlzeit.services.DataObject;
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
public class DogBreed extends DataObject {
	// the name of the breed, e.g. Labrador Retriever, Golden Retriever, Jack Russell Terrier, ...
	protected String name;
	
	// general description of the breed
	public String description;
	
	// description of the temperament and character of the breed
	public String temperament;
	
	// list of possible coat colors for the breed
	public LinkedList<String> possibleCoatColors;
	
	// instances of the breed
	protected LinkedList<Dog> instances = new LinkedList<Dog>();

	/**
	 * @methodtype constructor
	 */
	protected DogBreed(String name, String description, String temperament, LinkedList<String> possibleCoatColors) {
		assert (possibleCoatColors != null);
		
		this.name = name;
		this.description = description;
		this.temperament = temperament;
		this.possibleCoatColors = possibleCoatColors;
	}
	
	/**
	 * @methodtype constructor @methodproperty convenience
	 */
	protected DogBreed(String name) {
		this(name,"","",new LinkedList<String>());
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
	public LinkedList<String> getPossibleCoatColors() {
		return this.possibleCoatColors;
	}
	
	/**
	 * @methodtype set
	 */
	public void setPossibleCoatColors(LinkedList<String> possibleCoatColors) {
		this.possibleCoatColors = possibleCoatColors;
	}
	
	/**
	 * @methodtype boolean
	 */
	public boolean containsPossibleCoatColor(String coatColor) {
		return possibleCoatColors.contains(coatColor);
	}
	
	protected void addPossibleCoatColor(String coatColor) {
		if (coatColor != "" && !this.containsPossibleCoatColor(coatColor)){
			this.possibleCoatColors.add(coatColor);
		}
	}
	
//	private void removePossibleCoatColor(String coatColor) {
//		possibleCoatColors.remove(coatColor);
//	}
	
	/**
	 * @methodtype get
	 */
	protected LinkedList<Dog> getInstances() {
		return this.instances;
	}
	
	protected void addInstance(Dog dog) {
		instances.add(dog);
		this.addPossibleCoatColor(dog.getCoatColor());
	}
	
	protected void removeInstance(Dog dog) {
		instances.remove(dog);
	}

}
