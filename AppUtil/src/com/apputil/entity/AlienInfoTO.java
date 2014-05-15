package com.apputil.entity;

/*
 * Class: AlienInfoTO
 * This class is the Alien Information Entity.
 */

public class AlienInfoTO {
	
	String codeName;
	String bloodColor;
	Integer noOfAntennas;
	Integer noOfLegs;
	String homePlanet;
	String exportFormat;
	
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public Integer getNoOfAntennas() {
		return noOfAntennas;
	}
	public void setNoOfAntennas(Integer noOfAntennas) {
		this.noOfAntennas = noOfAntennas;
	}
	public Integer getNoOfLegs() {
		return noOfLegs;
	}
	public void setNoOfLegs(Integer noOfLegs) {
		this.noOfLegs = noOfLegs;
	}
	public String getHomePlanet() {
		return homePlanet;
	}
	public void setHomePlanet(String homePlanet) {
		this.homePlanet = homePlanet;
	}
	public String getBloodColor() {
		return bloodColor;
	}
	public void setBloodColor(String bloodColor) {
		this.bloodColor = bloodColor;
	}
	public String getExportFormat() {
		return exportFormat;
	}
	public void setExportFormat(String exportFormat) {
		this.exportFormat = exportFormat;
	}
}
