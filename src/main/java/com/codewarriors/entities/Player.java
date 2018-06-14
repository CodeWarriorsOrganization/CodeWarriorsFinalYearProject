package com.codewarriors.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pID;

	@Column(name = "playername", nullable = false, unique = true)

	@NotEmpty(message = "Please enter a name")
	private String playerName;

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Player(String playerName) {

		this.playerName = playerName;
	}

	public Player() {

	}

	@Override
	public String toString() {
		return "Player [pID=" + pID + ", playerName=" + playerName + "]";
	}

}
