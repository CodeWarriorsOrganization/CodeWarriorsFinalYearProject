package com.codewarriors.models;

import java.util.List;

public class AnalysisMessage {
	
	private List <TurnMessage> turnMessage;

	public List<TurnMessage> getTurnMessage() {
		return turnMessage;
	}

	public void setTurnMessage(List<TurnMessage> turnMessage) {
		this.turnMessage = turnMessage;
	}

}
