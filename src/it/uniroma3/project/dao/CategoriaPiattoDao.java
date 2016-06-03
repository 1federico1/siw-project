package it.uniroma3.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.uniroma3.project.model.CategoriaPiatto;;

public class CategoriaPiattoDao extends AbstractDao<CategoriaPiatto> {
	
	public CategoriaPiattoDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CategoriaPiatto findById(long id) {
		return getEntityManager().find(CategoriaPiatto.class, id);
	}
	
	public CategoriaPiatto findByName(String nome) {
		TypedQuery<CategoriaPiatto> q = getEM().createQuery("select c from CategoriaPiatto c where c.nome = :nome", CategoriaPiatto.class);
		q.setParameter("nome", nome);
		return q.getSingleResult();
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaPiatto> findAll() {
		return getEntityManager().createNamedQuery("CategoriaPiattoFindAll").getResultList();
	}

}
