package net.commons;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, name = "ID", length = 36)
	private String id;

	/**
	 * Constructeur par défaut.
	 */
	public AbstractEntity() {
	}

	/**
	 * Génère un nouvel UUID si l'entité n'est pas déjà identifiée.
	 */
	@PrePersist
	private void generationId() {
		if (this.id == null) {
			this.id = UUID.randomUUID().toString();
		}
	}

	/**
	 * Getter pour l'attribut id.
	 * 
	 * @return La valeur de id.
	 */
	public String getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return String.format("%s => %s", this.getClass().getSimpleName(), this.id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
