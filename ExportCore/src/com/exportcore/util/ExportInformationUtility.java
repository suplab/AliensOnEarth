package com.exportcore.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.apputil.entity.AlienInfoTO;
import com.exportcore.constants.ExportConstants;
import com.exportcore.validation.ExportFormatValidator;

/*
 * Class: ExportInformationUtility
 * Provides the export functionality.
 */
public class ExportInformationUtility {


	public void exportInformation(Map<String , String> data, String format, String fileName){

		/*if(!validateExportFormat(alienInfo)){

			System.out.println("Unknown export format provided");

			return;
		}*/

		/*if(alienInfo.getExportFormat().equalsIgnoreCase(ExportConstants.EXPORTFORMATS.PDF.toString())){

			exportInformationAsPDF(alienInfo);

		}

		if(alienInfo.getExportFormat().equalsIgnoreCase(ExportConstants.EXPORTFORMATS.TXT.toString())){

			exportInformationAsTXT(alienInfo);
		}*/

		/* 
		 * Ouput for New formats such as foobar needs to be handled here as done for PDF and Text
		 */

		try{
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();

			/*
			 * Defining the class that needs to be loaded.
			 * Each export format is a file having name Generate<EXPORT_TYPE>.java
			 */
			String classToBeLoaded = ExportConstants.EXPORTER_CLASS_PATH+ExportConstants.CLASS_PREFIX+format.toUpperCase();

			//Load the class
			Class<?> requiredClass = classLoader.loadClass(classToBeLoaded);

			//Create instance of the class
			Object instance = requiredClass.newInstance();


			//Get method with proper signature
			Method exportToFile = requiredClass.getMethod("exportToFile",
					new Class[] {  Map.class, String.class, String.class });

			//Calling the method
			exportToFile.invoke(instance,
					new Object[] { data, format.toLowerCase(), fileName });

		}catch (ClassNotFoundException e) {
			
			System.out.println("Unknown export format provided.");
			
		} catch (Exception e) {
			
			System.out.println("Error encountered!! Terminating..."+ e);
		}


	}




}
