package com.sfeir.demo.devoxx.dao.mapper;

import org.lilyproject.repository.api.Record;

import com.sfeir.demo.devoxx.domain.Vote;

public interface VoteMapper {
	public Vote map(Record record, String nameSpace);
	
	public Record map(Vote vote, String nameSpace);
}
