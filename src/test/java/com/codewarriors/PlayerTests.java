package com.codewarriors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.codewarriors.entities.Player;

public class PlayerTests {
	
    // Is getID() method return value or not null. 
	@Test
	public void getpIDTest() {
		Player pIDjunit = new Player ();
		int result = pIDjunit.getpID();
		System.out.println("pID is not empty: "+ result );	
		assertNotNull("pId is successfully returned: "+ result);		
		
	}
	
	// Checking  whether the pID is a numeric value.
	@Test
	public void checkNumeric() {
		Player pIDjunit = new Player ();
		int result = pIDjunit.getpID();
		if ((result%1)!=0) {
			
			System.out.println("pID is a not a numeric value: "+ result );
		}
		else 
		{	
			System.out.println("pID is a numeric value: "+ result );
		}	
	}
	
	// Checking if the value for pId is properly set.
	@Test
	public void setpIDTest() {
		Player pIDjunit = new Player ();
		int expectedpID = pIDjunit.getpID();
		int actualpID = pIDjunit.getpID();
		assertSame(expectedpID, actualpID);
		if (expectedpID == actualpID) {
			
			System.out.println("Both expected pID and actual pID are equal:" + " "+ expectedpID + "  "+"=" +"  "+ actualpID);
		}
		
	}
	
	// Check if the player name is empty 
	@Test 
	public void getPlayerNameTest() {
		Player namejunit = new Player() ;
	    String name = namejunit.getPlayerName();
	    System.out.println("player Name cannot be empty, Please enter a player name: "+" "+ name );	
		assertNull("player Name cannot be empty, Please enter a player name",name);			
	}
	
	// checking player Name is a string value using parseInt() method.
	@Test
	public void checkAlphanumeric () {
		Player namejunit = new Player() ;
	    String name = namejunit.getPlayerName();
	    
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
            System.out.println("Player Name is a not string:" +" "+ name);
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Player Name is a string:" +" "+ name);
        }
	}
	
	//checking if the Player Name is properly set.
	@Test
	public void setPlayerNameTest() {
		Player namejunit = new Player() ;
	    String expectedName = namejunit.getPlayerName();
	    String actualName = namejunit.getPlayerName();
	    assertSame(expectedName, actualName);
		if (expectedName == actualName) {
			
			System.out.println("Both expected Name and actual Name are equal:" + " "+ expectedName + "  "+"=" +"  "+ actualName);
		}
		
	}
}
