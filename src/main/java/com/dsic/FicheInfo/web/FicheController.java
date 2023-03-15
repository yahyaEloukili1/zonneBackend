package com.dsic.FicheInfo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dsic.FicheInfo.dao.AffectationRepository;
import com.dsic.FicheInfo.entities.Affectation;
import com.dsic.FicheInfo.services.ReportService;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin("*")
@RestController
public class FicheController {

	@Autowired
	AffectationRepository ficheRepository;
	@Autowired
	ReportService reportService;
//	@GetMapping("/report/{format}")
//	public String generateReport(@PathVariable String format) throws JRException, IOException  {
//		return reportService.exportReport(format);
//	}
	@GetMapping("/report/{format}")
	public void generateReport(@PathVariable String format, HttpServletResponse response) throws JRException, IOException {
	    reportService.exportReport(format, "C:\\allProjects1.jrxml", response);
	}

	@GetMapping("/report/{format}/{id}")
	public String generateOneReport(@PathVariable String format,@PathVariable("id") int id) throws JRException, IOException  {
		return reportService.exportOneReport(format,"C:\\fiche.jrxml","\\oneFiche.pdf",id);
	}
	
	@GetMapping(path="fiche/{id}",produces=org.springframework.http.MediaType.APPLICATION_PDF_VALUE)
	public byte[] getPhoto(@PathVariable("id") int id) throws IOException {
		//Affectation f = affectationRepository.findById(id).get();
		//return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/"+f.getFicheName()+".pdf"));
	return Files.readAllBytes(Paths.get("C:\\report\\"+"dr"+".pdf"));
	}
	@GetMapping("/getLast")
	public Affectation getLastFiche() {
		List<Affectation> fiches = ficheRepository.findAll();
		int j = 0;
		Affectation fiche = null;
	for(int i=0;i<fiches.size();i++) {
		if(fiches.get(i).getId()>j) {
			j = fiches.get(i).getId();
			fiche = fiches.get(i);
		}
	}
	return fiche;
	}
}