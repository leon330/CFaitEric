package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
import model.refs.Categorie;
import model.refs.Format;

@SuppressWarnings("serial")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = { "laCategorie", "leFormat", "listeTag" })
@Builder
@Entity
@Table(name = "IMAGE")
public class Image implements Serializable
{
	/**
	 * Id Unique de l'image
	 */

	@Id
	@Column(name = "ID")
	String		id;

	/**
	 * Nom de l'image ajoutée en base
	 */
	String		nom;

	/**
	 * Catégorie d'appartennance de l'image. une seule catégorie référence une
	 * image
	 */
	@Column(nullable = false, name = "CATEGORIE")
	Categorie	laCategorie;

	/**
	 * format de l'image (jpg, png,...)
	 */
	@Column(nullable = false, name = "FORMAT")
	Format		leFormat;

	/**
	 * Liste de tag pour préciser l'image
	 */
	@OneToMany
	List<Tag>	listeTag	= new ArrayList<>();
}
