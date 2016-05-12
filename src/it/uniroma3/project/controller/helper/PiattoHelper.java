package it.uniroma3.project.controller.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PiattoHelper {

	public boolean validate(HttpServletRequest request) {
		String nomePiatto = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		String url = request.getParameter("url");
		String nomeCategoria = request.getParameter("nomeCategoria");
		boolean isValid = true;
		HttpSession session = request.getSession();
		if(nomeCategoria.equals("")) {
			isValid = false;
			String nomeCategoriaError = "Categoria obbligatoria";
			session.setAttribute(nomeCategoria, nomeCategoriaError);
		}
		if(nomePiatto.equals("")) {
			isValid = false;
			String nomeError = "Nome obbligatorio";
			session.setAttribute("nomeError", nomeError);
		}
		if(descrizione.equals("")) {
			isValid = false;
			String descrizioneError = "Descrizione obbligatoria";
			session.setAttribute("descrizioneError", descrizioneError);
		}
		
		/*da mettere in metodo validator per double */
		try {
			Double.parseDouble(prezzo);
		} catch(NumberFormatException e) {
			isValid = false;
			String prezzoError = "Prezzo obbligatorio";
			session.setAttribute("prezzoError", prezzoError);
		}
		
		if(prezzo.equals("")) {
			isValid = false;
			String prezzoError = "Prezzo obbligatorio";
			session.setAttribute("prezzoError", prezzoError);
		}
		if(url.equals("")) {
			isValid = false;
			String urlError = "Url dell'immagine obbligatorio";
			session.setAttribute("urlError", urlError);
		}
		if(isValid == false) {
			String error = "ERRORE";
			session.setAttribute("Errore", error);
		}
		return isValid;
	}

}
