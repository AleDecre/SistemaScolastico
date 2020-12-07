package is.sistemascolastico.entity;

import java.time.LocalDate;
import java.util.*;

public class RegistroElettronico {
	public Classe classe_riferimento;
	public LocalDate anno_riferimento;
	public Map<LocalDate, String> attivita;

	public RegistroElettronico(Classe classe, LocalDate anno) {
		this.classe_riferimento = classe;
		this.anno_riferimento = anno;
		attivita = new HashMap<LocalDate, String>();
	}

	public void setAttivita(LocalDate giorno_attivita, String attivita) {
		this.attivita.put(giorno_attivita, attivita);
	}

	public Map<LocalDate, String> getAttivita() {
		return attivita;
	}

}
