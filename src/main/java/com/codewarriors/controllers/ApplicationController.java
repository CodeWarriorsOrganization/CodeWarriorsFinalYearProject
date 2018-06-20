package com.codewarriors.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
import com.codewarriors.models.PlayerProfile;

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

	@RequestMapping(value = "/gameOverview", method = RequestMethod.GET)

	public String loadGameOverviewScreen(HttpServletRequest request) {
		
		  List<PlayerProfile> playerProfile = new ArrayList<PlayerProfile>();
		  PlayerProfile p1 = new PlayerProfile();
		Bank b = new Bank();
		Bank b2 = new Bank();
		String winnerName="";
        List<Player> players = new ArrayList<Player>();
        List<Bank> playerRanking = new ArrayList<Bank>();
        players = playerService.getAllPlayers();
        double  maxBalance=0;
        double getBalance;
        int size = players.size();
        List<Double> balance = new ArrayList<Double>();
        List<Integer> noOfTrades = new ArrayList<Integer>();
        List<Bank> getPlayerRows = new ArrayList<Bank>();
      
        
     for(int i=0;i<size;i++) { // we need to get playerName,noOftrades,stock in hand,balance,returns,rank

    	 
    	 // get player details- player name, balance
    	b = brokerService.getLastRecordByPlayer(players.get(i).getPlayerName());
    	
    	p1.setProfileName(b.getpName());
    	
    	// get balance of the each player
    	p1.setpBalance(b.getBalance());
    	
    	//get noOfTrades of the each player
    	 getPlayerRows =brokerService.findAllByPName(players.get(i).getPlayerName());
    	 noOfTrades.add(getPlayerRows.size());
    	 
    	 p1.setNoOfTrades((noOfTrades.get(i))-1);
    	 
    	 //get the returns
    	 p1.setpBalance((p1.getpBalance())-1000); 
    	 
    	 
    	  playerProfile.add(p1);
    	 
    	 
    	
    	
     //     playerRanking.get(i).getTurnNo() = 
    	 //playerRanking.get(i).setTurnNo(getPlayerRows.get(i).getTurnNo());    
    	// playerRanking.set(i,getPlayerRows.get(i).getTurnNo());
    	 
    	// playerProfile.add(arg0)
    
     
     }	 
     
     
     
     
     Collections.sort(playerProfile, new Comparator<PlayerProfile>() 
     
     {
    	 
    	 public int compare(PlayerProfile p1, PlayerProfile p2) {
    		 
    		 
    		 return Double.valueOf(p2.getpBalance()).compareTo(p1.getpBalance()); 
    		 
    	 }

	});
    // Collections.reverse(balance);
     
     
     
     for(int i=0;i<size;i++) {
    	 
    //	playerRanking.get(i).setTurnNo((noOfTrades.get(i))-1); //passing the number of trades done by the player
    //playerRanking.get(i).setAmount(playerRanking.get(i).getBalance()-1000);
    	 
    	 
    	 System.out.println(playerProfile.get(i).getProfileName()+" "+playerProfile.get(i).getpBalance()+" "+playerProfile.get(i).getNoOfTrades());
    	 
    	
    	 
     }
     
  
     
	 System.out.println();
	 System.out.println();
	 request.setAttribute("playerProfile",playerProfile);
	// request.setAttribute("rankingList",playerRanking.size() );


		return "gameOverview";
	}
}
