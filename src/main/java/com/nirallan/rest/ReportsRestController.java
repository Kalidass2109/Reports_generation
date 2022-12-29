package com.nirallan.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.nirallan.reports.ExcelGenerator;
import com.nirallan.reports.PdfGenerator;
import com.nirallan.request.SearchRequest;
import com.nirallan.response.SearchResponse;
import com.nirallan.service.ReportsService;

@RestController
public class ReportsRestController {
	
	@Autowired
	private ReportsService service;
	
	@GetMapping("/plan-names")
	public List<String> getPlans(){
		return service.getplanNames();
	}
	
	@GetMapping("/plan-status")
	public List<String> getStatus(){
		return service.getPlanStatus();
	}
	
	@PostMapping("/search")
	public List<SearchResponse> search(@RequestBody SearchRequest request){
		return service.getSearchPlans(request);
	}
	
	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey="Content-Disposition";
		String headerValue="attachment; filename=Plans.xls";
		response.setHeader(headerKey, headerValue);
		
		List<SearchResponse> records=service.getSearchPlans(null);
		ExcelGenerator excel=new ExcelGenerator();
		excel.generateExcel(records, response);
	}
	
	@PostMapping("/pdf")
	public void generatePdf(@RequestBody SearchRequest request,HttpServletResponse httpResponse) throws DocumentException, IOException {
		httpResponse.setContentType("application/pdf");
		String headerKey="Content-Disposition";
		String headerValue="attachment; filename=Plan.pdf";
		httpResponse.setHeader(headerKey, headerValue);
		
		List<SearchResponse> records=service.getSearchPlans(request);
		System.out.println(records);
		PdfGenerator pdfGen=new PdfGenerator();
		pdfGen.generatePdf(records, httpResponse);
	}

}
