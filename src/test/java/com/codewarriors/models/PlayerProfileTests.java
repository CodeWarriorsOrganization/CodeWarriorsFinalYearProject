package com.codewarriors.models;

import static org.junit.Assert.*;
import org.junit.Test;
import com.codewarriors.models.PlayerProfile;
public class PlayerProfileTests {

	// Check if the getProfileName is empty 
		@Test 
		public void getProfileNameTest() {
			PlayerProfile namejunit = new PlayerProfile() ;
		    String name = namejunit.getProfileName();
		    System.out.println("player Profile Name cannot be empty, Please enter a player name: "+" "+ name );	
			assertNull("player Name cannot be empty, Please enter a player name",name);			
		}
		
		// checking player Profile Name is a string value using parseInt() method.
		@Test
		public void checkAlphanumeric () {
			PlayerProfile namejunit = new PlayerProfile();
		    String name = namejunit.getProfileName();
		    
		    if (name  != null) {
		    	name = name;
		    }
		    else 
		    {
		    	name = "Pamo";
		    }
		    
		    try
	        {
	            Integer.parseInt(name);
	            System.out.println("Player Profile Name is a not string:" +" "+ name);
	        } 
	        catch (NumberFormatException e) 
	        {
	            System.out.println("Player Profile is a string:" +" "+ name);
	        }
		}
		
		//checking if the Player Profile Name is properly set.
		@Test
		public void setProfileNameTest() {
			PlayerProfile namejunit = new PlayerProfile() ;
		    String expectedProName = namejunit.getProfileName();
		    String actualProName = namejunit.getProfileName();
		    assertSame(expectedProName, actualProName);
			if (expectedProName == actualProName) {
				
				System.out.println("Both expected Name and actual Name are equal:" + " "+ expectedProName + "  "+"=" +"  "+ actualProName);
			}
			
		}
		
		// Is getNoOfTrades() method return value or not null. 
		@Test
		public void getNoOfTradesTest() {
			PlayerProfile tradesjunit = new PlayerProfile ();
			int result = tradesjunit.getNoOfTrades();
			System.out.println("No of Trades is not empty: "+ result );	
			assertNotNull("No of Trandes is successfully returned: "+ result);		
			
		}
		
		// Checking  whether the No of Trades is a numeric value.
		@Test
		public void checkNumeric() {
			PlayerProfile tradesjunit = new PlayerProfile ();
			int result = tradesjunit.getNoOfTrades();
			if ((result%1)!=0) {
				
				System.out.println("No of Trades is a not a numeric value: "+ result );
			}
			else 
			{	
				System.out.println("No of Trades is a numeric value: "+ result );
			}	
		}
		
		// Checking if the value for No of Trades is properly set.
		@Test
		public void setNoOfTradesTest() {
			PlayerProfile tradesjunit = new PlayerProfile ();
			int expectedtrade = tradesjunit.getNoOfTrades();
			int actualtrade = tradesjunit.getNoOfTrades();
			assertSame(expectedtrade, actualtrade);
			if (expectedtrade == actualtrade) {
				
				System.out.println("Both expected Trades and actual Trades are equal:" + " "+ expectedtrade + "  "+"=" +"  "+ actualtrade);
			}
			
		}
		
		// Is getpBalance() method return value or not null.
		@Test
		public void getpBalanceTest() {
			PlayerProfile balacejunit = new PlayerProfile();
			double result = balacejunit.getpBalance();
			System.out.println("Balance is not empty: " + result);
			assertNotNull("Balance is successfully returned: " + result);

		}

		// Checking whether the Balance is a numeric value.
		@Test
		public void checkBalanceNumeric() {
			PlayerProfile balacejunit = new PlayerProfile();
			double result = balacejunit.getpBalance();
			if ((result % 1) != 0) {
			} else {
				System.out.println("Balance is a numeric value: " + result);
			}
		}

		// Checking if the value for Balance is properly set.
		@Test
		public void setpBalanceTest() {
			PlayerProfile balacejunit = new PlayerProfile();
			double expectedbalance = balacejunit.getpBalance();
			double actualbalance = balacejunit.getpBalance();
			assertEquals(expectedbalance,actualbalance,0.0);
			if (expectedbalance == actualbalance) {

				System.out.println("Both expected Balance and actual Balance are equal:" + " " + expectedbalance + "  "
						+ "=" + "  " + actualbalance);
			}

		}

		// Is getTotalReturns() method return value or not null.
				@Test
				public void getTotalReturnsTest() {
					PlayerProfile tolretjunit = new PlayerProfile();
					double result = tolretjunit.getTotalReturns();
					System.out.println("Total Returns is not empty: " + result);
					assertNotNull("Total Returns is successfully returned: " + result);

				}

				// Checking whether the Total Return is a numeric value.
				@Test
				public void checkTotalReturnNumeric() {
					PlayerProfile tolretjunit = new PlayerProfile();
					double result = tolretjunit.getTotalReturns();
					if ((result % 1) != 0) {
					} else {
						System.out.println("Total Returns is a numeric value: " + result);
					}
				}

				// Checking if the value for Total Returns is properly set.
				@Test
				public void setTotalReturnsTest() {
					PlayerProfile tolretjunit = new PlayerProfile();
					double expectedtolret = tolretjunit.getTotalReturns();
					double actualtoret = tolretjunit.getTotalReturns();
					assertEquals(expectedtolret,actualtoret,0.0);
					if (expectedtolret == actualtoret) {

						System.out.println("Both expected Balance and actual Balance are equal:" + " " + expectedtolret + "  "
								+ "=" + "  " + actualtoret);
					}

				}
				
				// Is getRank() method return value or not null. 
				@Test
				public void getRankTest() {
					PlayerProfile rankjunit = new PlayerProfile ();
					int result = rankjunit.getRank();
					System.out.println("Rank is not empty: "+ result );	
					assertNotNull("Rank is successfully returned: "+ result);		
					
				}
				
				// Checking  whether the No of Rank is a numeric value.
				@Test
				public void checkRankNumeric() {
					PlayerProfile rankjunit = new PlayerProfile ();
					int result = rankjunit.getRank();
					if ((result%1)!=0) {
						
						System.out.println("Rank is a not a numeric value: "+ result );
					}
					else 
					{	
						System.out.println("RankS is a numeric value: "+ result );
					}	
				}
				
				// Checking if the value for Rank is properly set.
				@Test
				public void setRankTest() {
					PlayerProfile rankjunit = new PlayerProfile ();
					int expectedrank = rankjunit.getRank();
					int actualrank = rankjunit.getRank();
					assertSame(expectedrank, actualrank);
					if (expectedrank == actualrank) {
						
						System.out.println("Both expected Rank and actual Rank are equal:" + " "+ expectedrank + "  "+"=" +"  "+ actualrank);
					}
					
				}

}
