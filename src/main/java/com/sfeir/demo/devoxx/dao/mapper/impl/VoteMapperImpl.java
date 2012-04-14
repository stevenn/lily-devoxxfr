package com.sfeir.demo.devoxx.dao.mapper.impl;

import java.util.List;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.lilyproject.repository.api.Link;
import org.lilyproject.repository.api.QName;
import org.lilyproject.repository.api.Record;

import com.google.common.collect.Lists;
import com.sfeir.demo.devoxx.dao.mapper.VoteMapper;
import com.sfeir.demo.devoxx.domain.Vote;

public class VoteMapperImpl implements VoteMapper {
	
	public Vote map(Record record, String nameSpace) {
		Vote vote = new Vote();
		if (record.hasField(new QName(nameSpace, "conferences"))) {
			Link conferenceLink = (Link) record.getField(new QName(nameSpace, "conferences"));
			vote.setConferenceId(conferenceLink.getMasterRecordId().toString());
		}		
		if (record.hasField(new QName(nameSpace, "notation"))) {
			vote.setNotation((Integer) record.getField(new QName(
					nameSpace, "notation")));
		}
		if (record.hasField(new QName(nameSpace, "remarks"))) {
			vote.setRemarks((String) record.getField(new QName(
					nameSpace, "remarks")));
		}
		return vote;
	}
	
	public List<Vote> mapList(final QueryResponse response) {
		List<Vote> votes = Lists.newArrayList();
		for (final SolrDocument document : response.getResults()) {
			Vote newVote = new Vote();
			newVote.setConferenceId((String)document.getFieldValue("conference"));
			String notationField = (String)document.getFieldValue("notation");
			newVote.setNotation(Integer.parseInt(notationField));
			newVote.setRemarks((String)document.getFieldValue("remarks"));
			votes.add(newVote);
		}			
		return votes;
	}

	public Record map(Vote vote, String nameSpace) {
		// TODO Auto-generated method stub
		return null;
	}
}
