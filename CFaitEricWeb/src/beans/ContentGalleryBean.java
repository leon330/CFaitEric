package beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import model.managers.ImageManager;

@SuppressWarnings("serial")
@Getter
@Setter
@Named
@ViewScoped
public class ContentGalleryBean implements Serializable {

	@Inject
	private ImageManager	manager;

	private List<String>	images;	// Image

	public ContentGalleryBean() {
	}

	@PostConstruct
	public void init() {
		images = new LinkedList<>();
		images.add("nature1.jpeg");
		images.add("nature2.jpeg");
		images.add("nature4.jpeg");
		images.add("nature7.jpeg");
	}
}
