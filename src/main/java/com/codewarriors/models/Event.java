package com.codewarriors.models;

import java.util.List;

public class Event {
	
	private List<String> eventAfectedCompanies;
	private String eventName;
	public List<String> getEventAfectedCompanies() {
		return eventAfectedCompanies;
	}
	public void setEventAfectedCompanies(List<String> eventAfectedCompanies) {
		this.eventAfectedCompanies = eventAfectedCompanies;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
