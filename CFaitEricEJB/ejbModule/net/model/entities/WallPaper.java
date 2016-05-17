package net.model.entities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import net.commons.AbstractEntity;

@SuppressWarnings("serial")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "WALLPAPER")
public class WallPaper extends AbstractEntity {

	@Getter
	@Setter
	@Column(nullable = false, name = "NOM")
	String									name;

	/**
	 * Fichier binaire image (Large Object Binaries). Pour certaines BDD, il
	 * faut mieux spécifier la taille afin qu'il choisisse le bon type.
	 */
	@Getter
	@Column(length = Integer.MAX_VALUE)
	@Lob
	// @Basic(fetch = FetchType.LAZY)
	byte[]									image;

	/**
	 * Permet de définir l'extension de l'image. Exemple: pour "jpg",
	 * "image/jpeg"
	 */
	@Getter
	@Setter
	@Column(name = "MIME_TYPE")
	String									mimeType;

	public static final Map<String, String>	acceptedMimeType	= new HashMap<String, String>();

	static {
		acceptedMimeType.put("jpg", "image/jpeg");
		acceptedMimeType.put("gif", "image/gif");
		acceptedMimeType.put("png", "image/png");
		acceptedMimeType.put("tif", "image/tiff");
		acceptedMimeType.put("svg", "image/svg+xml");
		acceptedMimeType.put("ico", "image/vnd.microsoft.icon");
	}

	public void setImage(BufferedImage bufferedImage) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, mimeType.split("image/")[1], baos);
		baos.flush();
		this.image = baos.toByteArray();
		baos.close();
	}

	public BufferedImage getBufferedImage() throws IOException {
		return ImageIO.read(new ByteArrayInputStream(image));
	}

}
