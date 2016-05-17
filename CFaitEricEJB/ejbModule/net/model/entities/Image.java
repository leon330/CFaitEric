package net.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
import net.model.refs.Categorie;

@SuppressWarnings("serial")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = { "laCategorie", /* "leFormat", */ "listeTag" })
@Builder
@Entity
@Table(name = "IMAGE")
public class Image extends AbstractEntity {

	/**
	 * Nom de l'image ajoutée en base
	 */
	@OneToOne(cascade = CascadeType.ALL)
	WallPaper	image;

	/**
	 * Catégorie d'appartennance de l'image. une seule catégorie référence une
	 * image
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "CATEGORIE")
	Categorie	laCategorie;

	// /**
	// * format de l'image (jpg, png,...)
	// */
	// @Column(nullable = false, name = "FORMAT")
	// Format leFormat;

	/**
	 * Liste de tag pour préciser l'image
	 */
	@OneToMany
	List<Tag>	listeTag	= new ArrayList<>();
}
