package com.codewarriors.services;

import static org.junit.Assert.*;

import com.codewarriors.models.Market;
import com.codewarriors.services.StockMarketPriceGeneratorService;
import org.junit.Test;

public class StockMarketPriceGeneratorSeviceTests {

	// 
	@Test
	public void MarketGenerateTest() {
		Market market;
		StockMarketPriceGeneratorService junit = new StockMarketPriceGeneratorService();
		market = junit.generate();
		
		assertNotNull(market);
	}

}
