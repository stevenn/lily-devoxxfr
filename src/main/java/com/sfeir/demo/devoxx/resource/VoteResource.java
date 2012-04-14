package com.sfeir.demo.devoxx.resource;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

import com.sfeir.demo.devoxx.domain.Vote;

public interface VoteResource {
    @Get
    public Vote findById();
        
    @Put
    public void update(final Vote vote);
    
    @Delete
    public void deleteById();
}
