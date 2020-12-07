package is.sistemascolastico;

import is.sistemascolastico.entity.*;
import is.sistemascolastico.control.*;

public class Main {

	public static void main(String[] args) {

		SistemaScolastico sistema = new SistemaScolastico();

		Classe classe1 = new Classe("A", "I");

		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		classe1.setAlunno(alunno1);

		Docente docente1 = new Docente("Roberto", "Natella");
		docente1.setMateria(Materia.ITALIANO);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		Docente docente2 = new Docente("Roberto", "Pietrantuono");
		docente2.setMateria(Materia.MATEMATICA);
		docente2.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente2);

		Docente docente3 = new Docente("Marcello", "Cinque");
		docente3.setMateria(Materia.STORIA);
		docente3.setClasse(classe1, "2019/2020");

		Genitore genitore1 = new Genitore("Tizio", "Caio");
		genitore1.setFiglio(alunno1);

		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addDocente(docente2);
		sistema.addDocente(docente3);
		sistema.addGenitore(genitore1);

		sistema.addVoto(docente1, alunno1, 4, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 7, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente2, alunno1, 8, Materia.MATEMATICA);
		sistema.addVoto(docente2, alunno1, 8, Materia.MATEMATICA);
		sistema.addVoto(docente2, alunno1, 9, Materia.MATEMATICA);
		sistema.addVoto(docente3, alunno1, 7, Materia.STORIA);
		sistema.addVoto(docente3, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente3, alunno1, 9, Materia.STORIA);

		sistema.generaPagella(alunno1);
		sistema.apportaModifichePagellaEccesso(docente2, alunno1, Materia.MATEMATICA);
		sistema.apportaModifichePagellaEccesso(docente3, alunno1, Materia.STORIA);
		sistema.apportaModifichePagellaEccesso(docente1, alunno1, Materia.ITALIANO);
		sistema.approvaPagella(alunno1);

		System.out.println("L'alunno " + alunno1.nome + " " + alunno1.cognome + " ha ottenuto i seguenti voti:");
		System.out.println(alunno1.voti_materie.toString() + "\n");
		System.out.println ("I voti in pagella (arrotondati per eccesso) sono: ");
		System.out.println(sistema.visionaVotiPagella(genitore1, alunno1) + "\n");
		System.out.println ("La media finale in pagella e': ");
		System.out.println(sistema.visionaMedia(genitore1, alunno1));
	}

}
