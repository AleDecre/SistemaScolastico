package is.sistemascolastico.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import is.sistemascolastico.control.SistemaScolastico;
import is.sistemascolastico.entity.Alunno;
import is.sistemascolastico.entity.Classe;
import is.sistemascolastico.entity.Docente;
import is.sistemascolastico.entity.Genitore;
import is.sistemascolastico.entity.Materia;


class SistemaScolasticoTest {
	
	SistemaScolastico sistema;
	Classe classe1, classe2;
	Alunno alunno1, alunno2;
	Docente docente1;
	Genitore genitore1, genitore2;

	@Test
	void test01visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
		
		
		assertEquals(null, sistema.visionaVotiPagella(genitore1, alunno1));

	}
	
	@Test
	void test02visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		Classe classe2 = new Classe("B", "II");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe2, "2019/2020");
		classe2.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
		
		
		assertEquals(null, sistema.visionaVotiPagella(genitore1, alunno1));

	}
	
	@Test
	void test03visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, -6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
		
		assertEquals(null, sistema.visionaVotiPagella(genitore1, alunno1));

	}
	
	@Test
	void test04visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 11, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
		
		assertEquals(null, sistema.visionaVotiPagella(genitore1, alunno1));

	}
	
	@Test
	void test05visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
		
		assertEquals(null, sistema.visionaVotiPagella(null, alunno1));

	}
	
	@Test
	void test06visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
		
		assertEquals(null, sistema.visionaVotiPagella(genitore1, null));

	}
	
	@Test
	void test07visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		Alunno alunno2 = new Alunno("Tizio", "Cao", "N26003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		classe1.setAlunno(alunno2);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);
		
		genitore1.setFiglio(alunno2);	

		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
	
		assertEquals(null, sistema.visionaVotiPagella(genitore1, alunno1));

	}
	
	@Test
	void test08visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
		
		assertEquals(null, sistema.visionaVotiPagella(genitore1, alunno1));

	}
	
	@Test
	void test09visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.approvaPagella(alunno1);
		
		assertEquals(null, sistema.visionaVotiPagella(genitore1, alunno1));

	}
	
	@Test
	void test10visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		
		assertEquals(null, sistema.visionaVotiPagella(genitore1, alunno1));

	}
	
	@Test
	void test11visionaVotiPagella() {
		
		sistema = new SistemaScolastico();
		
		Classe classe1 = new Classe("A", "I");
		
		Alunno alunno1 = new Alunno("Alessandro", "De Crecchio", "N46003687", classe1);
		
		Docente docente1 = new Docente("Roberto", "Natella");
		
		Genitore genitore1 = new Genitore("Pippo", "Pluto");

		classe1.setAlunno(alunno1);
		
		docente1.setMateria(Materia.ITALIANO);
		docente1.setMateria(Materia.STORIA);
		docente1.setMateria(Materia.MATEMATICA);
		docente1.setClasse(classe1, "2019/2020");
		classe1.setDocente(docente1);

		genitore1.setFiglio(alunno1);		
		
		sistema.addAlunno(alunno1);
		sistema.addDocente(docente1);
		sistema.addGenitore(genitore1);
		
		sistema.addVoto(docente1, alunno1, 6, Materia.ITALIANO);
		sistema.addVoto(docente1, alunno1, 6, Materia.STORIA);
		sistema.addVoto(docente1, alunno1, 6, Materia.MATEMATICA);
		
		sistema.generaPagella(alunno1);
		sistema.approvaPagella(alunno1);
		
		assertEquals(Materia.values().length, sistema.visionaVotiPagella(genitore1, alunno1).size());

	}

}
