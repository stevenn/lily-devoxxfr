package com.sfeir.demo.devoxx.resource.impl;

import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sfeir.demo.devoxx.dao.VoteDao;
import com.sfeir.demo.devoxx.domain.Vote;
import com.sfeir.demo.devoxx.resource.VoteResource;

public class VoteResourceImpl extends ServerResource implements VoteResource {

	private static final String VOTE_ID = "voteId";
	
	private VoteDao voteDao;
	
	public VoteResourceImpl() {
	}

	@Autowired
	public VoteResourceImpl(VoteDao voteDao) {
		this.voteDao = voteDao;
	}

	public Vote findById() {
		final String voteId = (String) getRequestAttributes().get(
				VOTE_ID);
		return voteDao.findById(voteId);
	}

	public void create(Vote vote) {
	}

	public void update(Vote vote) {

	}

	public void deleteById() {
		final String voteId = (String) getRequestAttributes().get(
				VOTE_ID);
		voteDao.delete(voteId);
	}

}
