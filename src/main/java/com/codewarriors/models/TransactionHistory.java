package com.codewarriors.models;

public class TransactionHistory {
	
	String companyName;
	double boughtShares;
	double soldShares;
	double lossOrGain;
	int stockInHand;
	int boughtStockQty;
	int sellStockQty;

	public TransactionHistory(String companyName, double boughtShares, double soldShares, double lossOrGain,
			int stockInHand, int boughtStockQty, int sellStockQty) {
	
		this.companyName = companyName;
		this.boughtShares = boughtShares;
		this.soldShares = soldShares;
		this.lossOrGain = lossOrGain;
		this.stockInHand = stockInHand;
		this.boughtStockQty = boughtStockQty;
		this.sellStockQty = sellStockQty;
	}
	public int getBoughtStockQty() {
		return boughtStockQty;
	}
	public void setBoughtStockQty(int boughtStockQty) {
		this.boughtStockQty = boughtStockQty;
	}
	public int getSellStockQty() {
		return sellStockQty;
	}
	public void setSellStockQty(int sellStockQty) {
		this.sellStockQty = sellStockQty;
	}
	public TransactionHistory() {
		
	}
	public TransactionHistory(String companyName, double boughtShares, double soldShares, double lossOrGain,
			int stockInHand) {
		
		this.companyName = companyName;
		this.boughtShares = boughtShares;
		this.soldShares = soldShares;
		this.lossOrGain = lossOrGain;
		this.stockInHand = stockInHand;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getBoughtShares() {
		return boughtShares;
	}
	public void setBoughtShares(double boughtShares) {
		this.boughtShares = boughtShares;
	}
	public double getSoldShares() {
		return soldShares;
	}
	public void setSoldShares(double soldShares) {
		this.soldShares = soldShares;
	}
	public double getLossOrGain() {
		return lossOrGain;
	}
	public void setLossOrGain(double lossOrGain) {
		this.lossOrGain = lossOrGain;
	}
	public double getStockInHand() {
		return stockInHand;
	}
	public void setStockInHand(int stockInHand) {
		this.stockInHand = stockInHand;
	}
	

}
