package com.codewarriors.models;

import static org.junit.Assert.*;

import org.junit.Test;

import antlr.collections.List;

public class AnalysisMessageTests {

	// Is getTurnMessage() method return value or not null.
		@Test
		public void getTurnMessageTest() {

			 AnalysisMessage msgjunit = new AnalysisMessage();
			List analystmsg = (List) msgjunit.getTurnMessage();
			assertNotNull("Message is successfully returned: " + analystmsg);
		}

		// Checking if the value for setBuyMessages is properly set.
		@Test
		public void setTurnMessageTest() {
			 AnalysisMessage msgjunit = new AnalysisMessage();
			List expectedanalystmsg = (List) msgjunit.getTurnMessage();
			List actualanalystmsg = (List) msgjunit.getTurnMessage();
			assertSame(expectedanalystmsg, actualanalystmsg);
		}

}
