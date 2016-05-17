package net.factories;

import net.model.entities.Image;
import net.model.entities.WallPaper;
import net.model.refs.Categorie;

public class ImageFactory {

	public static Image createImage(/* Format format, */Categorie cat, WallPaper image) {
		Image img = Image.builder()/* .leFormat(format) */.laCategorie(cat).image(image).build();
		return img;
	}
}
