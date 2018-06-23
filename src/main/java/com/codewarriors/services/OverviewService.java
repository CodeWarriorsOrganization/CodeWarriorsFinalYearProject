package com.codewarriors.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codewarriors.db.PlayerService;
import com.codewarriors.entities.Player;

@Service
@Transactional
public class OverviewService {
	@Autowired
	private PlayerService playerService;
	
	public List<Player> getWinner() {
		
		List<Player> players = new ArrayList<Player>();
		
		players =   playerService.getAllPlayers();
		
		return players;
	}
}
