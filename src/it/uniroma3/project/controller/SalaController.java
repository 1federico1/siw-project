package it.uniroma3.project.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.project.facade.ComandaFacade;
import it.uniroma3.project.facade.PrenotazioneFacade;
import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.model.Tavolo;
import it.uniroma3.project.model.Utente;

@ManagedBean(name ="salaController")
@RequestScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PrenotazioneFacade.class),
		@EJB(name = "tFacade", beanInterface = TavoloFacade.class) })
public class SalaController {

	private Comanda comanda;
	private String codiceTavolo;
	private int coperti;
	private List<Tavolo> tavoliSala;
	private Tavolo tavolo;
	private int occupato;

	@EJB
	private TavoloFacade tFacade;

	@EJB
	private PrenotazioneFacade pFacade;

	@EJB
	private ComandaFacade cFacade;

	public String openComanda(){
		this.tavolo = this.tFacade.findTavoloByNumero(this.getByRequest("codiceTavolo"));
		if(this.tavolo.getOccupato()==0 || this.tavolo.getOccupato()==1){
			if(this.tavolo.getOccupato()==1)
				pFacade.setPrenotazioneUtenteAlTavolo(this.tavolo.getId());
			this.comanda = new Comanda();
			tFacade.setTavoloOccupato(tavolo);
			comanda.setOperatore((Utente) this.getBySession("utenteCorrente"));
			comanda.setTavolo(tavolo);
			comanda.setDataOraEmissione(new Date());
			cFacade.inserisciComanda(comanda);
		}
		else
			if(this.tavolo.getOccupato()==2){
				this.comanda = cFacade.findComandaByTavolo(this.tavolo.getId());
			}
		this.setComandaInSession("comandaCorrente");
		return "comanda";
	}

	@PostConstruct
	public void init() {
		if(this.getUtenteCorrente()==null)
			try {
				this.redirectPage("./sessioneScaduta.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			if(!(this.getUtenteCorrente().getRole().equals("admin") || this.getUtenteCorrente().getRole().equals("operatore") )){
				try {
					this.redirectPage("./404.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				this.tavoliSala = this.gettFacade().findAllTavolo();
				Ristorante ristorante = new Ristorante();
				for(Tavolo t : tavoliSala){
					List<Prenotazione> prenotazioni = pFacade.findPrenotazione(t);

					if(ristorante.comandaInCorso(t)==true )
						tFacade.setTavoloOccupato(t);

					if(!prenotazioni.isEmpty() && ristorante.comandaInCorso(t)==false)
						tFacade.setTavoloPrenotato(t);

					if(prenotazioni.isEmpty() && ristorante.comandaInCorso(t)==false)
						tFacade.setTavoloLibero(t);
				}
			}
	}

	private Utente getUtenteCorrente(){
		FacesContext context = FacesContext.getCurrentInstance();
		return (Utente) context.getExternalContext().getSessionMap().get("utenteCorrente");
	}

	private void redirectPage(String page) throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect(page);
	}

	public void setComandaInSession(String name){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put(name,this.comanda);
	}

	public Object getBySession(String name){
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getSessionMap().get(name);
	}

	public String getByRequest(String name){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	public String getCodiceTavolo() {
		return codiceTavolo;
	}

	public void setCodiceTavolo(String codiceTavolo) {
		this.codiceTavolo = codiceTavolo;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public List<Tavolo> getTavoliSala() {
		return tavoliSala;
	}

	public void setTavoliSala(List<Tavolo> tavoliSala) {
		this.tavoliSala = tavoliSala;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public int getOccupato() {
		return occupato;
	}

	public void setOccupato(int occupato) {
		this.occupato = occupato;
	}

	public TavoloFacade gettFacade() {
		return tFacade;
	}

	public void settFacade(TavoloFacade tFacade) {
		this.tFacade = tFacade;
	}

	public PrenotazioneFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PrenotazioneFacade pFacade) {
		this.pFacade = pFacade;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public ComandaFacade getcFacade() {
		return cFacade;
	}

	public void setcFacade(ComandaFacade cFacade) {
		this.cFacade = cFacade;
	}

}
