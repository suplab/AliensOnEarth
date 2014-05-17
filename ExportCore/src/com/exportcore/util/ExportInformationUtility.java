package com.exportcore.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

import com.exportcore.constants.ExportConstants;

/*
 * Class: ExportInformationUtility
 * Provides the export functionality.
 */
public class ExportInformationUtility {


	public void exportInformation(Map<String , String> data, String format, String fileName){

		

		try{
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();

			/*
			 * Defining the class that needs to be loaded.
			 * Each export format is a file having name Generate<EXPORT_TYPE>.java
			 */
			String classToBeLoaded = getClassName(format);
			if(classToBeLoaded == null){
				throw new ClassNotFoundException();
			}

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


	private String getClassName(String format){
		
		Properties prop = new Properties();
		InputStream input = null;
		String className = null;
	 
		try {
	 
			//get resource file as stream
			input = this.getClass().getClassLoader().getResourceAsStream(ExportConstants.CLASS_NAME_MAPPING);
	 
			// load a properties file
			prop.load(input);
			
			// get the property value
			className = prop.getProperty(format.toUpperCase());
	 
		} catch (IOException io) {
			
			System.out.println("Unable to export, since export type is unknown : " + io);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println("Unable to export : " + e);
					
				}
			}
	 
		}
		
		return className;
		
	}


}
