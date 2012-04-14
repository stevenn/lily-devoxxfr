package com.sfeir.demo.devoxx.domain;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@XStreamAlias("conference")
public class Conference implements Serializable {

	//@Field("title")
	private volatile String title;
	
	//@Field("speaker")
	private volatile String speaker;
	
	//@Field("description")
	private volatile String description;
	
	//@Field("conferenceType")
	private ConferenceType conferenceType;	

	public Conference() {
	}

	public Conference(String title, String speaker, String description,
			ConferenceType conferenceType) {
		super();
		this.title = title;
		this.speaker = speaker;
		this.description = description;
		this.conferenceType = conferenceType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ConferenceType getConferenceType() {
		return conferenceType;
	}

	public void setConferenceType(ConferenceType conferenceType) {
		this.conferenceType = conferenceType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conferenceType == null) ? 0 : conferenceType.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((speaker == null) ? 0 : speaker.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conference other = (Conference) obj;
		if (conferenceType != other.conferenceType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (speaker == null) {
			if (other.speaker != null)
				return false;
		} else if (!speaker.equals(other.speaker))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conference [title=" + title + ", speaker=" + speaker
				+ ", description=" + description + ", conferenceType="
				+ conferenceType + "]";
	}
}
