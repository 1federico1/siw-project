package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.Facade;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.security.MD5Encrypter;

public class RegistrazionePersonaleAction {


	public RegistrazionePersonaleAction() {
	}

	public String execute(HttpServletRequest request) {
		Utente personale = new Utente();
		Facade facade = new Facade();
		MD5Encrypter encrypter = new MD5Encrypter();


		personale.setUsername(request.getParameter("username"));
		personale.setPassword(encrypter.cryptWithMD5(request.getParameter("password")));
		personale.setRole(request.getParameter("role"));
		facade.inserisciUtente(personale);
		facade.closeEntityManager();

		return "/registraPersonale.jsp";
	}



}