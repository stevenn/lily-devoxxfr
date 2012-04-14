package com.sfeir.demo.devoxx.resource;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

import com.sfeir.demo.devoxx.domain.Conference;

public interface ConferencesResource {

    @Get
    public Conference getConferences();
    
    @Post
    public void add(final Conference conference);
    
}
