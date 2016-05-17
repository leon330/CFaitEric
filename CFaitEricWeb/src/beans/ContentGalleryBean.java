package beans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lombok.Getter;
import lombok.Setter;
import net.facades.FacadeImage;
import net.model.entities.Image;
import net.model.entities.WallPaper;

@SuppressWarnings("serial")
@Getter
@Setter
@Named
@ViewScoped
public class ContentGalleryBean implements Serializable {

	@Inject
	private FacadeImage	facade;

	private List<Image>	images;

	@PostConstruct
	public void init() {
		images = facade.readAll();
	}

	/**
	 * contentGalleryBean.afficherImage(image)
	 * 
	 * @param image
	 * @return
	 */
	public StreamedContent afficherImage(Image image) {
		// FacesContext context = FacesContext.getCurrentInstance();
		// StreamedContent imgContent = null;
		//
		// if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
		// // So, we're rendering the view. Return a stub StreamedContent so
		// // that it will generate right URL.
		// imgContent = new DefaultStreamedContent();
		// } else {
		WallPaper wallpaper = image.getImage();
		InputStream imgStream = new ByteArrayInputStream(wallpaper.getImage());
		return new DefaultStreamedContent(imgStream, wallpaper.getMimeType());
		// }

		// return imgContent;
	}

	/**
	 * pour le vue: contentGalleryBean.afficherNomImage(image)
	 * <f:param name="id" value="#{image.getImage().getId()}" />
	 * 
	 * @param image
	 * @return
	 */
	public String afficherNomImage(Image image) {
		WallPaper wallpaper = image.getImage();
		return wallpaper.getName();
	}

	/**
	 * private List<String> images;
	 */
	public void hydrateBlank() {
		// images = new LinkedList<>();
		// for (int i = 1; i <= 14; i++) {
		// images.add("nature" + i + ".jpeg");
		// }
	}
}
