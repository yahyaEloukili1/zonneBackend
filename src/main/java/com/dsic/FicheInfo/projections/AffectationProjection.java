package com.dsic.FicheInfo.projections;

import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.data.rest.core.config.Projection;

import com.dsic.FicheInfo.entities.Affectation;
import com.dsic.FicheInfo.entities.Categorie;
import com.dsic.FicheInfo.entities.Service;
import com.dsic.FicheInfo.entities.Type;


	@Projection(name = "inlineAffectation", types = { Affectation.class })
	public interface AffectationProjection {
	 
			  Service getService();  
			  Categorie getcategorie();
			  Type getType2();
			  String getNumero();
				 String getSigne();
				 int getFarine();
				 int getSucr();
				 int getOeil();
				 String getType();
				 String getCin();
				 String getNom();
				 String getPrenom();
				 String getTele();
			
				 String getNum();
				 String getFicheName();
				 Boolean getMoahal();
				 Boolean getMokarar();  
				 String getAddress();
			
	}


