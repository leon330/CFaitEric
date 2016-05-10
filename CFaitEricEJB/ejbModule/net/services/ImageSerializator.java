package net.services;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

import net.model.entities.WallPaper;

public class ImageSerializator {

	/**
	 * crée une instance de la classe MonImage à partir d’un fichier image
	 * (fichier .jpg, par exemple)
	 * 
	 * @param imageFile
	 * @return
	 * @throws IOException
	 */
	public static WallPaper serializeImage(File imageFile) throws IOException {
		WallPaper monImage = new WallPaper();
		monImage.setName(imageFile.getName().substring(0, imageFile.getName().lastIndexOf(".")));
		monImage.setMimeType(WallPaper.acceptedMimeType
				.get(imageFile.getName().substring(imageFile.getName().lastIndexOf(".") + 1)));
		monImage.setImage(ImageIO.read(imageFile));
		return monImage;
	}

	/**
	 * permet d’écrire une image sérialisée dans un fichier du répertoire passé
	 * en paramètre
	 * 
	 * @param monImage
	 * @param folder
	 * @throws IOException
	 */
	public static void writeFileIntoFolder(WallPaper monImage, File folder) throws IOException {
		String extension = getExtension(monImage.getMimeType());
		File file = new File(folder + "/" + monImage.getName() + "." + extension);
		file.createNewFile();
		FileImageOutputStream fos = new FileImageOutputStream(file);
		fos.write(monImage.getImage());
		fos.close();
	}

	/**
	 * Récupère l'extension du fichier en fonction du type mime dans le
	 * dictionnaire des formats d'image acceptés
	 * 
	 * @param mimeType
	 * @return
	 */
	private static String getExtension(String mimeType) {
		for (Entry<String, String> typeMimeEntry : WallPaper.acceptedMimeType.entrySet()) {
			if (mimeType.equals(typeMimeEntry.getValue())) {
				return typeMimeEntry.getKey();
			}
		}
		return null;
	}

	/**
	 * Crée plusieurs fichiers images à partir d'une liste d'images sérialisées,
	 * dans le dossier passé en paramètre
	 */
	public static void writeFilesIntoFolder(List<WallPaper> images, File folder) throws IOException {
		for (WallPaper imageMudu : images) {
			writeFileIntoFolder(imageMudu, folder);
		}
	}

	/**
	 * Sérialise l'ensemble des images contenues dans le répertoire passé en
	 * paramètre
	 */
	public static List<WallPaper> serializeFolder(File folder) throws IOException {
		List<WallPaper> images = new ArrayList<>();
		// Filtre pour ne garder que les fichiers images acceptés
		FileFilter imageFileFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				String fileName = file.getName();
				// on extrait l'extension du fichier puis on vérifie qu'elle
				// existe dans le dictionnaire
				String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
				if (extension == null || extension.isEmpty())
					return false;
				else
					return WallPaper.acceptedMimeType.containsKey(extension);
			}
		};
		for (File imageFile : folder.listFiles(imageFileFilter)) {
			WallPaper image = serializeImage(imageFile);
			if (image != null) {
				images.add(image);
			}
		}
		return images;
	}
}
