package com.sfeir.demo.devoxx.dao;

import java.util.List;

import com.sfeir.demo.devoxx.domain.Conference;

public interface ConferenceDao {

	public void create(final Conference conference);
	
	public Conference findById(final String conferenceId);
	
	public List<Conference> getConferences();
	
	public void delete(String conferenceId);
}
