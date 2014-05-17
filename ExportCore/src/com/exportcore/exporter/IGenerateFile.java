package com.exportcore.exporter;

import java.util.Map;


/*
 * Interface: IGenerateFile
 * Abstraction of all GenerateFile formats
 */

public interface IGenerateFile {
	
	//Generalised method common to all export types
	public void exportToFile(Map<String, String> data, String format, String fileName);

}
