package com.dsic.FicheInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dsic.FicheInfo.dao.RoleRepository;
import com.dsic.FicheInfo.entities.Affectation;
import com.dsic.FicheInfo.entities.AppRole;
import com.dsic.FicheInfo.entities.AppUser;
import com.dsic.FicheInfo.services.AccountService;



@SpringBootApplication
public class ZonneApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	@Lazy
	private AccountService accountService;
	@Autowired
	private RoleRepository roleRepository;
	@Bean
	public BCryptPasswordEncoder getBPE() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(ZonneApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Affectation.class);
		// TODO Auto-generated method stub
		if(accountService.finduserByUsrname("adminPdi")==null) {
			accountService.save(new AppUser(null,"adminPdi","Laayoune2022@",null,null));
			accountService.saveRole(new AppRole(null,"ADMIN"));
			accountService.saveRole(new AppRole(null,"USER"));
			accountService.addRoleToUser("adminPdi","ADMIN");
			accountService.addRoleToUser("adminPdi","USER");
		}
		
		
	}

}
