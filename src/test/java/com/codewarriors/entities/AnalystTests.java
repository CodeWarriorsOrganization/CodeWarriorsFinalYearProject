package com.codewarriors.entities;


import org.junit.Test;

import com.codewarriors.models.AnalysisMessage;

public class AnalystTests {

	
	// checking does the getStockData returns an value.
	@Test
	public void getStockData() {

		AnalysisMessage analysisMessage = new AnalysisMessage();
		AnalysisMessage result = (AnalysisMessage) analysisMessage.getTurnMessage();
	}
}
