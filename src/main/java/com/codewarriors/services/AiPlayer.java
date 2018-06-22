package com.codewarriors.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.codewarriors.controllers.BrokerController;
import com.codewarriors.db.BrokerService;
import com.codewarriors.db.PlayerService;
import com.codewarriors.entities.Bank;
import com.codewarriors.entities.Player;
import com.codewarriors.models.AnalysisMessage;
import com.codewarriors.models.Company;
import com.codewarriors.models.Market;
import com.codewarriors.models.Message;
import com.codewarriors.models.TurnMessage;

public class AiPlayer {
	
	private List<Company> companies;
	private static AnalysisMessage analysisMessage;
	static Random randomObj = new Random();	
	static DecimalFormat df = new DecimalFormat("###");	
	private static String AiplayerName; 
		
	public static void startPlayer(Market market ,String name ) {
		AiplayerName= name;			
		analysisMessage=market.getAnalysisMessage();		
		
		
	}
	
	
	
	

}
