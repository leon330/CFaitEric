package model.refs;

import lombok.Getter;
import lombok.Setter;

public enum Format
{
	PNG("png"), JPEG("jpeg"), JPG("jpg"), TIFF("tiff");

	@Getter
	@Setter
	private String libelle;

	private Format(String lib)
	{
		libelle = lib;
	}
}
