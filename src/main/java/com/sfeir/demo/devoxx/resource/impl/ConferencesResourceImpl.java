package com.sfeir.demo.devoxx.resource.impl;

import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sfeir.demo.devoxx.domain.Conference;
import com.sfeir.demo.devoxx.resource.ConferencesResource;

public class ConferencesResourceImpl extends ServerResource implements ConferencesResource {

	Logger logger = LoggerFactory.getLogger(ConferencesResourceImpl.class);
	
	public Conference getConferences() {
		// TODO Auto-generated method stub
		return null;
	}

}
