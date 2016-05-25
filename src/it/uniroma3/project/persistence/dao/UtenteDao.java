package it.uniroma3.project.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import it.uniroma3.project.persistence.entity.Utente;

public class UtenteDao extends AbstractDao<Utente> {

	public UtenteDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

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
		try {
			return getEntityManager().find(Utente.class, email);
		} catch (Exception e) {
			return null;
		} 
	}

	public Utente findUtenteByUserName(String username) {
		TypedQuery<Utente> query = getEntityManager().createQuery("select u from Utente u where u.username = :username", Utente.class);
		try{
			return query.setParameter("username", username).getSingleResult();
		}catch(NoResultException nre){ return null;}



	}

}
