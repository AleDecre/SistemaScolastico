package is.sistemascolastico.entity;

import java.util.*;

public class Pagella {

	public boolean generata;
	public boolean approvata;
	public double media_voti;
	public HashMap<Materia, Double> voti_singoli;

	public Pagella() {
		this.approvata = false;
		this.generata = false;
		this.media_voti= 0;
		voti_singoli = new HashMap<Materia, Double>();
	}

	public void setMedia(double media) {
		this.media_voti = media;
	}

	public double getMedia() {
		return media_voti;
	}

	public void setApprovata() {
		this.approvata = true;
	}

	public boolean getApprovata() {
		return approvata;
	}

	public void setGenerata() {
		this.generata = true;
	}

	public boolean getGenerata() {
		return generata;
	}

	public void setVotiSingoli(Materia materia, double voto) {
		if (!approvata) {
			voti_singoli.put(materia, voto);
		}
	}

	public Map<Materia, Double> getVotiSingoli() {
		return voti_singoli;
	}

}
