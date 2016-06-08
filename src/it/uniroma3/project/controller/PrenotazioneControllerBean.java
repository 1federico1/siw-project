package it.uniroma3.project.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import it.uniroma3.project.facade.PrenotazioneAdminFacade;
import it.uniroma3.project.facade.TavoloFacade;
import it.uniroma3.project.model.Prenotazione;
import it.uniroma3.project.model.Ristorante;
import it.uniroma3.project.model.Tavolo;
import it.uniroma3.project.services.validator.Time24HoursValidator;

@ManagedBean
@RequestScoped
@EJBs(value = { @EJB(name = "paFacade", beanInterface = PrenotazioneAdminFacade.class),
		@EJB(name = "tFacade", beanInterface = TavoloFacade.class) })
public class PrenotazioneControllerBean {

	private Date datepicker;
	private int coperti;
	private Date timepicker;
	private String nominativo;
	private boolean corretto;

	private Prenotazione prenotazione;
	private List<Tavolo> tavoli;

	@EJB(name = "paFacade")
	private PrenotazioneAdminFacade paFacade;

	@EJB(name = "tFacade")
	private TavoloFacade tFacade;

	public String createByAdmin() {
		String page = "prenotazioneAdmin";
		Time24HoursValidator validatorD = new Time24HoursValidator();
		try {
			Tavolo tavolo = this.validateTable();

			this.prenotazione = paFacade.create(this.getNominativo(), this.getDatepicker(), this.getTimepicker(),
					this.getCoperti(), tavolo);
			this.corretto = true;
			if (validatorD.isToday(this.prenotazione.getData())) {
				tFacade.setTavoloPrenotato(tavolo);
			}
		} catch (ValidatorException e) {
			this.corretto = false;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Non ci sono tavoli disponibili per il "
							+ validatorD.ConvertDateToString(this.datepicker) + " per " + this.coperti + " persone",
							null));
			new FacesMessage(e.getMessage());
		}
		return page;
	}

	public Tavolo validateTable() throws ValidatorException {
		this.tavoli = this.tFacade.findAllTavolo();
		Ristorante ristorante = new Ristorante();
		List<Tavolo> tavoliDisponibili = ristorante.setTavoloPrenotazione(this.tavoli, this.coperti);
		Tavolo tavoloDaPrenotare = ristorante.checkTavoliLiberiForDate(tavoliDisponibili, this.datepicker);
		if (tavoliDisponibili.isEmpty()) {
			this.corretto = false;
			FacesMessage msg = new FacesMessage("Non ci sono tavoli disponibili per questo numero di ospiti");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		} else if (tavoloDaPrenotare == null) {
			this.corretto = false;
			FacesMessage msg = new FacesMessage("Non ci sono tavoli disponibili per questo numero di ospiti");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		} else {
			return tavoloDaPrenotare;
		}

	}

	public Date getDatepicker() {
		return datepicker;
	}

	public void setDatepicker(Date datepicker) {
		this.datepicker = datepicker;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public Date getTimepicker() {
		return timepicker;
	}

	public void setTimepicker(Date timepicker) {
		this.timepicker = timepicker;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public PrenotazioneAdminFacade getPaFacade() {
		return paFacade;
	}

	public void setPaFacade(PrenotazioneAdminFacade paFacade) {
		this.paFacade = paFacade;
	}

	public List<Tavolo> getTavoli() {
		return tavoli;
	}

	public void setTavoli(List<Tavolo> tavoli) {
		this.tavoli = tavoli;
	}

	public TavoloFacade gettFacade() {
		return tFacade;
	}

	public void settFacade(TavoloFacade tFacade) {
		this.tFacade = tFacade;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean error) {
		this.corretto = error;
	}

}
