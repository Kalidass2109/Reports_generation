package com.nirallan.reports;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nirallan.response.SearchResponse;

public class ExcelGenerator {

	public void generateExcel(List<SearchResponse> response,HttpServletResponse httpResponse) throws IOException {
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("EligData");
		
		HSSFRow headerRow=sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("S.No");
		headerRow.createCell(0).setCellValue("Holder Name");
		headerRow.createCell(0).setCellValue("Email");
		headerRow.createCell(0).setCellValue("Holder SSN");
		headerRow.createCell(0).setCellValue("Plan Name");
		headerRow.createCell(0).setCellValue("Plan Status");
		headerRow.createCell(0).setCellValue("Start Date");
		headerRow.createCell(0).setCellValue("End Date");
		headerRow.createCell(0).setCellValue("Benfit Amount");
		headerRow.createCell(0).setCellValue("Deniel Reason");
		
		for(int i=0;i<response.size();i++) {
			HSSFRow dataRow=sheet.createRow(i+1);
			SearchResponse record=response.get(i);
			
			dataRow.createCell(0).setCellValue(i+1);
			if(record.getHolderName()!=null)
				dataRow.createCell(1).setCellValue(record.getHolderName());
			if(record.getEmail()!=null)
				dataRow.createCell(1).setCellValue(record.getEmail());
			if(record.getHolderSsn()!=null)
				dataRow.createCell(2).setCellValue(record.getHolderSsn());
			if(record.getPlanName()!=null)
				dataRow.createCell(3).setCellValue(record.getPlanName());
			if(record.getPlanStatus()!=null)
				dataRow.createCell(4).setCellValue(record.getPlanStatus());
			if(record.getStartDate()!=null)
				dataRow.createCell(5).setCellValue(String.valueOf(record.getStartDate()));
			if(record.getEndDate()!=null)
				dataRow.createCell(6).setCellValue(String.valueOf(record.getEndDate()));
			if(record.getBenfitAmt()!=null)
				dataRow.createCell(7).setCellValue(record.getBenfitAmt());
			if(record.getDenialreason()!=null)
				dataRow.createCell(8).setCellValue(record.getDenialreason());
		}
		
		workbook.write(httpResponse.getOutputStream());
		workbook.close();
	}
}
