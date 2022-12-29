package com.nirallan.reports;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nirallan.response.SearchResponse;


public class PdfGenerator {
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		
		Font font=FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("SSN", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan Status", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("StartDate", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("End Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("BenfitAmount", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Deniel Reason", font));
		table.addCell(cell);
	}
	
	public void generatePdf(List<SearchResponse> records,HttpServletResponse response) throws DocumentException, IOException {
		Document document=new Document();
		
		PdfWriter writer=PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
//	    Font font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC, Color.RED);
//	    Paragraph para = new Paragraph("Eligibility Details", font);
//	    document.add(para);
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(Color.WHITE);
		cell.setPadding(5);
		
		PdfPCell cell1=new PdfPCell();
		cell.setBackgroundColor(Color.BLACK);
		cell.setPadding(5);
		
//      PdfPCell cell2 = new PdfPCell();
//      cell2.setBackgroundColor(Color.RED);
//      cell2.setPadding(5);
		
		Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(15);
		font.setColor(Color.BLUE);
		
		Paragraph p=new Paragraph("Nirallan User",font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);
		
		PdfPTable table=new PdfPTable(9);
		
//	    table.addCell("S.No");
//	    table.addCell("Holder Name");
//	    table.addCell("Holder SSN");
//	    table.addCell("Plan Name");
//	    table.addCell("Plan Status");
//	    table.addCell("Start Date");
//	    table.addCell("End Date");
//	    table.addCell("Benefit Amount");
//	    table.addCell("Denial Reason");
	    
	   // PdfPTable table = new PdfPTable(5);
		
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f,3.0f});
		table.setSpacingBefore(10);
		writeTableHeader(table);
		
		Font font1=FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(Color.GREEN);
		
		Font font2=FontFactory.getFont(FontFactory.HELVETICA);
		font2.setColor(Color.RED);
		
		Font font3=FontFactory.getFont(FontFactory.HELVETICA);
		font3.setSize(10);
		font3.setColor(Color.GREEN);
		
		Font font4=FontFactory.getFont(FontFactory.HELVETICA);
		font4.setSize(10);
		font4.setColor(Color.RED);
		
		for(SearchResponse record:records) {
			if(record.getEligId()%2==0) {
				cell1.setPhrase(new Phrase(String.valueOf(record.getEligId()),font1));
				table.addCell(cell1);
				
				cell1.setPhrase(new Phrase(String.valueOf(record.getHolderName()),font3));
				table.addCell(cell1);
				
				cell1.setPhrase(new Phrase(String.valueOf(record.getHolderSsn()),font3));
				table.addCell(cell1);
				
				cell1.setPhrase(new Phrase(String.valueOf(record.getPlanName()),font3));
				table.addCell(cell1);
				
				cell1.setPhrase(new Phrase(String.valueOf(record.getPlanStatus()),font3));
				table.addCell(cell1);
				
				if(record.getStartDate()!=null) {
					cell1.setPhrase(new Phrase(String.valueOf(record.getStartDate()),font3));
					table.addCell(cell1);
				}else {
					cell1.setPhrase(new Phrase("",font3));
					table.addCell(cell1);
				}
				
				if(record.getEndDate()!=null) {
					cell1.setPhrase(new Phrase(String.valueOf(record.getEndDate()),font3));
					table.addCell(cell1);
				}else {
					cell1.setPhrase(new Phrase("",font3));
					table.addCell(cell1);
				}
				
				if(record.getBenfitAmt()!=null) {
					cell1.setPhrase(new Phrase(String.valueOf(record.getBenfitAmt()),font3));
					table.addCell(cell1);
				}else {
					cell1.setPhrase(new Phrase("",font3));
					table.addCell(cell1);
				}
				
				if(record.getDenialreason()!=null) {
					cell1.setPhrase(new Phrase(String.valueOf(record.getDenialreason()),font3));
					table.addCell(cell1);
				}else {
					cell1.setPhrase(new Phrase("",font3));
					table.addCell(cell1);
				}
			}else {
				cell.setPhrase(new Phrase(String.valueOf(record.getEligId()),font2));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase(String.valueOf(record.getHolderName()),font4));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase(String.valueOf(record.getHolderSsn()),font4));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase(String.valueOf(record.getPlanName()),font4));
				table.addCell(cell);
				
				cell.setPhrase(new Phrase(String.valueOf(record.getPlanStatus()),font4));
				table.addCell(cell);
				
				if(record.getStartDate()!=null) {
					cell.setPhrase(new Phrase(String.valueOf(record.getStartDate()),font4));
					table.addCell(cell);
				}else {
					cell.setPhrase(new Phrase("",font4));
					table.addCell(cell);
				}
				
				if(record.getEndDate()!=null) {
					cell.setPhrase(new Phrase(String.valueOf(record.getEndDate()),font4));
					table.addCell(cell);
				}else {
					cell.setPhrase(new Phrase("",font4));
					table.addCell(cell);
				}
				
				if(record.getBenfitAmt()!=null) {
					cell.setPhrase(new Phrase(String.valueOf(record.getBenfitAmt()),font4));
					table.addCell(cell);
				}else {
					cell.setPhrase(new Phrase("",font4));
					table.addCell(cell);
				}
				
				if(record.getDenialreason()!=null) {
					cell.setPhrase(new Phrase(String.valueOf(record.getDenialreason()),font4));
					table.addCell(cell);
				}else {
					cell.setPhrase(new Phrase("",font4));
					table.addCell(cell);
				}
			}
		}
		document.add(table);
		document.close();
		writer.close();
	}

}
