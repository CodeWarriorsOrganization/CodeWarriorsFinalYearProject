package com.codewarriors.models;

import java.util.List;

import com.codewarriors.entities.Company;

public class Market {

	private int noTurns;
	private int turnTime;	
	private List<Company> companies;
	public int getNoTurns() {
		return noTurns;
	}
	public void setNoTurns(int noTurns) {
		this.noTurns = noTurns;
	}
	public int getTurnTime() {
		return turnTime;
	}
	public void setTurnTime(int turnTime) {
		this.turnTime = turnTime;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	
	
}
