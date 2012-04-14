package com.sfeir.demo.devoxx.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("vote")
public class Vote {

	//private volatile Conference conference;
	private volatile String conferenceId;
	
	private int notation;
	
	private volatile String remarks;

	public Vote() {
	}

	public Vote(String conferenceId, int notation, String remarks) {
		super();
		this.conferenceId = conferenceId;
		this.notation = notation;
		this.remarks = remarks;
	}

	public String getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(String conferenceId) {
		this.conferenceId = conferenceId;
	}

	public int getNotation() {
		return notation;
	}

	public void setNotation(int notation) {
		this.notation = notation;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conferenceId == null) ? 0 : conferenceId.hashCode());
		result = prime * result + notation;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
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
		Vote other = (Vote) obj;
		if (conferenceId == null) {
			if (other.conferenceId != null)
				return false;
		} else if (!conferenceId.equals(other.conferenceId))
			return false;
		if (notation != other.notation)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vote [conferenceId=" + conferenceId + ", notation=" + notation
				+ ", remarks=" + remarks + "]";
	}
}
