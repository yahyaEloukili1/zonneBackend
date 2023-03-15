package com.dsic.FicheInfo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dsic.FicheInfo.entities.Affectation;
import com.dsic.FicheInfo.projections.AffectationProjection;


@CrossOrigin(origins = "*")
@RepositoryRestResource(excerptProjection = AffectationProjection.class)
public interface AffectationRepository extends JpaRepository<Affectation, Integer> {

	@RestResource(path= "/byNumero")
	public List<Affectation> findByCinContainsIgnoreCase(@Param("mc") String pr);
	
	@RestResource(path= "/byNumeroPage")
	public Page<Affectation> findByCinContainsIgnoreCase(@Param("mc") String pr,Pageable peaPageable);
	
	List<Affectation> findByCategorieId(Integer id);
	List<Affectation> findByCategorieIdAndType2Id(Integer id,Integer id2);
	List<Affectation> findByCategorieIdAndType2IdAndStockId(Integer id,Integer id2,Integer id3);
	List<Affectation> findByStockIdAndType2Id(Integer id,Integer id2);
	public List<Affectation> findByCinContainsIgnoreCaseAndType2Id(@Param("mc") String pr,Integer id);
	List<Affectation> findByType2Id(Integer id);

}
