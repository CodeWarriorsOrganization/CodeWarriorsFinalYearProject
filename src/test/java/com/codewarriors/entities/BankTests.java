package com.codewarriors.entities;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BankTests {

	private String pName = "Pamo";
	private int turnNo = 0;
	private String type = "Initial";

	private double amount = 1000;
	private double balance = 1000;

	// Is getBankID() method return value or not null.
	@Test
	public void getBankIDTest() {
		Bank bankIDjunit = new Bank();
		int result = bankIDjunit.getBankID();
		System.out.println("BankID is not empty: " + result);
		assertNotNull("BankId is successfully returned: " + result);

	}

	// Checking whether the Bank ID is a numeric value.
	@Test
	public void checkNumeric() {
		Bank bankIDjunit = new Bank();
		int result = bankIDjunit.getBankID();
		if ((result % 1) != 0) {

			System.out.println("BankID is a not a numeric value: " + result);
		} else {
			System.out.println("BankID is a numeric value: " + result);
		}
	}

	// Checking if the value for Bank Id is properly set.
	@Test
	public void setBankIDTest() {
		Bank bankIDjunit = new Bank();
		int expectedpID = bankIDjunit.getBankID();
		int actualpID = bankIDjunit.getBankID();
		assertSame(expectedpID, actualpID);
		if (expectedpID == actualpID) {

			System.out.println("Both expected bankID and actual bankID are equal:" + " " + expectedpID + "  " + "="
					+ "  " + actualpID);
		}

	}

	// Check if the pName is empty
	@Test
	public void getpNameTest() {
		Bank pNamejunit = new Bank();
		String name = pNamejunit.getpName();
		System.out.println("player Name cannot be empty, Please enter a player name: " + " " + name);
		assertNull("player Name cannot be empty, Please enter a player name", name);
	}

	// checking pName is a string value using parseInt() method.
	@Test
	public void checkAlphanumeric() {
		Bank pNamejunit = new Bank();
		String name = pNamejunit.getpName();

		if (name != null) {
			name = name;
		} else {
			name = "Pamo";
		}

		try {
			Integer.parseInt(name);
			System.out.println("Player Name is a not string:" + " " + name);
		} catch (NumberFormatException e) {
			System.out.println("Player Name is a string:" + " " + name);
		}
	}

	// checking if the pName is properly set.
	@Test
	public void setpNameTest() {
		Bank pNamejunit = new Bank();
		String expectedName = pNamejunit.getpName();
		String actualName = pNamejunit.getpName();
		assertSame(expectedName, actualName);
		if (expectedName == actualName) {

			System.out.println("Both expected Name and actual Name are equal:" + " " + expectedName + "  " + "=" + "  "
					+ actualName);
		}

	}

	// Is getTurnNo() method return value or not null.
	@Test
	public void getTurnNoTest() {
		Bank turnNojunit = new Bank();
		int result = turnNojunit.getTurnNo();
		System.out.println("Turn No is not empty: " + result);
		assertNotNull("Turn No is successfully returned: " + result);

	}

	// Checking whether the Turn No is a numeric value.
	@Test
	public void checkTurnNoNumeric() {
		Bank turnNojunit = new Bank();
		int result = turnNojunit.getBankID();
		if ((result % 1) != 0) {

			System.out.println("Turn No is a not a numeric value: " + result);
		} else {
			System.out.println("Turn No is a numeric value: " + result);
		}
	}

	// Checking if the value for Turn No is properly set.
	@Test
	public void setTypeTest() {
		Bank turnNojunit = new Bank();
		int expectedturnNo = turnNojunit.getTurnNo();
		int actualturnNo = turnNojunit.getTurnNo();
		assertSame(expectedturnNo, actualturnNo);
		if (expectedturnNo == actualturnNo) {

			System.out.println("Both expected Turn No and actual Turn No are equal:" + " " + expectedturnNo + "  " + "="
					+ "  " + actualturnNo);
		}

	}

	// Is getAmount() method return value or not null.
	@Test
	public void getAmountTest() {
		Bank amountjunit = new Bank();
		double result = amountjunit.getAmount();
		System.out.println("Amount is not empty: " + result);
		assertNotNull("Amount is successfully returned: " + result);

	}

	// Checking whether the Amount is a numeric value.
	@Test
	public void checkAmountNumeric() {
		Bank amountjunit = new Bank();
		double result = amountjunit.getAmount();
		if ((result % 1) != 0) {

			System.out.println("Amount is a not a numeric value: " + result);
		} else {
			System.out.println("Amount is a numeric value: " + result);
		}
	}

	// Checking if the value for Amount is properly set.
	@Test
	public void setAmountTest() {
		Bank amountjunit = new Bank();
		double expectedtamount = amountjunit.getAmount();
		double actualamount = amountjunit.getAmount();
		assertNotSame(expectedtamount, actualamount);
		if (expectedtamount == actualamount) {

			System.out.println("Both expected Amount and actual Amount are equal:" + " " + expectedtamount + "  " + "="
					+ "  " + actualamount);
		}

	}

	// Is getBalance() method return value or not null.
	@Test
	public void getBalanceTest() {
		Bank balacejunit = new Bank();
		double result = balacejunit.getBalance();
		System.out.println("Balance is not empty: " + result);
		assertNotNull("Balance is successfully returned: " + result);

	}

	// Checking whether the Balance is a numeric value.
	@Test
	public void checkBalanceNumeric() {
		Bank balancetjunit = new Bank();
		double result = balancetjunit.getBalance();
		if ((result % 1) != 0) {
		} else {
			System.out.println("Balance is a numeric value: " + result);
		}
	}

	// Checking if the value for Balance is properly set.
	@Test
	public void setBalanceTest() {
		Bank balancetjunit = new Bank();
		double expectedbalance = balancetjunit.getBalance();
		double actualbalance = balancetjunit.getBalance();
		assertNotSame(expectedbalance, actualbalance);
		if (expectedbalance == actualbalance) {

			System.out.println("Both expected Balance and actual Balance are equal:" + " " + expectedbalance + "  "
					+ "=" + "  " + actualbalance);
		}

	}

	@Test
	public void Bank () {
		this.pName = pName;
		this.turnNo = turnNo;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		System.out.println("Bank:" + "" + "Player Name:" + " " + this.pName + " " + " Turn No" + " " + this.turnNo + " "
				+ "Type:" + " " + this.type + " " + " amount:" + " " + this.amount + " " + " " + " Balance:"
				+ this.balance);
	}

}
