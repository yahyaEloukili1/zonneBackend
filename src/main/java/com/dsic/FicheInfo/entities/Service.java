package com.dsic.FicheInfo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String nameAr;
	@OneToMany(mappedBy = "service")
	private List<Affectation> affectations;
	public Service(String name, List<Affectation> affectations) {
		super();
		this.name = name;
		this.affectations = affectations;
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
	
	public String getNameAr() {
		return nameAr;
	}
	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
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
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
