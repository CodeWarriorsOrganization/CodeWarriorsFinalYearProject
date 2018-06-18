package com.codewarriors.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankID;
	private String pName;
	private int turnNo = 0;
	private String type = "Initial";

	private double amount = 1000;
	private double balance = 1000;

	public Bank(String pName) {

		this.pName = pName;
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getTurnNo() {
		return turnNo;
	}

	public void setTurnNo(int turnNo) {
		this.turnNo = turnNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Bank(int bankID, String pName, int turnNo, String type, double amount, double balance) {

		this.bankID = bankID;
		this.pName = pName;
		this.turnNo = turnNo;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}

	public Bank() {

	}

	public Bank(String pName, int turnNo, String type, double amount, double balance) {
		super();
		this.pName = pName;
		this.turnNo = turnNo;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}
}
