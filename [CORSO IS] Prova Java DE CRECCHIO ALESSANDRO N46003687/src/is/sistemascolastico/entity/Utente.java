package is.sistemascolastico.entity;

import java.time.LocalDate;

public class Utente {

	public String nome;
	public String cognome;
	private LocalDate data_nascita;
	private String CF;
	private String comune_residenza;
	private String email;
	private int num_cell;
	private String username;
	private String password;

	public Utente(String nome, String cognome, LocalDate data_nascita, String CF, String comune_residenza, String email,
			int num_cell, String username, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.CF = CF;
		this.comune_residenza = comune_residenza;
		this.email = email;
		this.num_cell = num_cell;
		this.username = username;
		this.password = password;
	}
	
	public Utente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setData(LocalDate data) {
		this.data_nascita = data;
	}

	public LocalDate getData() {
		return data_nascita;
	}

	public void setCF(String CF) {
		this.CF = CF;
	}

	public String getCF() {
		return CF;
	}

	public void setComune(String comune) {
		this.comune_residenza = comune;
	}

	public String getComune() {
		return comune_residenza;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setNum(int num) {
		this.num_cell = num;
	}

	public int getNum() {
		return num_cell;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}
