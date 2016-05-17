package utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public final class MessagesUtils {

	private MessagesUtils() {
		// protection du constructeur
	}

	/**
	 * conserve les message dans le FlashScope pour un composant Growl en
	 * faces-redirect.
	 * 
	 */
	public static void keepMessages() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
	}

	/**
	 * Envoi des messages dans une bulle en haut à droite de la fenêtre
	 * 
	 * @param pSeverity
	 * @param stringFormat
	 * @param objects
	 */
	public static void sendGrowlMessage(final Severity pSeverity, String titre, String stringFormat,
			Object... objects) {
		keepMessages();
		String message = String.format(stringFormat, objects);
		FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(pSeverity, titre, message));
	}
}
