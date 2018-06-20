package com.codewarriors.controllers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codewarriors.db.BrokerService;
import com.codewarriors.db.PlayerService;
import com.codewarriors.entities.Bank;
import com.codewarriors.entities.Player;
import com.codewarriors.models.GameContentHolder;
import com.codewarriors.models.Market;
import com.codewarriors.services.StockMarketPriceGeneratorService;

@Controller
public class ApplicationController {

	@Autowired
	private BrokerService brokerService;
	@Autowired
	private PlayerService playerService;


	@RequestMapping(value = "/waitingScreen", method = RequestMethod.POST)
	public String result(@ModelAttribute("txtGetName") String name, BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			return "index";
		} else {
			Player player = new Player();
			player = playerService.playerExist(name);

			if (player != null) {
				model.addAttribute("errorMSG", "Player name exist!!");
				return "index";
			}

			else {
				Player p2 = new Player(name);
				playerService.savePlayer(p2);
				p2 = playerService.findByplayerName(name);

				Bank b = new Bank(name);

				brokerService.createBankAccount(b);
				
				
				//Multiplayer logic
				if(playerService.getAllPlayers().size() == 1) {
					
					StockMarketPriceGeneratorService markets=new StockMarketPriceGeneratorService();
					GameContentHolder.MARKET_PRICES = markets.generate();
					GameContentHolder.WAITING_START_TIME = LocalDateTime.now();
					
				}else {
					
					LocalDateTime to = LocalDateTime.now();
					LocalDateTime from = GameContentHolder.WAITING_START_TIME;
					long secondsDiff = from.until(to, ChronoUnit.SECONDS);
					
					if(secondsDiff< 15) {	
						model.addAttribute("SecondsTogo", (15-secondsDiff));	
					}else {			
						model.addAttribute("errorMSG", "Waiting Time has out. Please try again.");
						return "index";
					}
					
				}
				
				model.addAttribute("playername", name);	
				
				return "waitingScreen";
			}
		}
	}

	@GetMapping(value = "/gameScreen")
	public String loadGameScreen(@RequestParam String name, Model model) {
		
		Bank b1 = new Bank();
		b1 = brokerService.findByPnameAndType(name, "Initial");

		model.addAttribute("balance", b1.getBalance());
		model.addAttribute("pName", name);
		
		return "gameScreen";
	}
	
	
	@GetMapping(value = "/TestScreen")
	public String loadGameScreen() {
		
		return "testAnalist";
	}

	@RequestMapping(value = "/gameOverview", method = RequestMethod.GET)

	public String loadGameOverviewScreen() {

		return "gameOverview";
	}
}
