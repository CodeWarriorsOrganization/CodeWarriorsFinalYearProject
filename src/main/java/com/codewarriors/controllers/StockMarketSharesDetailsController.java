package com.codewarriors.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewarriors.models.GameContentHolder;
import com.codewarriors.models.Market;
import com.codewarriors.services.StockMarketPriceGeneratorService;


@RestController
@RequestMapping("/stockMarket")

public class StockMarketSharesDetailsController {
	
	
	@PostMapping("/getMarketPrices")
	public Market getStokMarketSharsPrices() {
	

	//	StockMarketPriceGeneratorService markets= new StockMarketPriceGeneratorService();
	//	return markets.generate();
		
		return GameContentHolder.MARKET_PRICES;
		

	}
	
	
	
	//this is use only test
	@PostMapping("/getMarketPricesTest")
	public Market getStokMarketSharsPricesTest() {
	StockMarketPriceGeneratorService s= new StockMarketPriceGeneratorService();
		return s.generate();
		
	}


}
