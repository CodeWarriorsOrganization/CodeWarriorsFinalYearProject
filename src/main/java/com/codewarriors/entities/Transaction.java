package com.codewarriors.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transID;
	private String playerName;
	private int turnID;
	private String type;
	private String compName;
	private double unitPrice;
	private int quantity;
	private double cost;

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getTurnID() {
		return turnID;
	}

	public void setTurnID(int turnID) {
		this.turnID = turnID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Transaction(int transID, String playerName, int turnID, String type, String compName, double unitPrice,
			int quantity, double cost) {

		this.transID = transID;
		this.playerName = playerName;
		this.turnID = turnID;
		this.type = type;
		this.compName = compName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.cost = cost;
	}

	public Transaction() {

	}

	public Transaction(String playerName, int turnID, String type, String compName, double unitPrice, int quantity,
			double cost) {

		this.playerName = playerName;
		this.turnID = turnID;
		this.type = type;
		this.compName = compName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.cost = cost;
	}

}
