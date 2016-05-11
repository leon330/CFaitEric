package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class FileUploadBean implements Serializable {

	@Getter
	@Setter
	private UploadedFile file;

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
}