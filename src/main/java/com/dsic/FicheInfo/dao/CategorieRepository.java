package com.dsic.FicheInfo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dsic.FicheInfo.entities.Affectation;
import com.dsic.FicheInfo.entities.Categorie;
import com.dsic.FicheInfo.entities.Service;

import aj.org.objectweb.asm.Type;

@CrossOrigin(origins = "*")
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

	@RestResource(path= "/byName")
	public List<Categorie> findByNameContainsIgnoreCase(@Param("mc") String pr);
	
	@RestResource(path= "/byNamePage")
	public Page<Categorie> findByNameContainsIgnoreCase(@Param("mc") String pr,Pageable peaPageable);

}
