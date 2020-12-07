package is.sistemascolastico.control;

import java.util.*;
import is.sistemascolastico.entity.*;

public class SistemaScolastico {

	public ArrayList<Docente> docenti;
	public ArrayList<Alunno> alunni;
	public ArrayList<Genitore> genitori;
	public ArrayList<Classe> classi;
	public ArrayList<Pagella> pagelle;

	public SistemaScolastico() {
		docenti = new ArrayList<Docente>();
		alunni = new ArrayList<Alunno>();
		genitori = new ArrayList<Genitore>();
		classi = new ArrayList<Classe>();
		pagelle = new ArrayList<Pagella>();
	}

	public void addDocente(Docente d) {
		docenti.add(d);
	}

	public void addAlunno(Alunno a) {
		alunni.add(a);
	}

	public void addGenitore(Genitore g) {
		genitori.add(g);
	}

	public void addVoto(Docente docente, Alunno alunno, double voto, Materia materia) {

		boolean contenuto1 = docente.materie_insegnate.contains(materia);
		boolean contenuto2 = docente.classe_ins.containsKey(alunno.classe_frequentata);
		if (voto > 0 && voto < 10) {
			if (contenuto1) {
				if (contenuto2) {
					if (alunno.voti_materie.get(materia) == null) {
						alunno.voti_materie.put(materia, new ArrayList<Double>());
					}
					alunno.voti_materie.get(materia).add(voto);
					/*
					 * System.out.println("Voto " + voto + " aggiunto dal docente " + docente.nome +
					 * " " + docente.cognome + " in " + materia + " all'alunno " + alunno.nome + " "
					 * + alunno.cognome + "\n");
					 */
				} else {
					// System.out.println("Non e' possibile aggiungere un voto se non si insegna in
					// questa classe!\n");
				}
			} else {
				// System.out.println("Non e' possibile aggiungere un voto se non si insegna
				// questa materia!\n");
			}
		}

	}

	public boolean generaPagella(Alunno alunno) {

		if (!alunno.pagella.generata) {
			for (Materia materia1 : Materia.values()) {
				if (!alunno.voti_materie.containsKey(materia1)) {
					// System.out.println("Non e' possibile approvare la pagella se non sono
					// inseriti tutti i voti!\n");
					return false;
				} else {
					double num_voti = 0;
					double somma = 0;
					double media = 0;
					for (int i = 0; i < alunno.voti_materie.get(materia1).size(); i++) {
						num_voti = num_voti + 1;
						somma = somma + alunno.voti_materie.get(materia1).get(i);
					}
					media = Math.floor(somma / num_voti);
					alunno.pagella.setVotiSingoli(materia1, media);
				}
			}
		}

		double num_voti = 0;
		double somma = 0;
		double media = 0;
		for (double voto : alunno.pagella.voti_singoli.values()) {
			num_voti = num_voti + 1;
			somma = somma + voto;
		}
		media = somma / num_voti;
		alunno.pagella.setMedia(media);

		alunno.pagella.setGenerata();

		return alunno.pagella.generata;
	}

	public void apportaModifichePagellaEccesso(Docente docente, Alunno alunno, Materia materia) {

		boolean contenuto1 = docente.materie_insegnate.contains(materia);
		boolean contenuto2 = docente.classe_ins.containsKey(alunno.classe_frequentata);
		boolean contenuto3 = alunno.pagella.voti_singoli.containsKey(materia);

		if (contenuto1) {
			if (contenuto2) {
				if (!alunno.pagella.approvata) {
					if (contenuto3) {

						double num_voti = 0;
						double somma = 0;
						double media = 0;
						for (int i = 0; i < alunno.voti_materie.get(materia).size(); i++) {
							num_voti = num_voti + 1;
							somma = somma + alunno.voti_materie.get(materia).get(i);
						}
						media = Math.ceil(somma / num_voti);
						alunno.pagella.setVotiSingoli(materia, media);
						num_voti = 0;
						somma = 0;
						media = 0;
						for (double voto : alunno.pagella.voti_singoli.values()) {
							num_voti = num_voti + 1;
							somma = somma + voto;
						}
						media = somma / num_voti;
						alunno.pagella.setMedia(media);
						// System.out.println("Voto modificato per eccesso!");
					} else {
						// System.out.println("Non e' possibile modificare un voto se non e' gia'
						// presente!");
					}
				} else {
					// System.out.println("Non e' possibile modificare un voto con pagella
					// approvata!");
				}
			} else {
				// System.out.println("Non e' possibile aggiungere un voto se non si insegna in
				// questa classe!\n");
			}
		} else {
			// System.out.println("Non e' possibile aggiungere un voto se non si insegna
			// questa materia!\n");
		}

	}

