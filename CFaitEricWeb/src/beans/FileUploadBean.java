package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

import lombok.Getter;
import lombok.Setter;
import net.facades.FacadeImage;
import net.factories.ImageFactory;
import net.factories.WallPaperFactory;
import net.model.entities.Image;
import net.model.entities.WallPaper;
import net.model.refs.Categorie;
import utils.MessagesUtils;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class FileUploadBean implements Serializable {

	@Inject
	FacadeImage				facadeImage;

	@Getter
	@Setter
	private UploadedFile	file;

	@PostConstruct
	public void init() {

	}

	/**
	 * Fonction précédé du choix de la catégorie dans lequel on uploade l'image.
	 */
	public void upload() {
		if (file != null) {
			/*
			 * Le file.getContentType() renvoie application/octet-stream pour
			 * trouver le mimeType il faut utiliser la classe FilenameUtils.
			 */
			String name = FilenameUtils.getBaseName(file.getFileName());
			String extension = FilenameUtils.getExtension(file.getFileName());
			if (WallPaper.acceptedMimeType.containsKey(extension)) {
				String mimeType = WallPaper.acceptedMimeType.get(extension);
				WallPaper wall = WallPaperFactory.createWallpaper(name, mimeType, file.getContents());
				Image img = ImageFactory.createImage(Categorie.CARTOON, wall);
				facadeImage.create(img);

				MessagesUtils.sendGrowlMessage(FacesMessage.SEVERITY_INFO, "Succès", "Le fichier %s a été uploadé.",
						file.getFileName());
			} else {
				MessagesUtils.sendGrowlMessage(FacesMessage.SEVERITY_WARN, "Erreur", "%s n'a pas été uploadé.",
						file.getFileName());
			}
		} else {
			MessagesUtils.sendGrowlMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Aucune image sélectionnée.");
		}
	}
}