package it.uniroma3.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.project.model.Ristorante;

public class RistoranteTest {
	private Tavolo t1;
	private Tavolo t2;
	private List<Tavolo> tavoli;
	private Ristorante ristorante;
	private Prenotazione p1;
	private Prenotazione p2;
	private List<Prenotazione> prenotazioni;

	@Before
	public void setUp() throws Exception {
		this.t1 = new Tavolo(2);
		this.t1.setCodiceTavolo("1");
		this.t2 = new Tavolo(4);
		this.t2.setCodiceTavolo("2");
		this.tavoli = new ArrayList<>();
		this.tavoli.add(t1);
		this.tavoli.add(t2);
		this.prenotazioni = new ArrayList<>();
		this.p1 = new Prenotazione(new Date(), new Date(), 2, "Testers");
		this.p1.setTavoloPrenotato(this.t1);
		this.p2 = new Prenotazione(new Date(), new Date(), 4, "AncoraTesters");
		this.prenotazioni.add(this.p1);
	}

	@Test
	public void testSetTavoloPrenotazioneNessunTavoloDisponibile() {
		this.ristorante = new Ristorante(8);
		assertEquals(0, this.ristorante.setTavoloPrenotazione(tavoli).size());
	}

	@Test
	public void testSetTavoloPrenotazioneUnTavoloDisponibile() {
		this.ristorante = new Ristorante(3);
		List<Tavolo> tavoliDisponibili = this.ristorante.setTavoloPrenotazione(tavoli);
		assertEquals(1, tavoliDisponibili.size());
		assertTrue(tavoliDisponibili.get(0).equals(this.t2));
	}

	@Test
	public void testSetTavoloPrenotazionePiuTavoliDisponibili() {
		this.ristorante = new Ristorante(2);
		List<Tavolo> tavoliDisponibili = this.ristorante.setTavoloPrenotazione(this.tavoli);
		assertEquals(2, tavoliDisponibili.size());
	}

	@Test
	public void testCheckTavoliLiberoTodayNessunTavoloLibero() {
		this.ristorante = new Ristorante(6);
		assertNull(this.ristorante.checkTavoliLiberoToday(this.prenotazioni,
				this.ristorante.setTavoloPrenotazione(this.tavoli), new Date()));
	}

	@Test
	public void testCheckTavoloLiberoTodayUnTavoloLibero() {
		this.ristorante = new Ristorante(2);
		assertEquals(this.t2, this.ristorante.checkTavoliLiberoToday(this.prenotazioni,
				this.ristorante.setTavoloPrenotazione(this.tavoli), new Date()));

	}

	@Test
	public void testCheckTavoloLiberoTodayTavoliGi�Prenotati() {
		this.ristorante = new Ristorante(2);
		this.p2.setTavoloPrenotato(this.t2);
		List<Tavolo> tavoliDisponibili = this.ristorante.setTavoloPrenotazione(this.tavoli);
		assertEquals(2,tavoliDisponibili.size());
		assertNull(this.ristorante.checkTavoliLiberoToday(this.prenotazioni,tavoliDisponibili, new Date()));
	}

}
