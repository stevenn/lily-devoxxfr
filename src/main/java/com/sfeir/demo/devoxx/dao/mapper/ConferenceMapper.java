package com.sfeir.demo.devoxx.dao.mapper;

import org.lilyproject.repository.api.Record;

import com.sfeir.demo.devoxx.domain.Conference;

public interface ConferenceMapper {
	public Conference map(Record record, String nameSpace);
	
	public Record map(Conference conference, String nameSpace);
}
