package com.codewarriors.models;

import java.util.List;

public class Company {
	String companyName;
	String sectorName;
	String details;
	private int buyQuantity;
	private int sellQuantity;
	public int getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	public int getSellQuantity() {
		return sellQuantity;
	}

	public void setSellQuantity(int sellQuantity) {
		this.sellQuantity = sellQuantity;
	}

	double companypriceCangingPercentage;
	public double getCompanypriceCangingPercentage() {
		return companypriceCangingPercentage;
	}

	public void setCompanypriceCangingPercentage(double companypriceCangingPercentage) {
		this.companypriceCangingPercentage = companypriceCangingPercentage;
	}

	private List<Turn> turns;

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

	public List<Turn> getTurns() {
		return turns;
	}

	public void setTurns(List<Turn> turns) {
		this.turns = turns;
	}

}
