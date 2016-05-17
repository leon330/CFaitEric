package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * NON UTILISE CAR PAS DE MENU POUR LE MOMENT
 * 
 * @author eric.gabriac
 *
 */
@SuppressWarnings("serial")
@Named
@ViewScoped
public class MenuBean implements Serializable {

	public void save() {
		addMessage("Succès", "Données enregistrées");
	}

	public void update() {
		addMessage("Succès", "Données mises à jour");
	}

	public void delete() {
		addMessage("Succès", "Données supprimées");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
