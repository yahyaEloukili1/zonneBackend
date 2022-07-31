package com.dsic.FicheInfo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dsic.FicheInfo.entities.Affectation;

@CrossOrigin(origins = "*")
public interface AffectationRepository extends JpaRepository<Affectation, Integer> {

	@RestResource(path= "/byNumero")
	public List<Affectation> findByCinContainsIgnoreCase(@Param("mc") String pr);
	
	@RestResource(path= "/byNumeroPage")
	public Page<Affectation> findByCinContainsIgnoreCase(@Param("mc") String pr,Pageable peaPageable);

}
