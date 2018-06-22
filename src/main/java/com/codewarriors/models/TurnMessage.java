package com.codewarriors.models;

import java.util.List;

public class TurnMessage {
	
	private List<Message> buyMessages;
	private List<Message> sellMessages;
	public List<Message> getBuyMessages() {
		return buyMessages;
	}
	public void setBuyMessages(List<Message> buyMessages) {
		this.buyMessages = buyMessages;
	}
	public List<Message> getSellMessages() {
		return sellMessages;
	}
	public void setSellMessages(List<Message> sellMessages) {
		this.sellMessages = sellMessages;
	}

}
