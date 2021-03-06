package com.sfeir.demo.devoxx.resource;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

import com.sfeir.demo.devoxx.domain.Conference;

public interface ConferenceResource {	
    @Get
    public Conference findById();
        
    @Put
    public void update(final Conference conference);
    
    @Delete
    public void deleteById();
}
