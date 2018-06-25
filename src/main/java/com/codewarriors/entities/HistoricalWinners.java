package com.codewarriors.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "winners")
public class HistoricalWinners {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roundNo;
	
	String winnerName;
	int noOfTrades;
	double netWorth;
	public HistoricalWinners(String winnerName, int noOfTrades, double netWorth, double totalReturns) {
		
		this.winnerName = winnerName;
		this.noOfTrades = noOfTrades;
		this.netWorth = netWorth;
		this.totalReturns = totalReturns;
	}
	public HistoricalWinners() {
		
	}
	public int getRoundNo() {
		return roundNo;
	}
	public void setRoundNo(int roundNo) {
		this.roundNo = roundNo;
	}
	public String getWinnerName() {
		return winnerName;
	}
	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}
	public int getNoOfTrades() {
		return noOfTrades;
	}
	public void setNoOfTrades(int noOfTrades) {
		this.noOfTrades = noOfTrades;
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
	double totalReturns;
	
	

}
