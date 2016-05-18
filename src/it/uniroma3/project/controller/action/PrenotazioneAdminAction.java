package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.DateValidator;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.validator.Time24HoursValidator;

public class PrenotazioneAdminAction {

	public PrenotazioneAdminAction() {
	}

	public String execute(HttpServletRequest request) {

		Facade facade = new Facade();
		DateValidator validator = new DateValidator();
		Time24HoursValidator validatorTime = new Time24HoursValidator();

		HttpSession session = request.getSession();

		Prenotazione prenotazione = new Prenotazione(validator.validate(request.getParameter("data")),
				validatorTime.validate(request.getParameter("ora")), Integer.parseInt(request.getParameter("ospiti")),
				request.getParameter("nominativo"));

		facade.inserisciPrenotazione(prenotazione);

		session.setAttribute("PRENOTAZIONE", prenotazione);

		return "/home_Administrator.jsp";
	}

}
