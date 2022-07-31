package com.dsic.FicheInfo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dsic.FicheInfo.dao.AffectationRepository;
import com.dsic.FicheInfo.entities.Affectation;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	private AffectationRepository affectationRepository;
	@Autowired
	private ResourceLoader resourceLoader;
//	public String exportReport(String reportFormat,String fileInput,String fileOutput) throws JRException, IOException {
//		//Sort.by(Sort.Direction.DESC, "province"
//		List<Fiche> projets = ficheRepository.findAll();
//		String path = "C:\\report";
//		//File file =ResourceUtils.getFile("claasspath:projets.jrxml");
//	
//		final org.springframework.core.io.Resource fileResource = resourceLoader.getResource("classpath:allProjects.jrxml");
//		File file = fileResource.getFile();
//		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//
//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projets);
//		Map<String, Object> map = new HashMap<>();
//		map.put("CreatdBy", "Java techi");
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
//		
//		 if(reportFormat.equalsIgnoreCase("pdf")){
//			
//			JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\projets4.pdf");
//		}
//		return "";
//	}
	public String exportReport(String reportFormat,String fileInput,String fileOutput) throws JRException, IOException {
		List<Affectation> projets = affectationRepository.findAll();
		String path = "C:\\report";
	//"C:\\allProjects.jrxml")
		JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projets);
		Map<String, Object> map = new HashMap<>();
		map.put("CreatdBy", "Java techi");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		
		 if(reportFormat.equalsIgnoreCase("pdf")){
			// "\\allProjects.pdf"
			JasperExportManager.exportReportToPdfFile(jasperPrint,path+fileOutput);
		}
		return "";
	}
	public String exportOneReport(String reportFormat,String fileInput,String fileOutput,int id) throws JRException, IOException {
	List<Affectation> fiches = new ArrayList<Affectation>();
		Affectation  fiche =  affectationRepository.findById(id).get();
		fiches.add(fiche);
		String path = "C:\\report";
		//String path = System.getProperty("user.home")+"/Downloads";
		String fileOutput1 = System.getProperty("user.home")+"\\Downloads\\"+fileOutput;
		System.out.println(fileOutput1);
	//"C:\\allProjects.jrxml")
		JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

		JRBeanCollectionDataSource dataSource = new   JRBeanCollectionDataSource(fiches);
		Map<String, Object> map = new HashMap<>();
		map.put("CreatdBy", "Java techi");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
	
		 if(reportFormat.equalsIgnoreCase("pdf")){
			// "\\allProjects.pdf"
			 FileOutputStream  outputStream = new FileOutputStream(new File(fileOutput1));
			JasperExportManager.exportReportToPdfFile(jasperPrint,path+fileOutput);
			//JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		
		}
		return "";
	}


}
