package event.model;

import admin.model.Admin;

public class Event extends Admin
{
	private int eventId;
	private String eventName;
	private String eventType;
	private int noParticipant;
	
	public Event() {}
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getNoParticipant() {
		return noParticipant;
	}

	public void setNoParticipant(int noParticipant) {
		this.noParticipant = noParticipant;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


}
