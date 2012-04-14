package com.sfeir.demo.devoxx.dao;

import com.sfeir.demo.devoxx.domain.Conference;

public interface ConferenceDao {

	public void create(final Conference conference);
	
	public Conference findById(final String conferenceId);
}
