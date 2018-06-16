package com.codewarriors.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codewarriors.models.Market;
import com.codewarriors.models.StockMarketPriceGenerator;


@RestController
@RequestMapping("/stockMarket")

public class StockMarketSharesDetailsController {
	
	
	@PostMapping("/getMarketPrices")
	public Market getStokMarketSharsPrices() {
	
		StockMarketPriceGenerator markets=new StockMarketPriceGenerator();
		return markets.generate();
	}


}
