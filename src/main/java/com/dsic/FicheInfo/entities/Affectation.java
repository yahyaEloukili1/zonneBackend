package com.dsic.FicheInfo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
public class Affectation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String numero;
	private String signe;
	private int farine;
	private int sucr;
	private int oeil;
	private String type;
	private String cin;
	private String nom;
	private String prenom;
	private  String fullName;
	private String tele;
	private String serviceName;
	@Column(unique=true)
	private String num;
	private String ficheName;
	private Boolean moahal;
	private Boolean mokarar; 
	@ManyToOne
	private Service service;
	@ManyToOne
	private Categorie categorie;
	@ManyToOne
	private Stock stock;
	@ManyToOne
	private Type type2;
	private String address;
	public Affectation(int id, String numero, int farine, int sucr, int oeil, String type, String cin, String nom,
			String prenom, String num, String ficheName, Date date,String Tele,String address,String signe,Boolean moahal,Boolean mokarar) {
		super();
		this.id = id;
		this.numero = numero;
		this.farine = farine;
		this.sucr = sucr;
		this.oeil = oeil;
		this.type = type;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.num = num;
		this.ficheName = ficheName;
		this.date = date;
		this.tele= Tele;
		this.address = address;
		this.signe = signe;
		this.moahal = moahal;
		this.mokarar = mokarar;
	}
	
	public String getSigne() {
		return signe;
	}

	public void setSigne(String signe) {
		this.signe = signe;
	}

	public Boolean getMoahal() {
		return moahal;
	}

	public void setMoahal(Boolean moahal) {
		this.moahal = moahal;
	}

	public Boolean getMokarar() {
		return mokarar;
	}

	public void setMokarar(Boolean mokarar) {
		this.mokarar = mokarar;
	}

	public String getAddress() {
		return address;
	}

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Type getType2() {
		return type2;
	}

	public void setType2(Type type2) {
		this.type2 = type2;
	}

	public String getFicheName() {
		return ficheName;
	}
	public void setFicheName(String ficheName) {
		this.ficheName = ficheName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	public Affectation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getFarine() {
		return farine;
	}
	public void setFarine(int farine) {
		this.farine = farine;
	}
	public int getSucr() {
		return sucr;
	}
	public void setSucr(int sucr) {
		this.sucr = sucr;
	}
	public int getOeil() {
		return oeil;
	}
	public void setOeil(int oeil) {
		this.oeil = oeil;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Affectation [id=" + id + ", numero=" + numero + ", farine=" + farine + ", sucr=" + sucr + ", oeil="
				+ oeil + ", type=" + type + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
