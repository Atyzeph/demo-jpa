package fr.digi.d12;

import javax.persistence.*;

@Entity
@Table(name="Livre")

public class Livre {


	@Id
	private int id;
	

	@Column(name="TITRE", length=255, nullable=false, unique=true)
	private String titre;

	@Column(name="AUTEUR", length=50, nullable=false, unique=true)
	private String auteur;
	
	public Livre() {
	
	}

	
	@Override
	public String toString() {
		return "Livre : " + id + " Titre : " + titre + ", Auteur : " + auteur;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
	
}
