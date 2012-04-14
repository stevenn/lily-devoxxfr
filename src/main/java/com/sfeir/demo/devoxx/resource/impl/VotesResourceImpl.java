package com.sfeir.demo.devoxx.resource.impl;

import java.util.List;

import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sfeir.demo.devoxx.dao.VoteDao;
import com.sfeir.demo.devoxx.domain.Vote;
import com.sfeir.demo.devoxx.resource.VotesResource;

public class VotesResourceImpl extends ServerResource implements VotesResource {

	private static final String CONFERENCE_ID = "conferenceId";
	
	private VoteDao voteDao;
	
	public VotesResourceImpl() {
	}
	
	@Autowired
	public VotesResourceImpl(VoteDao voteDao) {
		this.voteDao = voteDao;
	}

	public List<Vote> getVotes() {
		return voteDao.getVotes();
	}

	public void add(Vote vote) {
		final String conferenceId = (String) getRequestAttributes().get(
				CONFERENCE_ID);
		voteDao.create(vote, conferenceId);
	}
}
