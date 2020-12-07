package is.sistemascolastico.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Alunno extends Utente {

	public String matricola;
	public Classe classe_frequentata;
	public Pagella pagella;
	public HashMap<Materia, ArrayList<Double>> voti_materie;

	public Alunno(String nome, String cognome, LocalDate data_nascita, String CF, String comune_residenza, String email,
			int num_cell, String username, String password, String matricola, Classe classe) {
		super(nome, cognome, data_nascita, CF, comune_residenza, email, num_cell, username, password);
		this.matricola = matricola;
		this.classe_frequentata = classe;
		this.pagella = new Pagella();
		this.voti_materie = new HashMap<Materia, ArrayList<Double>>();
	}
	
	public Alunno(String nome, String cognome, LocalDate data_nascita, String CF, String comune_residenza, String email,
			int num_cell, String username, String password) {
		super(nome, cognome, data_nascita, CF, comune_residenza, email, num_cell, username, password);
		this.pagella = new Pagella();
		this.voti_materie = new HashMap<Materia, ArrayList<Double>>();
	}
	
	public Alunno(String nome, String cognome, String matricola, Classe classe) {
		super(nome, cognome);
		this.matricola = matricola;
		this.classe_frequentata = classe;
		this.pagella = new Pagella();
		this.voti_materie = new HashMap<Materia, ArrayList<Double>>();
	}
	
	public Alunno(String nome, String cognome, String matricola) {
		super(nome, cognome);
		this.matricola = matricola;
		this.pagella = new Pagella();
		this.voti_materie = new HashMap<Materia, ArrayList<Double>>();
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;

	}

	public String getMatricola() {
		return matricola;
	}

	public void setClasse(Classe classe) {
		this.classe_frequentata = classe;

	}

	public Classe getClasse() {
		return classe_frequentata;

	}

}