	public boolean approvaPagella(Alunno alunno) {
		if (alunno.pagella.generata == false) {
			// System.out.println("Non e' possibile approvare la pagella se non e' stata
			// ancora generata!\n");
		} else {
			alunno.pagella.setApprovata();
			// System.out.println("Pagella approvata all'alunno " + alunno.nome + " " +
			// alunno.cognome + "\n");
		}
		return alunno.pagella.approvata;
	}

	public double visionaMedia(Genitore genitore, Alunno alunno) {

		if (genitore != null && alunno != null) {

			boolean contenuto1 = genitore.figli.contains(alunno);
			if (contenuto1 && alunno.pagella.approvata) {
				return alunno.pagella.media_voti;
				/*
				 * System.out.println("La media dei voti della pagella dell'alunno " +
				 * alunno.nome + " " + alunno.cognome + " e': " + alunno.pagella.media_voti +
				 * "\n");
				 */
			} else {
				return -1;
				// System.out.println("Non e' possibile visualizzare la media poiche' pagella
				// non ancora approvata!\n");
			}
		} else {
			return -1;
		}

	}

	public HashMap<Materia, Double> visionaVotiPagella(Genitore genitore, Alunno alunno) {
		HashMap<Materia, Double> voti_pagella = new HashMap<Materia, Double>();
		if (genitore != null && alunno != null) {
			boolean contenuto1 = genitore.figli.contains(alunno);
			if (contenuto1 && alunno.pagella.approvata) {
				// System.out.println("I voti in pagella dell'alunno " + alunno.nome + " " +
				// alunno.cognome + " sono:");
				for (Materia materia : alunno.pagella.voti_singoli.keySet()) {
					voti_pagella.put(materia, alunno.pagella.voti_singoli.get(materia));
					// System.out.println(materia + " " + alunno.pagella.voti_singoli.get(materia));
				}
				// System.out.println("");
			} else {
				voti_pagella = null;
				// System.out.println("Non e' possibile visualizzare i voti poiche' pagella non
				// approvata!\n");
			}
		} else {
			voti_pagella = null;
		}
		return voti_pagella;
	}

	public HashMap<Materia, ArrayList<Double>> visionaVotiDettaglio(Genitore genitore, Alunno alunno) {

		HashMap<Materia, ArrayList<Double>> voti_dettaglio = new HashMap<Materia, ArrayList<Double>>();
		if (genitore != null && alunno != null) {
			boolean contenuto1 = genitore.figli.contains(alunno);
			if (contenuto1) {
				// System.out.println("I voti dell'alunno " + alunno.nome + " " + alunno.cognome
				// + " sono:");
				for (Materia materia : Materia.values()) {
					if (alunno.voti_materie.get(materia) == null) {
						// System.out.println("Per " + materia + " non ci sono voti!");
						continue;
					} else {
						// System.out.println(materia + ":");
						if (voti_dettaglio.get(materia) == null) {
							voti_dettaglio.put(materia, new ArrayList<Double>());
						}
						for (int i = 0; i < alunno.voti_materie.get(materia).size(); i++) {
							voti_dettaglio.get(materia).add(alunno.voti_materie.get(materia).get(i));
							// System.out.println(alunno.voti_materie.get(materia).get(i) + ";");
						}
					}
				}
				// System.out.println("");
			} else {
				voti_dettaglio = null;
				// System.out.println("Non puoi vedere i voti di un figlio che non e' tuo!");
			}
		} else {
			voti_dettaglio = null;
		}
		return voti_dettaglio;
	}

}