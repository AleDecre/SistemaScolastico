package is.sistemascolastico.entity;

import java.time.LocalDate;
import java.util.*;

public class Genitore extends Utente {

	public ArrayList<Alunno> figli;

	public Genitore(String nome, String cognome, LocalDate data_nascita, String CF, String comune_residenza,
			String email, int num_cell, String username, String password) {
		super(nome, cognome, data_nascita, CF, comune_residenza, email, num_cell, username, password);
		figli = new ArrayList<Alunno>();
	}

	public Genitore(String nome, String cognome) {
		super(nome, cognome);
		figli = new ArrayList<Alunno>();
	}

	public void setFiglio(Alunno figlio) {
		figli.add(figlio);
	}

	public ArrayList<Alunno> getFiglio() {
		return figli;
	}

}
