package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.entity.CategoriaPiatto;
import it.uniroma3.project.entity.Piatto;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Utente;

public class PrenotazioneDao extends AbstractDao<Prenotazione> {


	@Override
	public Prenotazione findById(long id) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prenotazione p = em.find(Prenotazione.class, id);
		tx.commit();
		em.close();
		return p;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Prenotazione> findAll() {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Prenotazione> result = em.createNamedQuery("Prenotazione.findAll",Prenotazione.class).getResultList();
		tx.commit();
		em.close();
		return result;

	}

	@SuppressWarnings("unchecked")
	public List<Prenotazione> findAllPrenotazioneUtente(Long id_utente) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		Query query = em.createNativeQuery("select p.* from Prenotazione p where p.utente_id= ?1",Prenotazione.class);
		query.setParameter(1,id_utente);
		List<Prenotazione> result = query.getResultList();
		tx.commit();
		em.close();
		return result;
	}
}
