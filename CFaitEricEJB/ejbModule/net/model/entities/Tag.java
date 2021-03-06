package net.model.entities;

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
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "libelleTag")
@ToString(of = "libelleTag")
@Builder
@Entity
@Table(name = "TAG")
/**
 * On n'hérite pas d'AbstractEntity ici car l'identifiant est le TAG.
 * 
 * @author eric.gabriac
 *
 */
public class Tag implements Serializable {
	/**
	 * Nom de référence du tag
	 */
	@Id
	@Column(name = "LIBELLE")
	String libelleTag;
}