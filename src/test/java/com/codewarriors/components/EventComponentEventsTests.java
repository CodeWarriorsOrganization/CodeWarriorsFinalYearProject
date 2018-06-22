package com.codewarriors.components;

import static org.junit.Assert.*;
import com.codewarriors.components.EventComponentEvents;
import org.junit.Test;

public class EventComponentEventsTests {

	// checking does the eventComponentRandomEventGenerator returns an value.
	@Test
	public void eventComponentRandomEventGeneratorTest() {

		int[][] result = EventComponentEvents.eventComponentRandomEventGenerator();
		assertNotNull(result);
		System.out.println("The function eventComponentRandomEventGenerator is not null, it returns a random value:"
				+ " " + result);
	}
	
}
