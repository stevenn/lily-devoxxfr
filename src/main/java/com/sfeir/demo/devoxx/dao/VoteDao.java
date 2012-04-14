package com.sfeir.demo.devoxx.dao;

import java.util.List;

import com.sfeir.demo.devoxx.domain.Vote;

public interface VoteDao {

	public void create(final Vote vote, final String conferenceId);
	
	public Vote findById(final String voteId);
	
	public List<Vote> getVotes();
	
	public void delete(String voteId);
}
