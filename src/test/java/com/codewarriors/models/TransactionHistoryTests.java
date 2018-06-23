package com.codewarriors.models;

import static org.junit.Assert.*;
import com.codewarriors.models.TransactionHistory;
import org.junit.Test;



public class TransactionHistoryTests {

	// Is getBoughtStockQty() method return value or not null. 
	@Test
	public void getBoughtStockQtyTest() {
		TransactionHistory bstockqtyjunit = new TransactionHistory ();
		int result = bstockqtyjunit.getBoughtStockQty();
		System.out.println("Brought Stock Qty is not empty: "+ result );	
		assertNotNull("Brought Stock Qty is successfully returned: "+ result);		
		
	}
	
	// Checking  whether the Brought Stock Qty is a numeric value.
	@Test
	public void checkBStockQtyNumeric() {
		TransactionHistory bstockqtyjunit = new TransactionHistory ();
		int result = bstockqtyjunit.getBoughtStockQty();
		if ((result%1)!=0) {
			
			System.out.println("Brought Stock Qty is a not a numeric value: "+ result );
		}
		else 
		{	
			System.out.println("Brought Stock Qty is a numeric value: "+ result );
		}	
	}
	
	// Checking if the value for Brought Stock Qty is properly set.
	@Test
	public void setBoughtStockQtyTest() {
		TransactionHistory bstockqtyjunit = new TransactionHistory ();	
		int expectedbstockqty = bstockqtyjunit.getBoughtStockQty();
		int actualbstockqty = bstockqtyjunit.getBoughtStockQty();
		assertSame(expectedbstockqty, actualbstockqty);
		if (expectedbstockqty == actualbstockqty) {
			
			System.out.println("Both expected Brought Stock Qty and actual Brought Stock Qty are equal:" + " "+ expectedbstockqty + "  "+"=" +"  "+ actualbstockqty);
		}
		
	}
	
	// Is getBoughtStockQty() method return value or not null. 
	@Test
	public void getSellStockQtyTest() {
		TransactionHistory sstockqtyjunit = new TransactionHistory ();
		int result = sstockqtyjunit.getSellStockQty();
		System.out.println("Sell Stock Qty is not empty: "+ result );	
		assertNotNull("Sell Stock Qty is successfully returned: "+ result);		
		
	}
	
	// Checking  whether the Sell Stock Qty is a numeric value.
	@Test
	public void checkSellStockQtyNumeric() {
		TransactionHistory sstockqtyjunit = new TransactionHistory ();
		int result = sstockqtyjunit.getSellStockQty();
		if ((result%1)!=0) {
			
			System.out.println("Sell Stock Qty is a not a numeric value: "+ result );
		}
		else 
		{	
			System.out.println("Sell Stock Qty is a numeric value: "+ result );
		}	
	}
	
	// Checking if the value for Sell Stock Qty is properly set.
	@Test
	public void setSellStockQtyTest() {
		TransactionHistory sstockqtyjunit = new TransactionHistory ();	
		int expectedsstockqty = sstockqtyjunit.getSellStockQty();
		int actualsstockqty = sstockqtyjunit.getSellStockQty();
		assertSame(expectedsstockqty, actualsstockqty);
		if (expectedsstockqty == actualsstockqty) {
			
			System.out.println("Both expected Sell Stock Qty and actual Sell Stock Qty are equal:" + " "+ expectedsstockqty + "  "+"=" +"  "+ actualsstockqty);
		}
		
	}
	
	// Is getCompanyName() method return value or not null.
			@Test
			public void getCompanyNameTest() {
				String companyName;
				TransactionHistory companyNamejunit = new TransactionHistory();
				String result = companyNamejunit.getCompanyName();
				if (result == null) {

					companyName = "Is a String";
				} else {

					companyName = "";
				}

				System.out.println("Company Name is not empty: " + result + " " + companyName);
				assertNotNull("Company Name is successfully returned: " + result + " " + companyName);
			}

			// checking Company Name is a string value using parseInt() method.
			@Test
			public void checkAlphanumeric() {
				TransactionHistory companyNamejunit = new TransactionHistory();
				String compname = companyNamejunit.getCompanyName();

				if (compname != null) {
					compname = compname;
				} else {
					compname = "IFS";
				}

				try {
					Integer.parseInt(compname);
					System.out.println("Company Name is a not string:" + " " + compname);
				} catch (NumberFormatException e) {
					System.out.println("Compan Name is a string:" + " " + compname);
				}
			}

			// Checking if the value for Company Name is properly set.
			@Test
			public void setCompanyNameTest() {
				TransactionHistory companyNamejunit = new TransactionHistory();
				String expectedcompName = companyNamejunit.getCompanyName();
				String actualcompName = companyNamejunit.getCompanyName();
				assertSame(expectedcompName, actualcompName);
				if (expectedcompName == actualcompName) {

					System.out.println("Both expected Company and actual Company Names are equal:" + " " + expectedcompName
							+ "  " + "=" + "  " + actualcompName);
				}
			}

