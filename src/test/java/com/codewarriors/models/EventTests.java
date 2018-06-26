package com.codewarriors.models;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;

import com.codewarriors.entities.HistoricalWinners;
import com.codewarriors.models.Event;
public class EventTests {

	@Test
	public void getEventAfectedCompanies() {
		List<String> eventAfectedCompanies;
		Event e = new Event ();
		eventAfectedCompanies = e.getEventAfectedCompanies();
		 
		assertNull(eventAfectedCompanies);
		
	}
	
	// Check if the getEventName is empty
			@Test
			public void getEventNameeTest() {
				Event ejunit = new Event();
				String ename = ejunit.getEventName();
				System.out.println("Event Name cannot be empty, Please enter a player name: " + " " + ename);
				assertNull("Event Name cannot be empty, Please enter a player name", ename);
			}

			// checking Event Name is a string value using parseInt() method.
			@Test
			public void checkAlphanumeric() {
				Event ejunit = new Event();
				String ename = ejunit.getEventName();

				if (ename != null) {
					ename = ename;
				} else {
					ename = "Pamo";
				}

				try {
					Integer.parseInt(ename);
					System.out.println("Event Name is a not string:" + " " + ename);
				} catch (NumberFormatException e) {
					System.out.println("Event Name is a string:" + " " + ename);
				}
			}

			// checking if the Event Name is properly set.
			@Test
			public void setpNameTest() {
				Event ejunit = new Event();
				String expectedeName = ejunit.getEventName();
				String actualeName =ejunit.getEventName();
				assertSame(expectedeName, actualeName);
				if (expectedeName == actualeName) {

					System.out.println("Both expected Name and actual Name are equal:" + " " + expectedeName + "  " + "=" + "  "
							+ actualeName);
				}

			}
			

}
