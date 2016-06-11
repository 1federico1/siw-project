package it.uniroma3.project.controllerBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import it.uniroma3.project.facade.CategoriaPiattoFacade;
import it.uniroma3.project.facade.ComandaFacade;
import it.uniroma3.project.facade.LineaComandaFacade;
import it.uniroma3.project.facade.PiattoFacade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.Comanda;
import it.uniroma3.project.model.LineaComanda;
import it.uniroma3.project.model.Piatto;

@ManagedBean(name = "comandaController")
@RequestScoped
@EJBs(value = { @EJB(name = "cFacade", beanInterface = ComandaFacade.class),
		@EJB(name = "pFacade", beanInterface = PiattoFacade.class),
		@EJB(name = "cpFacade", beanInterface = CategoriaPiattoFacade.class) })
public class ComandaControllerBean {

	private Long idPiatto;
	private Piatto piatto;
	private List<CategoriaPiatto> categorie;
	private List<Piatto> piatti;
	private List<LineaComanda> linee;

	@EJB
	private ComandaFacade cFacade;
	@EJB
	private PiattoFacade pFacade;
	@EJB
	private CategoriaPiattoFacade cpFacade;
	@EJB
	private LineaComandaFacade lFacade;

	public String addLineaComanda() throws IOException{
		this.piatto = this.pFacade.findById(Long.parseLong(this.getByRequest("piatto")));
		Comanda comandaInCorso = (Comanda) this.getBySession("comandaCorrente");
		LineaComanda linea = lFacade.findLineaByIdPiattoAndComanda(this.piatto.getId(), comandaInCorso.getId());
		if (linea != null) {
			linea.plusQuantity();
			comandaInCorso.setPrezzoTotale(
					comandaInCorso.getPrezzoTotale() + this.piatto.getDescrizionePiatto().getPrezzo());
			lFacade.updateLinea(linea);
		} else if(linea==null){
			linea = new LineaComanda();
			linea.setComanda(comandaInCorso);
			linea.setPiatto(this.piatto);
			linea.setQuantita(1);
			comandaInCorso.setPrezzoTotale(comandaInCorso.getPrezzoTotale() + this.piatto.getDescrizionePiatto().getPrezzo());
			lFacade.inserisciLinea(linea);
		}
		cFacade.updateComanda(comandaInCorso);
		this.refreshPage();
		return "comanda";
	}

	public String aggiungiQuantita() throws IOException{
		Comanda comandaInCorso = (Comanda) this.getBySession("comandaCorrente");
		LineaComanda linea = lFacade.findLineaComanda(Long.parseLong(this.getByRequest("idLineaComanda")));
		linea.plusQuantity();
		comandaInCorso.setPrezzoTotale(
				comandaInCorso.getPrezzoTotale() + linea.getPiatto().getDescrizionePiatto().getPrezzo());
		lFacade.updateLinea(linea);
		cFacade.updateComanda(comandaInCorso);
		this.refreshPage();
		return "comanda";
	}

	public String sottraiQuantita() throws IOException{
		Comanda comandaInCorso = (Comanda) this.getBySession("comandaCorrente");
		LineaComanda linea = lFacade.findLineaComanda(Long.parseLong(this.getByRequest("idLineaComanda")));
		if(linea.getQuantita()>=2){
			linea.minusQuantity();
			comandaInCorso.setPrezzoTotale(
					comandaInCorso.getPrezzoTotale() - linea.getPiatto().getDescrizionePiatto().getPrezzo());
			lFacade.updateLinea(linea);
			cFacade.updateComanda(comandaInCorso);
		}
		this.refreshPage();
		return "comanda";
	}

	public String eliminaLineaComanda() throws IOException{
		Comanda comandaInCorso = (Comanda) this.getBySession("comandaCorrente");
		LineaComanda linea = lFacade.findLineaComanda(Long.parseLong(this.getByRequest("idLineaComanda")));
		comandaInCorso.setPrezzoTotale(
				comandaInCorso.getPrezzoTotale() - (linea.getPiatto().getDescrizionePiatto().getPrezzo())*linea.getQuantita());
		lFacade.eliminaRigaComanda(linea.getId());
		this.refreshPage();
		return "comanda";
	}

	@PostConstruct
	public void init() {
		Comanda comandaInCorso = (Comanda) this.getBySession("comandaCorrente");
		this.categorie = cpFacade.findAll();
		this.piatti = pFacade.findAll();
		this.linee = lFacade.findallLineeComanda(comandaInCorso.getId());
	}

	public String getByRequest(String name){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return params.get(name);
	}

	public void refreshPage() throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("./comanda.jsp");
	}

	public Object getBySession(String name){
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getSessionMap().get(name);
	}

	public List<CategoriaPiatto> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<CategoriaPiatto> categorie) {
		this.categorie = categorie;
	}

	public List<Piatto> getPiatti() {
		return piatti;
	}

	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}

	public ComandaFacade getcFacade() {
		return cFacade;
	}

	public void setcFacade(ComandaFacade cFacade) {
		this.cFacade = cFacade;
	}

	public PiattoFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PiattoFacade pFacade) {
		this.pFacade = pFacade;
	}

	public CategoriaPiattoFacade getCpFacade() {
		return cpFacade;
	}

	public void setCpFacade(CategoriaPiattoFacade cpFacade) {
		this.cpFacade = cpFacade;
	}

	public List<LineaComanda> getLinee() {
		return linee;
	}

	public void setLinee(List<LineaComanda> linee) {
		this.linee = linee;
	}

	public Long getIdPiatto() {
		return idPiatto;
	}

	public void setIdPiatto(Long idPiatto) {
		this.idPiatto = idPiatto;
	}

	public Piatto getPiatto() {
		return piatto;
	}

	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
	}

}
