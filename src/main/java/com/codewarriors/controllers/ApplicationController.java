package com.codewarriors.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codewarriors.db.BrokerService;
import com.codewarriors.db.PlayerService;
import com.codewarriors.entities.Bank;
import com.codewarriors.entities.Player;

@Controller
public class ApplicationController {

	@Autowired
	private BrokerService brokerService;
	@Autowired
	private PlayerService playerService;

	public static String playerName;
	public static int pID;

	@RequestMapping(value = "/waitingScreen", method = RequestMethod.POST)
	public String result(@ModelAttribute("txtGetName") String name, BindingResult result, Model model) {

		playerName = name;
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

				Bank b = new Bank(playerName);

				brokerService.createBankAccount(b);

				return "waitingScreen";
			}
		}
	}

	@GetMapping(value = "/gameScreen")
	public String loadGameScreen(@ModelAttribute("txtGetName") String name, BindingResult result, Model model) {
		Bank b1 = new Bank();
		b1 = brokerService.findByPnameAndType(playerName, "Initial");

		model.addAttribute("balance", b1.getBalance());

		model.addAttribute("pName", playerName);
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
