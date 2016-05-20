package net.commons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;

/**
 * offre la capacité de retourner l'entity manager. Cette classe doit être hérité par les façades
 * concrêtes annotées par Stateless.
 * 
 * @author CDT RBN
 *
 * @param <T>
 */

public abstract class AbstractFacade<T> extends AbstractDaoEntrepriseEdition<T>
{
	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager()
	{
		return em;
	}

}
