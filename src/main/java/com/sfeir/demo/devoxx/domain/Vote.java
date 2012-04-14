package com.sfeir.demo.devoxx.domain;

public class Vote {

	private Conference conference;
	
	private int notation;
	
	private String remarks;

	public Vote(Conference conference, int notation, String remarks) {
		super();
		this.conference = conference;
		this.notation = notation;
		this.remarks = remarks;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
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
				+ ((conference == null) ? 0 : conference.hashCode());
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
		if (conference == null) {
			if (other.conference != null)
				return false;
		} else if (!conference.equals(other.conference))
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
		return "Vote [conference=" + conference + ", notation=" + notation
				+ ", remarks=" + remarks + "]";
	}
}
