package com.dsic.FicheInfo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int sucre;
	private int oeil;
	private int farine;
	@OneToMany(mappedBy = "type")
	private List<Affectation> affectations;

	public Type(String name, int sucre, int oeil, int farine) {
		super();
		this.name = name;
		this.sucre = sucre;
		this.oeil = oeil;
		this.farine = farine;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Affectation> getAffectations() {
		return affectations;
	}
	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}
	
	public int getSucre() {
		return sucre;
	}

	public void setSucre(int sucre) {
		this.sucre = sucre;
	}

	public int getOeil() {
		return oeil;
	}

	public void setOeil(int oeil) {
		this.oeil = oeil;
	}

	public int getFarine() {
		return farine;
	}

	public void setFarine(int farine) {
		this.farine = farine;
	}

	public Type(){
		
	}
}
