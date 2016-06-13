package it.uniroma3.project.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import it.uniroma3.project.facade.UtenteFacade;
import it.uniroma3.project.model.Utente;
import it.uniroma3.project.services.mail.EmailManager;
import it.uniroma3.project.services.security.MD5Encrypter;

@ManagedBean(name = "utenteController")
@SessionScoped
@EJB(name = "uFacade", beanInterface = UtenteFacade.class)
public class UtenteController implements Serializable {


	private static final long serialVersionUID = 1L;
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String telefono;
	private String password;
	private String confPassword;

	private Utente utente;

	@EJB(name = "uFacade")
	private UtenteFacade uFacade;

	public String create() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.utente = new Utente(this.nome, this.cognome, this.username, this.telefono, this.email,
				this.getPasswordCriptata());
		// L'utente che sta tentando di creare un account ha inserito una username gi� utilizzata
		if (this.isAlreadyRegistered(this.utente) ){
			context.getExternalContext().getRequestMap().put("utenteError", "Utente con username " + this.username + " gi� esistente" );
			return "loginSignup";
		}
		else
			// le passdword inserite non corrispondo
			if(this.equalsPassword()) {
				context.getExternalContext().getRequestMap().put("utenteError", "Le password non corrispondo" );
				return "loginSignup";
			} else {
				this.utente = uFacade.signUp(this.utente);
				this.setUtenteCorrenteInSession("utenteCorrente");
				return "index_parallax";
			}
	}

	public String createOperatore() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.utente = new Utente(this.username, this.getPasswordCriptata());
		// L'admin che ha tentato di creare l'operatore ha inserito una username gi� utilizzata nel sistema
		if (this.isAlreadyRegistered(this.utente)){
			context.getExternalContext().getRequestMap().put("operatoreError", "Operatore con username " + this.username + " gi� esistente" );
			return "registraPersonale";
		}
		this.uFacade.signUp(utente);
		context.getExternalContext().getRequestMap().put("operatoreCorrente",
				"L' operatore " + this.username + " � stato inserito correttamente");
		return "registraPersonale";

	}

	public String loginUtente() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.utente = this.uFacade.findByUsername(this.getUsername());
		// L'utente che sta tentando di autenticarsi non � registrato nel  sistema
		if (this.isNotAlreadyRegistered(this.utente)) {
			context.getExternalContext().getRequestMap().put("utenteError", "Utente non esistente" );
			return "loginSignup";
		}
		else
			// la password inserita non � corretta per l'account con tale username
			if(this.wrongPassword()){
				context.getExternalContext().getRequestMap().put("utenteError", "Username e/o password errata" );
				return "loginSignup";
			} else {
				this.utente = this.uFacade.findByUsername(utente.getUsername());
				this.setUtenteCorrenteInSession("utenteCorrente");
				return "index_parallax";
			}
	}

	public String loginAdmin() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.utente = this.uFacade.findByUsername(this.getUsername());
		// L'utente che sta tentando di autenticarsi non � registrato nel sistema
		if (this.isNotAlreadyRegistered(this.utente)) {
			context.getExternalContext().getRequestMap().put("utenteError", "Utente non esistente" );
			return "administrator";
		}
		else
			// la password inserita non � corretta per l'account con tale username
			if(this.wrongPassword()){
				context.getExternalContext().getRequestMap().put("utenteError", "Username e/o password errata" );
				return "administrator";
			} else {
				// L'utente � registrato con ruolo admin o operatore
				if (this.utente.getRole().equals("admin")) {
					this.setUtenteCorrenteInSession("utenteCorrente");
					return "home_Administrator?faces-redirect=true";
				} else if (this.utente.getRole().equals("operatore")) {
					this.setUtenteCorrenteInSession("utenteCorrente");
					return "home_Operatore?faces-redirect=true";
					// il ruolo � utente
				} else {
					context.getExternalContext().getRequestMap().put("utenteError", this.username + " Cosa ci fai qui? non � un posto per utenti" );
					return "administrator";
				}
			}
	}

	public boolean isAlreadyRegistered(Utente utente) {
		if (this.uFacade.findByUsername(utente.getUsername()) != null) {
			return true;
		} else
			return false;
	}

	public boolean isNotAlreadyRegistered(Utente utente) {
		if (this.uFacade.findByUsername(this.getUsername()) == null) {
			return true;
		} else
			return false;
	}

	public boolean wrongPassword() {
		if (!this.utente.getPassword().equals(this.getPasswordCriptata())) {
			return true;
		} else
			return false;
	}

	public boolean equalsPassword() {
		if (!this.password.equals(this.confPassword)) {
			return true;
		} else
			return false;
	}

	public String getPasswordCriptata() {
		String toCrypt = this.password;
		MD5Encrypter crypter = new MD5Encrypter();
		return crypter.cryptWithMD5(toCrypt);
	}

	public void logout() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.invalidateSession();
		context.getExternalContext().redirect("index_parallax.jsp");
	}

	public void setUtenteCorrenteInSession(String name) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put(name, this.utente);
	}

	public Utente getUtenteCorrenteInSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (Utente) context.getExternalContext().getSessionMap().get("utenteCorrente");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public UtenteFacade getuFacade() {
		return uFacade;
	}

	public void setuFacade(UtenteFacade uFacade) {
		this.uFacade = uFacade;
	}

}
