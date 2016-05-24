package it.uniroma3.project.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import it.uniroma3.project.persistence.entity.Utente;

public class UtenteDao extends AbstractDao<Utente> {

	@Override
	public Utente findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* da controllare */
	public Utente findUtente(String email) {
		EntityManager em = null;
		try {
			em = super.getEntityManager();
			Utente utente = em.find(Utente.class, email);
			em.close();
			return utente;
			/*
			 * IMPORTANTE: trovare il modo di gestire l'eccezione nel caso in
			 * cui non sia presente l'utente ricercato, altrimenti viene
			 * restituito errore 500 da tomcat.
			 */
		} catch (Exception e) {
			return null;
		} finally {
			if (em.isOpen())
				em.close();
		}
	}

	public Utente findUtenteByUserName(String username) {
		EntityManager em = getEntityManager();
		TypedQuery<Utente> query = em.createQuery("select u from Utente u where u.username = :username", Utente.class);
		try{
			return query.setParameter("username", username).getSingleResult();
		}catch(NoResultException nre){ return null;}



	}

}
