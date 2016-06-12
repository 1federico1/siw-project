package it.uniroma3.project.controllerBean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import it.uniroma3.project.facade.CategoriaPiattoFacade;
import it.uniroma3.project.facade.PiattoFacade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.DescrizionePiatto;
import it.uniroma3.project.model.Piatto;

@ManagedBean
@RequestScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PiattoFacade.class),
		@EJB(name = "cpFacade", beanInterface = CategoriaPiattoFacade.class) })
public class PiattoControllerBean {

	@ManagedProperty(value = "#{param.id}")
	private Long id;

	private String nome;
	private String descrizione;
	private double prezzo;
	private boolean surgelati;
	private boolean allergeni;
	private Piatto piatto;
	private CategoriaPiatto categoria;
	private UploadedFile uploadedFile;
	private List<CategoriaPiatto> categorie;

	@EJB(name = "cpFacade")
	private CategoriaPiattoFacade cpFacade;

	@EJB(name = "pFacade")
	private PiattoFacade pFacade;

	public String create() {
		FacesContext context = FacesContext.getCurrentInstance();
		DescrizionePiatto descrizionePiatto = createDescrizionePiatto();
		this.categoria = this.cpFacade.findByName(this.nomeCategoria);
		this.piatto = this.pFacade.create(nome, descrizionePiatto, this.categoria);
		context.getExternalContext().getRequestMap().put("piattoCorrente", "il piatto " + this.nome + " � stato inserito correttamente");
		return "piattoInserito";
	}

	private DescrizionePiatto createDescrizionePiatto() {
		DescrizionePiatto descrizionePiatto = new DescrizionePiatto();
		descrizionePiatto.setDescrizione(this.descrizione);
		descrizionePiatto.setPrezzo(this.prezzo);
		descrizionePiatto.setProdottiAllergizzanti(this.allergeni);
		descrizionePiatto.setProdottiSurgelati(this.surgelati);
		descrizionePiatto.setUrlImmagine(createImage());
		return descrizionePiatto;
	}

	public String createImage() {
		Path file = null ;
		try {
			String separator = File.separator;
			Path folder = Paths.get("C:"+separator+"Users"+separator+"Federico"+separator+"test");
			String filename = FilenameUtils.getBaseName(uploadedFile.getName());
			String extension = FilenameUtils.getExtension(uploadedFile.getName());
			file = Files.createTempFile(folder, filename + "-", "." + extension);
			InputStream input = uploadedFile.getInputStream();
			Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					String.format("File '%s' of type '%s' successfully uploaded!", filename, extension)));
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error in loading file"));
		}
		return file.toString();
	}

	public List<String> getNomiCategorie() {
		return nomiCategorie;
	}

	public void setNomiCategorie(List<String> nomiCategorie) {
		this.nomiCategorie = nomiCategorie;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	private List<String> nomiCategorie;

	private String nomeCategoria;

	public List<CategoriaPiatto> getCategorie() {
		return this.categorie;
	}

	public String getCategorieToPage() {
		return "inserimentoPiatti";
	}

	public void setCategorie(List<CategoriaPiatto> categorie) {
		this.categorie = categorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isSurgelati() {
		return surgelati;
	}

	public void setSurgelati(boolean surgelati) {
		this.surgelati = surgelati;
	}

	public boolean isAllergeni() {
		return allergeni;
	}

	public void setAllergeni(boolean allergeni) {
		this.allergeni = allergeni;
	}

	public Piatto getPiatto() {
		return piatto;
	}

	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public CategoriaPiatto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPiatto categoria) {
		this.categoria = categoria;
	}

	public CategoriaPiattoFacade getCpFacade() {
		return cpFacade;
	}

	public void setCpFacade(CategoriaPiattoFacade cpFacade) {
		this.cpFacade = cpFacade;
	}

	public PiattoFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PiattoFacade pFacade) {
		this.pFacade = pFacade;
	}

	@PostConstruct
	public void init() {
		this.categorie = this.cpFacade.findAll();
		this.nomiCategorie = new ArrayList<>();
		this.categorie = this.cpFacade.findAll();
		for (CategoriaPiatto c : this.categorie) {
			this.nomiCategorie.add(c.getNome());
		}
	}

}