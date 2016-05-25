package it.uniroma3.project.persistence.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.project.persistence.entity.Comanda;

public class ComandaDao extends AbstractDao<Comanda> {

	public ComandaDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Comanda findById(long id) {
		return getEntityManager().find(Comanda.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comanda> findAll() {
		return getEntityManager().createNamedQuery("Comanda.findAll").getResultList();
	}

	public Comanda findComandaByTavoloAndDay(Long param, Date data) {
		try {
			Query q = (Query) getEntityManager().createNativeQuery(
					"select c.id from comanda c where c.tavolo_id = ?1 and date(dataoraemissione) = ?2");
			q.setParameter(1, param);
			q.setParameter(2, data);
			BigInteger id = (BigInteger) q.getSingleResult();
			Comanda c = this.findById(id.longValue());
			return c;
		} catch (Exception e) {
			return null;
		}
	}
}
