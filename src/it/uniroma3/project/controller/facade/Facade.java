package it.uniroma3.project.controller.facade;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.project.entity.DescrizionePiatto;
import it.uniroma3.project.entity.Operatore;
import it.uniroma3.project.entity.Amministratore;
import it.uniroma3.project.entity.CategoriaPiatto;
import it.uniroma3.project.entity.Comanda;
import it.uniroma3.project.entity.Piatto;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.project.entity.Utente;
import it.uniroma3.project.persistence.AbstractDao;
import it.uniroma3.project.persistence.AmministratoreDao;
import it.uniroma3.project.persistence.CategoriaPiattoDao;
import it.uniroma3.project.persistence.ComandaDao;
import it.uniroma3.project.persistence.DescrizionePiattoDao;
import it.uniroma3.project.persistence.OperatoreDao;
import it.uniroma3.project.persistence.PiattoDao;
import it.uniroma3.project.persistence.PrenotazioneDao;
import it.uniroma3.project.persistence.TavoloDao;
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
	
	public void inserisciComanda(Comanda comanda) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		ComandaDao dao = new ComandaDao(emf);
		dao.save(comanda);
		emf.close();
	}

	public List<CategoriaPiatto> findAllCategorie(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		CategoriaPiattoDao categoriaPiattoDao = new CategoriaPiattoDao(emf);
		List<CategoriaPiatto> categorie = categoriaPiattoDao.findAll();
		emf.close();
		return categorie;
	}
	
	public CategoriaPiatto findCategoria(String id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		CategoriaPiattoDao categoriaPiattoDao = new CategoriaPiattoDao(emf);
		CategoriaPiatto categoria = categoriaPiattoDao.findById(Long.parseLong(id));
		emf.close();
		return categoria;
	}
	
	public void setCategoriaPiatto(Long idPiatto, String idCategoria) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		PiattoDao PiattoDao = new PiattoDao(emf);
		PiattoDao.setCategoria(idPiatto , idCategoria);
		emf.close();	
	}

	public List<Piatto> findAllPiatti(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		PiattoDao piattoDao = new PiattoDao(emf);
		List<Piatto> piatti = piattoDao.findAll();
		emf.close();
		return piatti;
	}
	
	public Amministratore findAdministrator(String username){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		AmministratoreDao amministratoreDao = new AmministratoreDao(emf);
		Amministratore amministratore = amministratoreDao.findAmministratore(username);
		emf.close();
		return amministratore;
		
	}

	public Utente findUtente(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		UtenteDao utenteDao = new UtenteDao(emf);
		Utente utente = utenteDao.findUtente(email);
		emf.close();
		return utente;
	}
	
	public Operatore findOperatoreByCodice(String codice) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		OperatoreDao dao = new OperatoreDao(emf);
		Operatore operatore = dao.findByCodice(codice);
		emf.close();
		return operatore;
	}

	public Tavolo findTavoloByNumero(String parameter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		TavoloDao dao = new TavoloDao(emf);
		Tavolo tavolo = dao.findByNumero(parameter);
		emf.close();
		return tavolo;
	}



	public List<Prenotazione> findAllPrenotazioni() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant-unit");
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao(emf);
		List<Prenotazione> categorie = prenotazioneDao.findAll();
		emf.close();
		return categorie;
	}

	
}
