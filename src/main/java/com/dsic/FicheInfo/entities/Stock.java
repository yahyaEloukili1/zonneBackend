package com.dsic.FicheInfo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String reference;
	private int quantite;
	private int quantiteSucre;
	private int quantiteFarine;
	private int quantiteOeil;
	@OneToMany(mappedBy = "stock")
	private List<Affectation> affectations;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(String reference, int quantite) {
		super();
		this.reference = reference;
		this.quantite = quantite;
	}
	
	public int getQuantiteSucre() {
		return quantiteSucre;
	}
	public void setQuantiteSucre(int quantiteSucre) {
		this.quantiteSucre = quantiteSucre;
	}
	public int getQuantiteFarine() {
		return quantiteFarine;
	}
	public void setQuantiteFarine(int quantiteFarine) {
		this.quantiteFarine = quantiteFarine;
	}
	public int getQuantiteOeil() {
		return quantiteOeil;
	}
	public void setQuantiteOeil(int quantiteOeil) {
		this.quantiteOeil = quantiteOeil;
	}
	public Stock(String reference, int quantite, int quantiteSucre, int quantiteFarine, int quantiteOeil) {
		super();
		this.reference = reference;
		this.quantite = quantite;
		this.quantiteSucre = quantiteSucre;
		this.quantiteFarine = quantiteFarine;
		this.quantiteOeil = quantiteOeil;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public List<Affectation> getAffectations() {
		return affectations;
	}
	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}
	
	
}
