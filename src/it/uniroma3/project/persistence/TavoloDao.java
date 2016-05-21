package it.uniroma3.project.persistence;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import it.uniroma3.project.entity.Tavolo;

public class TavoloDao extends AbstractDao<Tavolo> {

	@Override
	public Tavolo findById(long id) {
		EntityManager em = super.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Tavolo o = em.find(Tavolo.class, id);
		tx.commit();
		em.close();
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tavolo> findAll() {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Tavolo> result = em.createNamedQuery("Tavolo.findAll").getResultList();
		System.out.println(result.toString());
		tx.commit();
		em.close();
		return result;
	}

	public Tavolo findByNumero(String parameter) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = (Query) em.createNativeQuery("select id from tavolo where codicetavolo = ?1");
		q.setParameter(1, parameter);
		BigInteger id = (BigInteger) q.getSingleResult();
		Tavolo t = this.findById(id.longValue());
		tx.commit();
		em.close();
		return t;
	}

	/**
	 * Restituisce tutti i tavoli prenotati oggi
	 * @param today
	 * @return
	 */
	public List<Tavolo> findAllToday(Date today) {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Tavolo> query = em.createQuery(
				"select t "
				+ "from Tavolo t left join Prenotazione on tavoloprenotato_id = t.id "
				+ "where data = :today or tavoloprenotato_id is null "
				+ "order by t.id",
				Tavolo.class);
		query.setParameter("today", today,TemporalType.DATE);
		List<Tavolo> result = query.getResultList();
		tx.commit();
		em.close();
		return result;

	}
	
	public List<Tavolo> findAllTodayLiberi() {
		EntityManager em = super.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Tavolo> query = em.createQuery("select t "
				+ "from Tavolo t left join Prenotazione on tavoloprenotato_id = t.id "
				+ "where tavoloprenotato_id is null "
				+ "order by t.id", Tavolo.class);
		List<Tavolo> result = query.getResultList();
		tx.commit();
		em.clear();
		return result;
		
	}

}
