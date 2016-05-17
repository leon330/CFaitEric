package net.factories;

import net.model.entities.WallPaper;

public class WallPaperFactory {

	public static WallPaper createWallpaper(String nom, String mimeType, byte[] image) {
		WallPaper wall = WallPaper.builder().name(nom).mimeType(mimeType).image(image).build();
		return wall;
	}
}
