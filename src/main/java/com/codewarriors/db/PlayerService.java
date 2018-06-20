package com.codewarriors.db;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.codewarriors.entities.Player;
import com.codewarriors.repositories.PlayerRepo;

@Service
@Transactional
public class PlayerService {

	private final PlayerRepo playerRepository;

	public PlayerService(PlayerRepo playerRepository) {
		this.playerRepository = playerRepository;
	}

	public void savePlayer(Player player) {
		playerRepository.save(player);
	}

	public Player getPlayer(int id) {
		return playerRepository.getOne(id);
	}

	public Player findByplayerName(String name) {
		return playerRepository.findByplayerName(name);

	}

	public List<Player> getAllPlayers() {
		List<Player> players = new ArrayList<Player>();

		for (Player player : playerRepository.findAll()) {
			players.add(player);
		}

		return players;
	}

	public Player playerExist(String name) {
		Player p1 = new Player();

		p1 = playerRepository.findByplayerName(name);

		return p1;

	}
	
	
	

}
