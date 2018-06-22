package com.codewarriors.components;

import static org.junit.Assert.*;
import com.codewarriors.components.EventComponentValues;
import org.junit.Test;

public class EventComponentValuesTests {
	
	// checking does the eventComponentValuesGenerator returns an value.
	@Test
	public void eventComponentValuesGeneratorTest() {

		int[][] eventValues = new int[30][12];
		int[][] result = EventComponentValues.eventComponentValuesGenerator(eventValues);
		assertNotNull(result);
		System.out.println("The function eventComponentValuesGenerator is not null, it returns a random value:"
				+ " " + result);
	}
	
}
