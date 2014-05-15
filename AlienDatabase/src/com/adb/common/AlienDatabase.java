package com.adb.common;

import java.util.Scanner;

import com.apputil.entity.AlienInfoTO;
import com.exportcore.util.ExportInformationUtility;
import com.exportcore.validation.ExportFormatValidator;


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
		if(alienInfo.getExportFormat()!=null){
			
			if(validateExportFormat(alienInfo)){
				/*Now to export the results*/
				exportAlienInformation(alienInfo);

			}else{
				System.out.println("Unknown export format provided");
			}
		}else{
			System.out.println("Unknown export format provided");
		}
		
	}

	private static void exportAlienInformation(AlienInfoTO alienInfo) {
		
		ExportInformationUtility exportUtility = new ExportInformationUtility();
		exportUtility.exportInformation(alienInfo);
	}

	private static boolean validateExportFormat(AlienInfoTO alienInfo) {
		
		ExportFormatValidator exportValidator = new ExportFormatValidator();
		return exportValidator.validate(alienInfo.getExportFormat());
		
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

}
