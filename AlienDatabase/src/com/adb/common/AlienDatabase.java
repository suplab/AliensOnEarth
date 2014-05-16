package com.adb.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.apputil.entity.AlienInfoTO;
import com.exportcore.util.ExportInformationUtility;


/*
 * Class: AlienDatabase
 * This class accepts Alien Information and provides an export functionality
 */
public class AlienDatabase {

	public static void main(String[] args) {

		System.out.println("=========Welcome to Alien Database Utility=========");

		AlienInfoTO alienInfo = new AlienInfoTO();

		/* Get details from the console */
		readAlienInformation(alienInfo);


		/*Validate the export format*/
		if(alienInfo.getExportFormat()!=null && !alienInfo.getExportFormat().isEmpty()){

			/*Now to export the results*/
			exportAlienInformation(alienInfo);

		}else{
			System.out.println("Export format not provided!!");
		}

	}

	private static void exportAlienInformation(AlienInfoTO alienInfo) {

		System.out.println("Exporting Alien Data------------->");
		
		//Get a generic datastructure for exporting
		Map<String, String> data = generateDataToExport(alienInfo);
		
		//Export the details
		ExportInformationUtility exportUtility = new ExportInformationUtility();
		exportUtility.exportInformation(data, alienInfo.getExportFormat(), "AlienInformation");
	}



	private static void readAlienInformation(AlienInfoTO alienInfo) {

		Scanner scanIn = new Scanner(System.in);

		try{

			System.out.println("Enter Record for New Alien---->");

			System.out.print("Enter Code Name: ");
			alienInfo.setCodeName(scanIn.nextLine());

			System.out.print("Enter Blood Color: ");
			alienInfo.setBloodColor(scanIn.nextLine());

			System.out.print("Enter No. of Antennas: ");
			alienInfo.setNoOfAntennas(scanIn.nextInt());

			System.out.print("Enter No. of Legs: ");
			alienInfo.setNoOfLegs(scanIn.nextInt());

			scanIn.nextLine(); // It consumes the \n character
			System.out.print("Enter Home Planet: ");
			alienInfo.setHomePlanet(scanIn.nextLine());

			System.out.print("Enter format to export: ");
			alienInfo.setExportFormat(scanIn.nextLine());

		}catch(Exception e)
		{
			System.out.println("Oops! Looks like there has been an invalid input: " + e);

		}finally{
			scanIn.close();
		}
	}
	
	
	
	private static Map<String, String> generateDataToExport(AlienInfoTO alienInfo){
		
		Map<String, String> data = new HashMap<String, String>();
		
		data.put("Code Name :", alienInfo.getCodeName());
		data.put("Blood Color :", alienInfo.getBloodColor());
		data.put("No. of Antennas :", alienInfo.getNoOfAntennas().toString());
		data.put("No. of Legs :", alienInfo.getNoOfLegs().toString());
		data.put("Home Planet :", alienInfo.getHomePlanet());
		
		return data;
		
	}

}
