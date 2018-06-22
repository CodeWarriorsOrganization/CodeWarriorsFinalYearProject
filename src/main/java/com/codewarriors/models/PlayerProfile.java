package com.codewarriors.models;

public class PlayerProfile {
	
	
	String profileName;
	int rank;
	int noOfTrades;
	double pBalance;
	double totalReturns;
	
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
		public double getTotalReturns() {
		return totalReturns;
	}
	public void setTotalReturns(double totalReturns) {
		this.totalReturns = totalReturns;
	}
		
	public PlayerProfile(String profileName, int rank, int noOfTrades, double pBalance, double totalReturns) {
		
		this.profileName = profileName;
		this.rank = rank;
		this.noOfTrades = noOfTrades;
		this.pBalance = pBalance;
		this.totalReturns = totalReturns;
		
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public PlayerProfile() {
		
	}
	
	

}
