package com.sfeir.demo.devoxx.resource;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

import com.sfeir.demo.devoxx.domain.Conference;

public interface ConferencesResource {
    @Get
    public List<Conference> getConferences();
    
    @Post
    public void add(final Conference conference);   
}
