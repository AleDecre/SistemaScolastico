package is.sistemascolastico.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Docente extends Utente {

	public ArrayList<Materia> materie_insegnate;
	public HashMap<Classe, String> classe_ins;

	public Docente(String nome, String cognome, LocalDate data_nascita, String CF, String comune_residenza,
			String email, int num_cell, String username, String password) {
		super(nome, cognome, data_nascita, CF, comune_residenza, email, num_cell, username, password);
		materie_insegnate = new ArrayList<Materia>();
		classe_ins = new HashMap<Classe, String>();
	}
	
	public Docente(String nome, String cognome) {
		super(nome, cognome);
		materie_insegnate = new ArrayList<Materia>();
		classe_ins = new HashMap<Classe, String>();
	}

	public void setMateria(Materia materia) {
		this.materie_insegnate.add(materia);
	}

	public ArrayList<Materia> getMateria() {
		return materie_insegnate;
	}

	public void setClasse(Classe classe, String data) {
		this.classe_ins.put(classe, data);
	}

	public Map<Classe, String> getClasse() {
		return classe_ins;
	}

}
