package beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Named
@ViewScoped
public class DropDownView implements Serializable {

	private Map<String, Map<String, String>>	data	= new HashMap<String, Map<String, String>>();
	private String								country;
	private String								city;
	private Map<String, String>					countries;
	private Map<String, String>					cities;

	@PostConstruct
	public void init() {
		countries = new HashMap<String, String>();
		countries.put("USA", "USA");
		countries.put("Germany", "Germany");
		countries.put("Brazil", "Brazil");

		Map<String, String> map = new HashMap<String, String>();
		map.put("New York", "New York");
		map.put("San Francisco", "San Francisco");
		map.put("Denver", "Denver");
		data.put("USA", map);

		map = new HashMap<String, String>();
		map.put("Berlin", "Berlin");
		map.put("Munich", "Munich");
		map.put("Frankfurt", "Frankfurt");
		data.put("Germany", map);

		map = new HashMap<String, String>();
		map.put("Sao Paolo", "Sao Paolo");
		map.put("Rio de Janerio", "Rio de Janerio");
		map.put("Salvador", "Salvador");
		data.put("Brazil", map);
	}

	public void onCountryChange() {
		if (country != null && !country.equals(""))
			cities = data.get(country);
		else
			cities = new HashMap<String, String>();
	}

	public void displayLocation() {
		FacesMessage msg;
		if (city != null && country != null) {
			msg = new FacesMessage("Selected", city + " of " + country);
		} else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}