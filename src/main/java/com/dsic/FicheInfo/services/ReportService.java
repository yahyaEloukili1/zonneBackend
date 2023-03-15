package com.dsic.FicheInfo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dsic.FicheInfo.dao.AffectationRepository;
import com.dsic.FicheInfo.entities.Affectation;

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
	private AffectationRepository ficheRepository;
	@Autowired
	private ResourceLoader resourceLoader;

	public void exportReport(String reportFormat, String fileInput, HttpServletResponse response) throws JRException, IOException {
	    List<Affectation> projects = ficheRepository.findAll();

	    // Compile the JasperReport
	    JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

	    // Set up the data source and report parameters
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projects);
	    Map<String, Object> params = new HashMap<>();
	    params.put("CreatedBy", "Java techi");

	    // Fill the report and write it to the response output stream
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
	    response.setContentType("application/" + reportFormat);
	    response.setHeader("Content-Disposition", "attachment; filename=\"report." + reportFormat + "\"");
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}

	public String exportOneReport(String reportFormat,String fileInput,String fileOutput,int id) throws JRException, IOException {
	List<Affectation> fiches = new ArrayList<Affectation>();
	Affectation  fiche =  ficheRepository.findById(id).get();
		fiches.add(fiche);
		String path = "C:\\report";
	//"C:\\allProjects.jrxml")
		JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

		JRBeanCollectionDataSource dataSource = new   JRBeanCollectionDataSource(fiches);
		Map<String, Object> map = new HashMap<>();
		map.put("CreatdBy", "Java techi");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
	
		 if(reportFormat.equalsIgnoreCase("pdf")){
			// "\\allProjects.pdf"
			JasperExportManager.exportReportToPdfFile(jasperPrint,path+fileOutput);
		
		}
		return "";
	}


}
