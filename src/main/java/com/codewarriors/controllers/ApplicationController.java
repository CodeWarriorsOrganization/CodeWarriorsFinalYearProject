package com.codewarriors.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.codewarriors.entities.Player;
import com.codewarriors.services.PlayerService;

@Controller
public class ApplicationController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/waitingScreen", method = RequestMethod.POST)
	public String result(@ModelAttribute("txtGetName") String name, BindingResult result, Model model) {

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

				return "waitingScreen";
			}
		}
	}
	
//	@RequestMapping(value = "/gameScreen", method = RequestMethod.GET)
	@GetMapping(value = "/gameScreen")
	public  String loadGameScreen(HttpServletRequest request) {
		
	//	Player player = new Player();
	List<Player> players = new ArrayList<Player>();
		players = playerService.getAllPlayers();
		request.setAttribute("players",players);
		return "gameScreen";
	}

	
}
