package com.exportcore.validation;

import com.exportcore.constants.ExportConstants.EXPORTFORMATS;

/*
 * Class: ExportFormatValidator
 * Validates the requested export format with those currently available.
 */
public class ExportFormatValidator {
	
	public boolean validate(String format){
		if(format.equalsIgnoreCase(EXPORTFORMATS.PDF.toString())
				|| format.equalsIgnoreCase(EXPORTFORMATS.TXT.toString()))
			return true;
		else
			return false;
	}

}
