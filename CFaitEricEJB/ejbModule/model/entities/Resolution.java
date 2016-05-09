package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "libelleRes")
@ToString(of = { "libelleRes", "hauteur", "largueur" })
@Builder
@Entity
@Table(name = "RESOLUTION")
public class Resolution implements Serializable
{ 
	/**
	 * libéllé correspondant à une résolution
	 */
	@Id
	@Column(name = "LIBELLE")
	String	libelleRes;

	/**
	 * Hauteur de la résolution
	 */
	@Column(nullable = false, name = "HAUTEUR")
	int		hauteur;

	/**
	 * Largueur de la résolution
	 */
	@Column(nullable = false, name = "LARGUEUR")
	int		largueur;
}
