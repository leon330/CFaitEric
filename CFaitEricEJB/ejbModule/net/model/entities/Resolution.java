package net.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.commons.AbstractEntity;

@SuppressWarnings("serial")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = { "libelleRes", "hauteur", "largueur" })
@Builder
@Entity
@Table(name = "RESOLUTION")
public class Resolution extends AbstractEntity {
	/**
	 * Libellé correspondant à une résolution.
	 */
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