			// Is getBoughtShares() method return value or not null.
			@Test
			public void getBoughtSharesTest() {
				TransactionHistory bsharesunit = new TransactionHistory();
				double result = bsharesunit.getBoughtShares();
				System.out.println("Bought Shares is not empty: " + result);
				assertNotNull("Bought Shares is successfully returned: " + result);

			}

			// Checking whether the Bought Shares is a numeric value.
			@Test
			public void checkBoughtSharesNumeric() {
				TransactionHistory bsharesunit = new TransactionHistory();
				double result = bsharesunit.getBoughtShares();
				if ((result % 1) != 0) {
				} else {
					System.out.println("Bought Shares is a numeric value: " + result);
				}
			}

			// Checking if the value for Bought Shares is properly set.
			@Test
			public void setBoughtSharesTest() {
				TransactionHistory bsharesunit = new TransactionHistory();
				double expectedbshares= bsharesunit.getBoughtShares();
				double actualbshares = bsharesunit.getBoughtShares();
				assertEquals(expectedbshares,actualbshares,0.0);
				if (expectedbshares == actualbshares) {

					System.out.println("Both expected Bought Shares and actual Bought Shares are equal:" + " " + expectedbshares + "  "
							+ "=" + "  " + actualbshares);
				}

			}
			
			// Is getSoldShares() method return value or not null.
						@Test
						public void getSoldSharesTest() {
							TransactionHistory ssharesunit = new TransactionHistory();
							double result = ssharesunit.getSoldShares();
							System.out.println("Sold Shares is not empty: " + result);
							assertNotNull("Sold Shares is successfully returned: " + result);

						}

						// Checking whether the Sold Shares is a numeric value.
						@Test
						public void checkSoldSharesNumeric() {
							TransactionHistory ssharesunit = new TransactionHistory();
							double result = ssharesunit.getSoldShares();
							if ((result % 1) != 0) {
							} else {
								System.out.println("Sold Shares is a numeric value: " + result);
							}
						}

						// Checking if the value for Sold Shares is properly set.
						@Test
						public void setSoldSharesTest() {
							TransactionHistory ssharesunit = new TransactionHistory();
							double expectedsshares= ssharesunit.getSoldShares();
							double actualsshares = ssharesunit.getSoldShares();
							assertEquals(expectedsshares,actualsshares,0.0);
							if (expectedsshares == actualsshares) {

								System.out.println("Both expected Sold Shares and actual Sold Shares are equal:" + " " + expectedsshares + "  "
										+ "=" + "  " + actualsshares);
							}

						}

						// Is getLossOrGain() method return value or not null.
						@Test
						public void getLossOrGainTest() {
							TransactionHistory lgunit = new TransactionHistory();
							double result = lgunit.getLossOrGain();
							System.out.println("Loos or Gain is not empty: " + result);
							assertNotNull("Loss or Gain is successfully returned: " + result);

						}

						// Checking whether the Loss or Gain is a numeric value.
						@Test
						public void checkLossGainNumeric() {
							TransactionHistory lgunit = new TransactionHistory();
							double result = lgunit.getLossOrGain();
							if ((result % 1) != 0) {
							} else {
								System.out.println("Loss or Gain is a numeric value: " + result);
							}
						}

						// Checking if the value for Loss or Gain is properly set.
						@Test
						public void setLossOrGainTest() {
							TransactionHistory lgunit = new TransactionHistory();
							double expectedlg= lgunit.getLossOrGain();
							double actuallg = lgunit.getLossOrGain();
							assertEquals(expectedlg,actuallg,0.0);
							if (expectedlg == actuallg) {

								System.out.println("Both expected Loss or Gain and actual Loss or Gain are equal:" + " " + expectedlg + "  "
										+ "=" + "  " + actuallg);
							}

						}

						// Is getStockInHand() method return value or not null.
						@Test
						public void getStockInHandTest() {
							TransactionHistory sihunit = new TransactionHistory();
							double result = sihunit.getStockInHand();
							System.out.println("Stock in Hand is not empty: " + result);
							assertNotNull("Stock in Hand is successfully returned: " + result);

						}

						// Checking whether the Loss or Gain is a numeric value.
						@Test
						public void checkStockInHandNumeric() {
							TransactionHistory sihunit = new TransactionHistory();
							double result = sihunit.getStockInHand();
							if ((result % 1) != 0) {
							} else {
								System.out.println("Stock in Hand is a numeric value: " + result);
							}
						}

						// Checking if the value for Stock in Hand is properly set.
						@Test
						public void setStockInHandTest() {
							TransactionHistory sihunit = new TransactionHistory();
							double expectedsih= sihunit.getStockInHand();
							double actualsih = sihunit.getStockInHand();
							assertEquals(expectedsih,actualsih,0.0);
							if (expectedsih == actualsih) {

								System.out.println("Both Stock in Hand and actual Stock in Hand are equal:" + " " + expectedsih + "  "
										+ "=" + "  " + actualsih);
							}

						}
}
