package com.sfeir.demo.devoxx.resource;

import org.restlet.resource.Get;

import com.sfeir.demo.devoxx.domain.Conference;

public interface ConferencesResource {

    @Get
    public Conference getConferences();
    
}
