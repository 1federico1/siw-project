package it.uniroma3.project.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import it.uniroma3.project.entity.Utente;

public class UtenteDao extends AbstractDao<Utente> {

	public UtenteDao(EntityManagerFactory emf) {
		super(emf);
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

}
