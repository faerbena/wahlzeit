/**
 * 
 */
package org.wahlzeit.model;

/**
 * @author Nadja
 *
 */
public class DogPhotoFactory extends PhotoFactory {

	@Override
	public Photo createPhoto() {
		return new DogPhoto();
	}

	@Override
	public Photo createPhoto(PhotoId id) {
		return new DogPhoto(id);
	}
}
