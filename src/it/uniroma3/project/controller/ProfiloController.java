package it.uniroma3.project.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.model.Prenotazione;

@ManagedBean(name="profiloController")
@RequestScoped
@EJB(name = "pFacade", beanInterface = PrenotazioneFacade.class)
public class ProfiloController {

	private List<Prenotazione> prenotazioniUtente;

	@EJB
	private PrenotazioneFacade pFacade;

	public String eliminaPrenotazioneDaProfilo(){
		this.pFacade.eliminaPrenotazioneByID(Long.parseLong(SessionAndRequestManager.getByRequest("idPrenotazione")));
		return "profilo?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		SessionAndRequestManager.sessionCheckerUtente();

		this.prenotazioniUtente = pFacade.findAllPrenotazioniUtente(SessionAndRequestManager.getUtenteCorrente().getId());
	}

	public PrenotazioneFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PrenotazioneFacade pFacade) {
		this.pFacade = pFacade;
	}

	public List<Prenotazione> getPrenotazioniUtente() {
		return prenotazioniUtente;
	}

	public void setPrenotazioniUtente(List<Prenotazione> prenotazioniUtente) {
		this.prenotazioniUtente = prenotazioniUtente;
	}

}
