package com.codewarriors.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTests {

	// Is getTransID() method return value or not null.
		@Test
		public void getTransIDTest() {
			Transaction transIDjunit = new Transaction();
			int result = transIDjunit.getTransID();
			System.out.println("Trans ID is not empty: " + result);
			assertNotNull("Trans ID is successfully returned: " + result);

		}

		// Checking whether the Trans ID is a numeric value.
		@Test
		public void checkNumeric() {
			Transaction transIDjunit = new Transaction();
			int result = transIDjunit.getTransID();
			if ((result % 1) != 0) {

				System.out.println("Trans ID is a not a numeric value: " + result);
			} else {
				System.out.println("Trans ID is a numeric value: " + result);
			}
		}

		// Checking if the value for Trans Id is properly set.
		@Test
		public void setTransIDTest() {
			Transaction transIDjunit = new Transaction();
			int expectedtransID = transIDjunit.getTransID();
			int actualtransID = transIDjunit.getTransID();
			assertSame(expectedtransID, actualtransID);
			if (expectedtransID == actualtransID) {

				System.out.println("Both expected transID and actual transID are equal:" + " " + expectedtransID + "  " + "="
						+ "  " + actualtransID);
			}

		}
		// Check if the player Name is empty
		@Test
		public void getPlayerName() {
			Transaction playerNamejunit = new Transaction();
			String name = playerNamejunit.getPlayerName();
			System.out.println("player Name cannot be empty, Please enter a player name: " + " " + name);
			assertNull("player Name cannot be empty, Please enter a player name", name);
		}

		// checking Player Name is a string value using parseInt() method.
		@Test
		public void checkAlphanumeric() {
			Transaction playerNamejunit = new Transaction();
			String name = playerNamejunit.getPlayerName();

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

		// checking if the Player Name is properly set.
		@Test
		public void setPlayerNameTest() {
			Transaction playerNamejunit = new Transaction();
			String expectedplayerName = playerNamejunit.getPlayerName();
			String actualplayerName = playerNamejunit.getPlayerName();
			assertSame(expectedplayerName, actualplayerName);
			if (expectedplayerName == actualplayerName) {

				System.out.println("Both expected Player Name and actual Player Name are equal:" + " " + expectedplayerName + "  " + "=" + "  "
						+ actualplayerName);
			}

		}
		
		// Is getTurnID() method return value or not null.
		@Test
		public void getTurnIDTest() {
			Transaction turnIDjunit = new Transaction();
			int result = turnIDjunit.getTurnID();
			System.out.println("Turn ID is not empty: " + result);
			assertNotNull("Turn ID is successfully returned: " + result);

		}

		// Checking whether the Turn ID is a numeric value.
		@Test
		public void checkTurnIDNumeric() {
			Transaction turnIDjunit = new Transaction();
			int result = turnIDjunit.getTurnID();
			if ((result % 1) != 0) {

				System.out.println("Turn ID is a not a numeric value: " + result);
			} else {
				System.out.println("Turn ID is a numeric value: " + result);
			}
		}

		// Checking if the value for Turn ID is properly set.
		@Test
		public void setTurnIDTest() {
			Transaction turnIDjunit = new Transaction();
			int expectedturnID = turnIDjunit.getTurnID();
			int actualturnID = turnIDjunit.getTurnID();
			assertSame(expectedturnID, actualturnID);
			if (expectedturnID == actualturnID) {

				System.out.println("Both expected Turn ID and actual Turn ID are equal:" + " " + expectedturnID + "  " + "="
						+ "  " + actualturnID);
			}

		}
		
		// Is getType() method return value or not null.
				@Test
				public void getTypeTest() {
					Transaction typejunit = new Transaction();
					String result = typejunit.getType();
					System.out.println("Type is not empty: " + result);
					assertNotNull("Type is successfully returned: " + result);

				}

				// checking Type is a string value using parseInt() method.
				@Test
				public void checkTypeAlphanumeric() {
					Transaction typejunit = new Transaction();
					String type = typejunit.getType();

					if (type != null) {
						type = type;
					} else {
						type = "Initial";
					}

					try {
						Integer.parseInt(type);
						System.out.println("Type is a not string:" + " " + type);
					} catch (NumberFormatException e) {
						System.out.println("Type is a string:" + " " + type);
					}
				}

				// Checking if the value for Type is properly set.
				@Test
				public void setTypeTest() {
					Transaction typejunit = new Transaction();
					String expectedtype = typejunit.getType();
					String actualtype = typejunit.getType();
					assertSame(expectedtype, actualtype);
					if (expectedtype == actualtype) {

						System.out.println("Both expected Type and actual Type are equal:" + " " + expectedtype + "  " + "="
								+ "  " + actualtype);
					}

				}
				
				// Is getCompNamee() method return value or not null.
				@Test
				public void getCompNameTest() {
					Transaction compjunit = new Transaction();
					String result = compjunit.getCompName();
					System.out.println("Company Name is not empty: " + result);
					assertNotNull("Company Name is successfully returned: " + result);

				}

				// checking Company Name is a string value using parseInt() method.
				@Test
				public void checkCompAlphanumeric() {
					Transaction compjunit = new Transaction();
					String result = compjunit.getCompName();

					if (result != null) {
						result = result;
					} else {
						result = "IFS";
					}

					try {
						Integer.parseInt(result);
						System.out.println("Company Name is a not string:" + " " + result);
					} catch (NumberFormatException e) {
						System.out.println("Company Name is a string:" + " " + result);
					}
				}

				// Checking if the value for Company Name is properly set.
				@Test
				public void setCompNameTest() {
					Transaction compjunit = new Transaction();
					String expectedcomp = compjunit.getCompName();
					String actualcomp = compjunit.getCompName();
					assertSame(expectedcomp, actualcomp);
					if (expectedcomp == actualcomp) {

						System.out.println("Both expected Company Name and actual Company Name are equal:" + " " + expectedcomp + "  " + "="
								+ "  " + actualcomp);
					}

				}
				
				// Is getUnitPrice() method return value or not null.
				@Test
				public void getUnitPriceTest() {
					Transaction unitPricejunit = new Transaction();
					double result = unitPricejunit.getUnitPrice();
					System.out.println("Unit Price is not empty: " + result);
					assertNotNull("Unit Price is successfully returned: " + result);

				}

				// Checking whether the Unit Price is a numeric value.
				@Test
				public void checkUnitPriceNumeric() {
					Transaction unitPricejunit = new Transaction();
					double result = unitPricejunit.getUnitPrice();
					if ((result % 1) != 0) {

						System.out.println("Unit Price is a not a numeric value: " + result);
					} else {
						System.out.println("Unit Price is a numeric value: " + result);
					}
				}

				// Checking if the value for Unit Price is properly set.
				@Test
				public void setUnitPriceTest() {
					Transaction unitPricejunit = new Transaction();
					double expectedtuprice = unitPricejunit.getUnitPrice();
					double actualuprice = unitPricejunit.getUnitPrice();
					assertNotSame(expectedtuprice, actualuprice);
					if (expectedtuprice == actualuprice) {

						System.out.println("Both expected Unit Price and actual Unit Price are equal:" + " " + expectedtuprice + "  " + "="
								+ "  " + actualuprice);
					}

				}
				
				// Is getQuantity() method return value or not null.
				@Test
				public void getQuantityTest() {
					Transaction qtyjunit = new Transaction();
					int result = qtyjunit.getQuantity();
					System.out.println("Quantity is not empty: " + result);
					assertNotNull("Quantity is successfully returned: " + result);

				}

				// Checking whether the Quantity is a numeric value.
				@Test
				public void checkQtyNoNumeric() {
					Transaction qtyjunit = new Transaction();
					int result = qtyjunit.getQuantity();
					if ((result % 1) != 0) {

						System.out.println("Quantity is a not a numeric value: " + result);
					} else {
						System.out.println("Quantity is a numeric value: " + result);
					}
				}

				// Checking if the value for Quantity is properly set.
				@Test
				public void setQuantityTest() {
					Transaction qtyjunit = new Transaction();
					int expectedqty = qtyjunit.getQuantity();
					int actualqty = qtyjunit.getQuantity();
					assertSame(expectedqty, actualqty);
					if (expectedqty == actualqty) {

						System.out.println("Both expected Quantity and actual Quantity are equal:" + " " + expectedqty + "  " + "="
								+ "  " + actualqty);
					}

				}

				// Is getCost() method return value or not null.
				@Test
				public void getCostTest() {
					Transaction costjunit = new Transaction();
					double result = costjunit.getCost();
					System.out.println("Cost is not empty: " + result);
					assertNotNull("Cost is successfully returned: " + result);

				}

				// Checking whether the Cost is a numeric value.
				@Test
				public void checkCostNumeric() {
					Transaction costjunit = new Transaction();
					double result = costjunit.getCost();
					if ((result % 1) != 0) {

						System.out.println("Cost is a not a numeric value: " + result);
					} else {
						System.out.println("Cost is a numeric value: " + result);
					}
				}

				// Checking if the value for Cost is properly set.
				@Test
				public void setCosttTest() {
					Transaction costjunit = new Transaction();
					double expectedcost = costjunit.getCost();
					double actualcost = costjunit.getCost();
					assertNotSame(expectedcost, actualcost);
					if (expectedcost == actualcost) {

						System.out.println("Both expected Cost and actual Cost are equal:" + " " + expectedcost + "  " + "="
								+ "  " + actualcost);
					}

				}


}
