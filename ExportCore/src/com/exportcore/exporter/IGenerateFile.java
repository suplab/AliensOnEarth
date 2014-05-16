package com.exportcore.exporter;

import java.util.Map;

public interface IGenerateFile {
	
	public void exportToFile(Map<String, String> data, String format, String fileName);

}
