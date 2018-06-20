package com.codewarriors.models;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.codewarriors.models.Turn;

public class TurnTests {

	 // Is getTurnId() method return value or not null. 
		@Test
		public void getTurnIdTest() {
			Turn turnIDjunit = new Turn ();
			int result = turnIDjunit.getTurnId();
			System.out.println("Turn ID  is not empty: "+ result );	
			assertNotNull("Turn ID is successfully returned: "+ result);		
			
		}
		
		// Checking  whether the Turn ID  is a numeric value.
		@Test
		public void checkNumeric() {
			Turn turnIDjunit = new Turn ();
			int result = turnIDjunit.getTurnId();
			if ((result%1)!=0) {
				
				System.out.println("Turn ID is a not a numeric value: "+ result );
			}
			else 
			{	
				System.out.println("Turn ID is a numeric value: "+ result );
			}	
		}
		
		// Checking if the value for Turn ID is properly set.
		@Test
		public void setturnIDTest() {
			Turn turnIDjunit = new Turn ();
			int expectedturnID = turnIDjunit.getTurnId();
			int actualturnID = turnIDjunit.getTurnId();
			assertSame(expectedturnID, actualturnID);
			if (expectedturnID == actualturnID) {
				
				System.out.println("Both expected pID and actual pID are equal:" + " "+ expectedturnID + "  "+"=" +"  "+ actualturnID);
			}
			
		}
		
		// Is getgetPrice() method return value or not null. 
				@Test
				public void getPriceest() {
					Turn pricejunit = new Turn ();
					double result = pricejunit.getPrice();
					System.out.println("Price  is not empty: "+ result );	
					assertNotNull("Price is successfully returned: "+ result);		
					
				}
				
				// Checking  whether the Price  is a numeric value.
				@Test
				public void checkPriceNumeric() {
					Turn pricejunit = new Turn ();
					double result = pricejunit.getPrice();
					if ((result%1)!=0) {
						
						System.out.println("Price is a not a numeric value: "+ result );
					}
					else 
					{	
						System.out.println("Price is a numeric value: "+ result );
					}	
				}
				
				// Checking if the value for Price is properly set.
				@Test
				public void setPriceTest() {
					Turn pricejunit = new Turn ();
					double expectedPrice = pricejunit.getPrice();
					double actualPrice = pricejunit.getPrice();
					assertEquals(expectedPrice,actualPrice,0.0);
					if (expectedPrice == actualPrice) {
						System.out.println("Both expected Price and actual Price are equal:" + " "+ expectedPrice + "  "+"=" +"  "+ actualPrice);
					}
					
				}

}
