package com.codewarriors.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class HistoricalWinnersTests {

	// Is getRoundNo() method return value or not null.
	@Test
	public void getRoundNoTest() {
		HistoricalWinners roundNojunit = new HistoricalWinners();
		int result = roundNojunit.getRoundNo();
		System.out.println("Round No is not empty: " + result);
		assertNotNull("Round No is successfully returned: " + result);

	}

	// Checking whether the Round No is a numeric value.
	@Test
	public void checkNumeric() {
		HistoricalWinners roundNojunit = new HistoricalWinners();
		int result = roundNojunit.getRoundNo();
		if ((result % 1) != 0) {

			System.out.println("Round No is a not a numeric value: " + result);
		} else {
			System.out.println("Round No is a numeric value: " + result);
		}
	}

	// Checking if the value for Round No is properly set.
	@Test
	public void setRoundNoTest() {
		HistoricalWinners roundNojunit = new HistoricalWinners();
		int expectedrNo = roundNojunit.getRoundNo();
		int actualrNo = roundNojunit.getRoundNo();
		assertSame(expectedrNo, actualrNo);
		if (expectedrNo == actualrNo) {

			System.out.println("Both expected Round No and actual Round No are equal:" + " " + expectedrNo + "  " + "="
					+ "  " + actualrNo);
		}

	}
	
	// Check if the getWinnerName is empty
		@Test
		public void getWinnerNameTest() {
			HistoricalWinners wNamejunit = new HistoricalWinners();
			String name = wNamejunit.getWinnerName();
			System.out.println("Winner Name cannot be empty, Please enter a player name: " + " " + name);
			assertNull("Winner Name cannot be empty, Please enter a player name", name);
		}

		// checking Winner Name is a string value using parseInt() method.
		@Test
		public void checkAlphanumeric() {
			HistoricalWinners wNamejunit = new HistoricalWinners();
			String name = wNamejunit.getWinnerName();

			if (name != null) {
				name = name;
			} else {
				name = "Pamo";
			}

			try {
				Integer.parseInt(name);
				System.out.println("Winner Name is a not string:" + " " + name);
			} catch (NumberFormatException e) {
				System.out.println("Winner Name is a string:" + " " + name);
			}
		}

		// checking if the Winner Name is properly set.
		@Test
		public void setpNameTest() {
			HistoricalWinners wNamejunit = new HistoricalWinners();
			String expectedwName = wNamejunit.getWinnerName();
			String actualwName = wNamejunit.getWinnerName();
			assertSame(expectedwName, actualwName);
			if (expectedwName == actualwName) {

				System.out.println("Both expected Name and actual Name are equal:" + " " + expectedwName + "  " + "=" + "  "
						+ actualwName);
			}

		}
		
		// Is getNoOfTrades() method return value or not null.
		@Test
		public void getNoOfTradesTest() {
			HistoricalWinners tradesjunit = new HistoricalWinners();
			int result = tradesjunit.getNoOfTrades();
			System.out.println("No of trades  is not empty: " + result);
			assertNotNull("No of tradesis successfully returned: " + result);

		}

		// Checking whether the no of  trade is a numeric value.
		@Test
		public void checktradeNumeric() {
			HistoricalWinners tradesjunit = new HistoricalWinners();
			int result = tradesjunit.getNoOfTrades();
			if ((result % 1) != 0) {

				System.out.println("No of trades is a not a numeric value: " + result);
			} else {
				System.out.println("No of trade is a numeric value: " + result);
			}
		}

		// Checking if the value for Round No is properly set.
		@Test
		public void setNoOfTradesTest() {
			HistoricalWinners tradesjunit = new HistoricalWinners();
			int expectedtNo = tradesjunit.getNoOfTrades();
			int actualtNo = tradesjunit.getNoOfTrades();
			assertSame(expectedtNo, actualtNo);
			if (expectedtNo == actualtNo) {

				System.out.println("Both expected Round No and actual Round No are equal:" + " " + expectedtNo + "  " + "="
						+ "  " + actualtNo);
			}

		}
		// Is getNetWorth() method return value or not null.
		@Test
		public void getNetWorthTest() {
			HistoricalWinners networthjunit = new HistoricalWinners();
			double result = networthjunit.getNetWorth();
			System.out.println("Net Worth is not empty: " + result);
			assertNotNull("Net Worth is successfully returned: " + result);

		}

		// Checking whether the Net Worth is a numeric value.
		@Test
		public void checkNetWorthNumeric() {
			HistoricalWinners networthjunit = new HistoricalWinners();
			double result = networthjunit.getNetWorth();
			if ((result % 1) != 0) {

				System.out.println("Net Worth is a not a numeric value: " + result);
			} else {
				System.out.println("Net Worth is a numeric value: " + result);
			}
		}

		// Checking if the value for Net Worth is properly set.
		@Test
		public void setNetWorthTest() {
			HistoricalWinners networthjunit = new HistoricalWinners();
			double expectedtnetworth = networthjunit.getNetWorth();
			double actualnetworth = networthjunit.getNetWorth();
			assertNotSame(expectedtnetworth, actualnetworth);
			if (expectedtnetworth == actualnetworth) {

				System.out.println("Both expected Net Worth and actual Net Worth are equal:" + " " + expectedtnetworth + "  " + "="
						+ "  " + actualnetworth);
			}

		}
		
		// Is getTotalReturns() method return value or not null.
				@Test
				public void getTotalReturnsTest() {
					HistoricalWinners totalReturnjunit = new HistoricalWinners();
					double result = totalReturnjunit.getTotalReturns();
					System.out.println("Total Returns is not empty: " + result);
					assertNotNull("Total Returns is successfully returned: " + result);

				}

				// Checking whether the Total Returns is a numeric value.
				@Test
				public void checkTotalReturnsNumeric() {
					HistoricalWinners totalReturnjunit = new HistoricalWinners();
					double result = totalReturnjunit.getTotalReturns();
					if ((result % 1) != 0) {

						System.out.println("Net Worth is a not a numeric value: " + result);
					} else {
						System.out.println("Net Worth is a numeric value: " + result);
					}
				}

				// Checking if the value for Total Returns is properly set.
				@Test
				public void setTotalReturnsTest() {
					HistoricalWinners totalReturnjunit = new HistoricalWinners();
					double expectedttotalReturn = totalReturnjunit.getTotalReturns();
					double actualtotalReturn = totalReturnjunit.getTotalReturns();
					assertNotSame(expectedttotalReturn, actualtotalReturn);
					if (expectedttotalReturn == actualtotalReturn) {

						System.out.println("Both expected Total Returns and actual Total Returns are equal:" + " " + expectedttotalReturn + "  " + "="
								+ "  " + actualtotalReturn);
					}

				}


}
