package net.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;
import net.model.entities.Image;

@Stateless
public class FacadeImage extends AbstractDaoEntrepriseEdition<Image> {

	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
