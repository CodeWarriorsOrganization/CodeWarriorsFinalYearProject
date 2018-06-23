package com.codewarriors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewarriors.entities.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Integer>{

	Player findByplayerName(String name);
	
	


}
