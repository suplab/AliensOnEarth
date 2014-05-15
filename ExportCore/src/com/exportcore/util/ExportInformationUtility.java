package com.exportcore.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.apputil.entity.AlienInfoTO;
import com.exportcore.constants.ExportConstants;
import com.exportcore.validation.ExportFormatValidator;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/*
 * Class: ExportInformationUtility
 * Provides the export functionality.
 */
public class ExportInformationUtility {


	public void exportInformation(AlienInfoTO alienInfo){

		if(!validateExportFormat(alienInfo)){

			System.out.println("Unknown export format provided");

			return;
		}

		if(alienInfo.getExportFormat().equalsIgnoreCase(ExportConstants.EXPORTFORMATS.PDF.toString())){

			exportInformationAsPDF(alienInfo);

		}

		if(alienInfo.getExportFormat().equalsIgnoreCase(ExportConstants.EXPORTFORMATS.TXT.toString())){

			exportInformationAsTXT(alienInfo);
		}

		/* 
		 * Ouput for New formats such as foobar needs to be handled here as done for PDF and Text
		 */
	}



	private boolean validateExportFormat(AlienInfoTO alienInfo) {

		ExportFormatValidator exportValidator = new ExportFormatValidator();
		return exportValidator.validate(alienInfo.getExportFormat());

	}

	private void exportInformationAsPDF(AlienInfoTO alienInfo) {

		String fileName = new SimpleDateFormat("'AlienInformation'yyyy-MM-dd hh-mm-ss'.pdf'").format(new Date());

		String filePath = ExportConstants.EXPORT_PATH+fileName;

		try {
			OutputStream file = new FileOutputStream(new File(filePath));

			Document document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();
			document.add(new Paragraph("Alien Details"));
			document.add(new Paragraph("==========================================="));
			document.add(new Paragraph("Code Name: " + alienInfo.getCodeName()));
			document.add(new Paragraph("Blood Color: " + alienInfo.getBloodColor()));
			document.add(new Paragraph("No. of Antennas: " + alienInfo.getNoOfAntennas().toString()));
			document.add(new Paragraph("No. of Legs: " + alienInfo.getNoOfLegs().toString()));
			document.add(new Paragraph("Home Planet: " + alienInfo.getHomePlanet()));

			document.close();
			file.close();

			System.out.println("File Generated Successfully at location: " + filePath);

		} catch (Exception e) {

			System.out.println("Problem writing to the file. " + e);
		} 
	}

	private void exportInformationAsTXT(AlienInfoTO alienInfo) {

		String fileName = new SimpleDateFormat("'AlienInformation'yyyy-MM-dd hh-mm-ss'.txt'").format(new Date());

		String filePath = ExportConstants.EXPORT_PATH+fileName;

		BufferedWriter bufferedWriter = null;        
		try {            
			//Construct the BufferedWriter object
			bufferedWriter = new BufferedWriter(new FileWriter(filePath));            
			//Start writing to the output stream
			bufferedWriter.append("Alien Details");
			bufferedWriter.newLine();
			bufferedWriter.append("===========================================");
			bufferedWriter.newLine();
			bufferedWriter.append("Code Name: ").append(alienInfo.getCodeName());
			bufferedWriter.newLine();
			bufferedWriter.append("Blood Color: ").append(alienInfo.getBloodColor());
			bufferedWriter.newLine();
			bufferedWriter.append("No. of Antennas: ").append(alienInfo.getNoOfAntennas().toString());
			bufferedWriter.newLine();
			bufferedWriter.append("No. of Legs: ").append(alienInfo.getNoOfLegs().toString());
			bufferedWriter.newLine();
			bufferedWriter.append("Home Planet: ").append(alienInfo.getHomePlanet());

			System.out.println("File Generated Successfully at location: " + filePath);

		} catch (IOException e) {

			System.out.println("Problem writing to the file. " + e);
		} finally {
			//Close the BufferedWriter
			try {
				if (bufferedWriter != null) {
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
