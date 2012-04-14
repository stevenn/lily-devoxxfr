package com.sfeir.demo.devoxx.resource;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

import com.sfeir.demo.devoxx.domain.Vote;

public interface VotesResource {
    @Get
    public List<Vote> getVotes();
    
    @Post
    public void add(final Vote vote);
}
