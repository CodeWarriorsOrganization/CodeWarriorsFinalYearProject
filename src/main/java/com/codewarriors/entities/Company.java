package com.codewarriors.entities;

public class Company {
	String companyName;
	String sectorName;
	String details;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Company(String companyName, String sectorName, String details) {

		this.companyName = companyName;
		this.sectorName = sectorName;
		this.details = details;
	}

	public Company() {

	}

}
