package it.uniroma3.project.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.uniroma3.project.entity.Prenotazione;
import it.uniroma3.project.entity.Tavolo;
import it.uniroma3.validator.Time24HoursValidator;

public class Ristorante {
	private int numeroOspiti;
	private static int MAX = 15;

	public Ristorante(int numeroOspiti) {
		this.numeroOspiti = numeroOspiti;
	}

	/**
	 * Controlla se c'� un tavolo per il numero di posti
	 * 
	 * @param tavoli
	 * @return
	 */
	public List<Tavolo> setTavoloPrenotazione(List<Tavolo> tavoli) {
		List<Tavolo> tavoliCompatibili = new ArrayList<>();
		int posti = this.numeroOspiti;
		while (posti <= MAX) {
			for (Tavolo t : tavoli) {
				if (posti == t.getCoperti()) {
					tavoliCompatibili.add(t);
				}
			}
			posti++;
		}
		return tavoliCompatibili;
	}

	/**
	 * controlla se il tavolo � libero per la data scelta
	 * 
	 * @return
	 */
	public Tavolo checkTavoliLiberiForDate(List<Tavolo> tavoliDisponibili, Date data) {
		Time24HoursValidator validatorD = new Time24HoursValidator();
		for (Tavolo t : tavoliDisponibili) {
			if (t.getPrenotazioni().isEmpty())
				return t;
			else
				for (Prenotazione p : t.getPrenotazioni()) {
					if (!validatorD.SameDate(data, p.getData()))
						return t;
				}
		}
		return null;
	}
}
