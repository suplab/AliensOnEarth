package com.exportcore.exporter.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.exportcore.constants.ExportConstants;
import com.exportcore.exporter.IGenerateFile;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/*
 * Class: GeneratePDF
 * This class generates .pdf file from an input
 */
public class GeneratePDF implements IGenerateFile {

	@Override
	public void exportToFile(Map<String, String> data, String format,
			String fileName) {
		
		String completeFileName = new SimpleDateFormat("'"+fileName +"'yyyy-MM-dd hh-mm-ss'."+format+"'").format(new Date());

		String filePath = ExportConstants.EXPORT_PATH+completeFileName;

		try {
			OutputStream file = new FileOutputStream(new File(filePath));

			Document document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();
			document.add(new Paragraph("Details"));
			document.add(new Paragraph("==========================================="));
			for(Map.Entry<String, String> entry : data.entrySet()){
				
				document.add(new Paragraph(entry.getKey()+" "+entry.getValue()));
			}
			
			

			document.close();
			file.close();

			System.out.println("File Generated Successfully at location: " + filePath);

		} catch (Exception e) {

			System.out.println("Problem writing to the file. " + e);
		} 
		
	}

	

}
