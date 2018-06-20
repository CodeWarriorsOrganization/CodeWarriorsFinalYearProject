package com.codewarriors.models;

public class PlayerProfile {
	
	
	String profileName;
	int noOfTrades;
	double pBalance;
	double netWorth;
	double totalReturns;
	int stockOwns;
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public int getNoOfTrades() {
		return noOfTrades;
	}
	public void setNoOfTrades(int noOfTrades) {
		this.noOfTrades = noOfTrades;
	}
	public double getpBalance() {
		return pBalance;
	}
	public void setpBalance(double pBalance) {
		this.pBalance = pBalance;
	}
	public double getNetWorth() {
		return netWorth;
	}
	public void setNetWorth(double netWorth) {
		this.netWorth = netWorth;
	}
	public double getTotalReturns() {
		return totalReturns;
	}
	public void setTotalReturns(double totalReturns) {
		this.totalReturns = totalReturns;
	}
	public int getStockOwns() {
		return stockOwns;
	}
	public void setStockOwns(int stockOwns) {
		this.stockOwns = stockOwns;
	}
	public PlayerProfile(String profileName, int noOfTrades, double pBalance, double netWorth, double totalReturns,
			int stockOwns) {
	
		this.profileName = profileName;
		this.noOfTrades = noOfTrades;
		this.pBalance = pBalance;
		this.netWorth = netWorth;
		this.totalReturns = totalReturns;
		this.stockOwns = stockOwns;
	}
	public PlayerProfile() {
		
	}
	
	

}
