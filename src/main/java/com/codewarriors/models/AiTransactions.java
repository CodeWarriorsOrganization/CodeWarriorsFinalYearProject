package com.codewarriors.models;

import java.util.List;

public class AiTransactions {
	
	private List<Company> buyCompanies;
	public List<Company> getBuyCompanies() {
		return buyCompanies;
	}
	public void setBuyCompanies(List<Company> buyCompanies) {
		this.buyCompanies = buyCompanies;
	}
	public List<Company> getSellCompanies() {
		return sellCompanies;
	}
	public void setSellCompanies(List<Company> sellCompanies) {
		this.sellCompanies = sellCompanies;
	}
	private List<Company> sellCompanies;

	
}
