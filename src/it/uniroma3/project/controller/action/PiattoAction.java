package it.uniroma3.project.controller.action;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.persistence.entity.CategoriaPiatto;
import it.uniroma3.project.persistence.entity.DescrizionePiatto;
import it.uniroma3.project.persistence.entity.Piatto;
import it.uniroma3.validator.DoubleValidator;

public class PiattoAction {

	public PiattoAction() {
	}

	public String execute(HttpServletRequest request) {
		Facade facade = new Facade();

		DoubleValidator validator = new DoubleValidator();
		DescrizionePiatto descrizionePiatto = new DescrizionePiatto();
		descrizionePiatto.setDescrizione(request.getParameter("descrizione"));
		descrizionePiatto.setPrezzo(validator.doubleValidator(request.getParameter("prezzo")));
		descrizionePiatto.setUrlImmagine(request.getParameter("immagine"));
		descrizionePiatto.setProdottiAllergizzanti(Boolean.parseBoolean(request.getParameter("allergeni")));
		descrizionePiatto.setProdottiSurgelati(Boolean.parseBoolean(request.getParameter("surgelati")));

		CategoriaPiatto categoria = facade.findCategoria(request.getParameter("categoria"));

		Piatto piatto = new Piatto(request.getParameter("nome"), descrizionePiatto, categoria);

		facade.inserisciPiatto(piatto);

		return "/inserimentoPiatti.jsp";
	}

}
