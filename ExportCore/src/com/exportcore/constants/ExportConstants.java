package com.exportcore.constants;

/*
 * Class: ExportConstants
 * This class holds the constants needed by the Export Module
 */
public class ExportConstants {


	public static final String EXPORT_PATH = "C:\\";
	
	public static final String EXPORTER_CLASS_PATH = "com.exportcore.exporter.impl.";
	
	public static final String CLASS_PREFIX = "Generate";
	
	public enum EXPORTFORMATS{
		
		/*Holds the type of formats available*/

		TXT{
			public String toString() {
				return "txt";
			}
		},

		PDF{
			public String toString() {
				return "pdf";
			}
		};

	}
}
