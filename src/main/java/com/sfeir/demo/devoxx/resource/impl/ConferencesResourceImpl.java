package com.sfeir.demo.devoxx.resource.impl;

import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sfeir.demo.devoxx.dao.ConferenceDao;
import com.sfeir.demo.devoxx.domain.Conference;
import com.sfeir.demo.devoxx.resource.ConferencesResource;

public class ConferencesResourceImpl extends ServerResource implements ConferencesResource {

	Logger logger = LoggerFactory.getLogger(ConferencesResourceImpl.class);
	
	private ConferenceDao conferenceDao;
	
	@Autowired
	public ConferencesResourceImpl(ConferenceDao conferenceDao) {
		super();
		this.conferenceDao = conferenceDao;
	}

	public Conference getConferences() {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(final Conference conference) {
		conferenceDao.create(conference);		
	}
}
