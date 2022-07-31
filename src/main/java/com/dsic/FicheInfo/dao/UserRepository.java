package com.dsic.FicheInfo.dao;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dsic.FicheInfo.entities.AppUser;


@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<AppUser, Integer> {

	public AppUser findByUsername(String username);
}
