package it.uniroma3.project.controller.facade;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.project.entity.DescrizionePiatto;
import it.uniroma3.project.entity.CategoriaPiatto;
import it.uniroma3.project.entity.Piatto;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Utente;
import it.uniroma3.project.persistence.AbstractDao;
import it.uniroma3.project.persistence.CategoriaPiattoDao;
import it.uniroma3.project.persistence.DescrizionePiattoDao;
import it.uniroma3.project.persistence.PiattoDao;
import it.uniroma3.project.persistence.PrenotazioneDao;
import it.uniroma3.project.persistence.UtenteDao;

public class Facade {

	public Facade() {	
	}

	public void inserisciPrenotazione(Prenotazione prenotazione){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");

		AbstractDao<Prenotazione> prenotazioneDao = new PrenotazioneDao(emf);
		prenotazioneDao.save(prenotazione);

		emf.close();
	}

	public void inserisciPiatto(Piatto piatto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		PiattoDao piattoDao = new PiattoDao(emf);
		piattoDao.save(piatto);
		emf.close();
	}

	public void inserisciDescrizione(DescrizionePiatto descrizione) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		DescrizionePiattoDao descrizionePiattoDao = new DescrizionePiattoDao(emf);
		descrizionePiattoDao.save(descrizione);
		emf.close();

	}

	public void inserisciUtente(Utente utente){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		UtenteDao utenteDao = new UtenteDao(emf);
		utenteDao.save(utente);
		emf.close();
	}

	public List<CategoriaPiatto> findAllCategorie(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		CategoriaPiattoDao categoriaPiattoDao = new CategoriaPiattoDao(emf);
		List<CategoriaPiatto> categorie = categoriaPiattoDao.findAll();
		emf.close();
		return categorie;
	}

}
