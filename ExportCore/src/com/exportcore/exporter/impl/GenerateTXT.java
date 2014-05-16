package com.exportcore.exporter.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.exportcore.constants.ExportConstants;
import com.exportcore.exporter.IGenerateFile;
import com.itextpdf.text.Paragraph;

public class GenerateTXT implements IGenerateFile {

	@Override
	public void exportToFile(Map<String, String> data, String format,
			String fileName) {

		String completeFileName = new SimpleDateFormat("'"+fileName +"'yyyy-MM-dd hh-mm-ss'."+format+"'").format(new Date());

		String filePath = ExportConstants.EXPORT_PATH+completeFileName;

		BufferedWriter bufferedWriter = null;        
		try {            
			//Construct the BufferedWriter object
			bufferedWriter = new BufferedWriter(new FileWriter(filePath));            
			//Start writing to the output stream
			bufferedWriter.append("Alien Details");
			bufferedWriter.newLine();
			bufferedWriter.append("===========================================");
			
			for(Map.Entry<String, String> entry : data.entrySet()){
				
				bufferedWriter.newLine();
				bufferedWriter.append(entry.getKey()+" "+entry.getValue());
			}
			
			/*bufferedWriter.newLine();
			bufferedWriter.append("Code Name: ").append(alienInfo.getCodeName());
			bufferedWriter.newLine();
			bufferedWriter.append("Blood Color: ").append(alienInfo.getBloodColor());
			bufferedWriter.newLine();
			bufferedWriter.append("No. of Antennas: ").append(alienInfo.getNoOfAntennas().toString());
			bufferedWriter.newLine();
			bufferedWriter.append("No. of Legs: ").append(alienInfo.getNoOfLegs().toString());
			bufferedWriter.newLine();
			bufferedWriter.append("Home Planet: ").append(alienInfo.getHomePlanet());*/

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
