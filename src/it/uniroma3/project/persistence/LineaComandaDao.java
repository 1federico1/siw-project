package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import it.uniroma3.project.entity.LineaComanda;

public class LineaComandaDao extends AbstractDao<LineaComanda> {

	public LineaComandaDao(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LineaComanda findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaComanda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
