package is.sistemascolastico.entity;

import java.util.ArrayList;

public class Classe {

	public String sezione;
	public String anno; // poiche' numeri romani allora uso string
	public ArrayList<Docente> docenti;
	public ArrayList<Alunno> alunni;

	public Classe(String sezione, String anno) {
		this.sezione = sezione;
		this.anno = anno;
		docenti = new ArrayList<Docente>();
		alunni = new ArrayList<Alunno>();
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getSezione() {
		return new String(sezione);
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getAnno() {
		return new String(anno);
	}

	public void setDocente(Docente docente) {
		docenti.add(docente);
	}

	public ArrayList<Docente> getDocente() {
		return docenti;
	}

	public void setAlunno(Alunno alunno) {
		alunni.add(alunno);
	}

	public ArrayList<Alunno> getAlunno() {
		return alunni;
	}
}
