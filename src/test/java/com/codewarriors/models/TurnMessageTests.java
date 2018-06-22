package com.codewarriors.models;

import static org.junit.Assert.*;

import org.junit.Test;

import antlr.collections.List;

public class TurnMessageTests {

	// Is getBuyMessages() method return value or not null.
	@Test
	public void getBuyMessagesTest() {

		TurnMessage msgjunit = new TurnMessage();
		List buymsg = (List) msgjunit.getBuyMessages();
		assertNotNull("Message is successfully returned: " + buymsg);
	}

	// Checking if the value for setBuyMessages is properly set.
	@Test
	public void setBuyMessagesTest() {
		TurnMessage msgjunit = new TurnMessage();
		List expectedbuymsg = (List) msgjunit.getBuyMessages();
		List actualbuymsg = (List) msgjunit.getBuyMessages();
		assertSame(expectedbuymsg, actualbuymsg);
	}
	
	// Is getSellMessages() method return value or not null.
		@Test
		public void getSellMessageTests() {

			TurnMessage msgjunit = new TurnMessage();
			List sellmsg = (List) msgjunit.getSellMessages();
			assertNotNull("Message is successfully returned: " + sellmsg);
		}

		// Checking if the value for setSellMessages is properly set.
		@Test
		public void setSellMessagesTest() {
			TurnMessage msgjunit = new TurnMessage();
			List expectedsellmsg = (List) msgjunit.getSellMessages();
			List actualsellmsg = (List) msgjunit.getSellMessages();
			assertSame(expectedsellmsg, actualsellmsg);
		}
}
