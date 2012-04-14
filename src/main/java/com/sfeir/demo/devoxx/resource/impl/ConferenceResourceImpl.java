package com.sfeir.demo.devoxx.resource.impl;

import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sfeir.demo.devoxx.dao.ConferenceDao;
import com.sfeir.demo.devoxx.domain.Conference;
import com.sfeir.demo.devoxx.resource.ConferenceResource;

public class ConferenceResourceImpl extends ServerResource implements
		ConferenceResource {

	private static final Logger logger = LoggerFactory
			.getLogger(ConferenceResourceImpl.class);

	private static final String CONFERENCE_ID = "conferenceId";

	private ConferenceDao conferenceDao;

	@Autowired
	public ConferenceResourceImpl(ConferenceDao conferenceDao) {
		this.conferenceDao = conferenceDao;
	}

	public Conference findById() {
		logger.info("ConferenceResourceImpl - findById");
		final String conferenceId = (String) getRequestAttributes().get(
				CONFERENCE_ID);
		return conferenceDao.findById(conferenceId);
	}

	public void create(final Conference conference) {
		conferenceDao.create(conference);
	}

	public void update(final Conference conference) {
		// TODO Auto-generated method stub
	}
}
