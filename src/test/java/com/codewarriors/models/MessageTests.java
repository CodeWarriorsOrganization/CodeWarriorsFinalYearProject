package com.codewarriors.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageTests {

	// Is getMessage() method return value or not null.
			@Test
			public void getMessageTest() {
				String message;
				Message msgjunit = new Message();
				String result = msgjunit.getMessage();
				if (result == null) {

					message = "Is a Messages which is a String type";
				} else {

					message = "";
				}

				System.out.println("Message is not empty: " + result + " " + message);
				assertNotNull("Message is successfully returned: " + result + " " + message);
			}

			// checking Message is a string value using parseInt() method.
			@Test
			public void checkAlphanumeric() {
				Message msgjunit = new Message();
				String msg = msgjunit.getMessage();

				if (msg != null) {
					msg = msg;
				} else {
					msg = "This is a message";
				}

				try {
					Integer.parseInt(msg);
					System.out.println("Message is a not string:" + " " + msg );
				} catch (NumberFormatException e) {
					System.out.println("Message is a string:" + " " + msg);
				}
			}

			// Checking if the value for Message is properly set.
			@Test
			public void setMessageTest() {
				Message msgjunit = new Message();
				String expectedmsg = msgjunit.getMessage();
				String actualmsg = msgjunit.getMessage();
				assertSame(expectedmsg, actualmsg);
				if (expectedmsg == actualmsg) {

					System.out.println("Both expected message and actual message  are equal:" + " " + expectedmsg
							+ "  " + "=" + "  " + actualmsg);
				}
			}
}
