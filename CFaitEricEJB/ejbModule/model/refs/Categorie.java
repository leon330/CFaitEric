package model.refs;

import lombok.Getter;
import lombok.Setter;

public enum Categorie
{
	NATURE("Nature"), FEMME("Femme"), DIGITAL_ART("Art digital"), PIXEL("Pixel"), ARCHITECTURE("Architecture"), MANGA(
			"Manga"), COMICS("Comics"), CARTOON("Cartoon"), MOTEUR(
					"Moteur"), ESPACE("Espace"), MUSIQUE("Musique"), JEUX("Jeux"), FILM("Film"), ELEMENTS("Eléments");

	@Getter
	@Setter
	private String libelle;

	private Categorie(String lib)
	{
		libelle = lib;
	}
}
