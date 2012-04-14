package com.sfeir.demo.devoxx.dao.mapper.impl;

import java.util.List;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.lilyproject.repository.api.QName;
import org.lilyproject.repository.api.Record;

import com.google.common.collect.Lists;
import com.sfeir.demo.devoxx.dao.mapper.ConferenceMapper;
import com.sfeir.demo.devoxx.domain.Conference;
import com.sfeir.demo.devoxx.domain.ConferenceType;

public class ConferenceMapperImpl implements ConferenceMapper {
	
	public Conference map(Record record, String nameSpace) {
		Conference conference = new Conference();
		if (record.hasField(new QName(nameSpace, "title"))) {
			conference.setTitle((String) record.getField(new QName(
					nameSpace, "title")));
		}
		if (record.hasField(new QName(nameSpace, "description"))) {
			conference.setDescription((String) record.getField(new QName(
					nameSpace, "description")));
		}
		if (record.hasField(new QName(nameSpace, "speaker"))) {
			conference.setSpeaker((String) record.getField(new QName(
					nameSpace, "speaker")));
		}
		if (record.hasField(new QName(nameSpace, "conferenceType"))) {
			String conferenceTypeString = record.getField(new QName(
					nameSpace, "conferenceType"));
			conference.setConferenceType(ConferenceType
					.valueOf(conferenceTypeString));
		}
		return conference;
	}
	
	public List<Conference> mapList(final QueryResponse response) {
		List<Conference> conferences = Lists.newArrayList();
		for (final SolrDocument document : response.getResults()) {
			Conference newConference = new Conference();
			newConference.setTitle((String)document.getFieldValue("title"));
			newConference.setDescription((String)document.getFieldValue("description"));
			newConference.setSpeaker((String)document.getFieldValue("speaker"));
			String conferenceTypeCode = (String)document.getFieldValue("conferenceType");
			newConference.setConferenceType(ConferenceType.valueOf(conferenceTypeCode));
			conferences.add(newConference);
		}			
		//return response.getBeans(Conference.class);
		return conferences;
	}

	public Record map(Conference conference, String nameSpace) {
		// TODO Auto-generated method stub
		return null;
	}
}
