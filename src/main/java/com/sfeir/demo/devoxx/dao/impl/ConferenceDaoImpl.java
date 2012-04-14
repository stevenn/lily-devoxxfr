package com.sfeir.demo.devoxx.dao.impl;

import java.util.Collections;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.LBHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.lilyproject.repository.api.QName;
import org.lilyproject.repository.api.Record;
import org.lilyproject.repository.api.RecordException;
import org.lilyproject.repository.api.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sfeir.demo.devoxx.dao.ConferenceDao;
import com.sfeir.demo.devoxx.dao.mapper.impl.ConferenceMapperImpl;
import com.sfeir.demo.devoxx.domain.Conference;
import com.sfeir.demo.devoxx.repository.Session;

@Repository
public class ConferenceDaoImpl implements ConferenceDao {

	private String nameSpace;

	private Session session;
	
	private LBHttpSolrServer lbHttpSolrServer = null;

	@Autowired
	public ConferenceDaoImpl(Session session) {
		this.session = session;
	}

	public void create(Conference conference) {
		/* @formatter:off */
		try {
			session.getRecordBuilder()
					.recordType(new QName(nameSpace, "Conference"))
					.field(new QName(nameSpace, "title"), conference.getTitle())
					.field(new QName(nameSpace, "description"), conference.getDescription())
					.field(new QName(nameSpace, "speaker"), conference.getSpeaker())
					.field(new QName(nameSpace, "conferenceType"), conference.getConferenceType().toString())
					.create();
		} catch (RecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		/* @formatter:on */
	}

	public Conference findById(String conferenceId) {
		try {
			Record record = session.findById(conferenceId);
			return new ConferenceMapperImpl().map(record, nameSpace);
		} catch (RepositoryException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public List<Conference> getConferences() {
		final SolrQuery solrQuery = new SolrQuery("conferenceType:[* TO *]");
		QueryResponse response; 
		try {
			response = lbHttpSolrServer.query(solrQuery);
			return new ConferenceMapperImpl().mapList(response);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public void setLbHttpSolrServer(LBHttpSolrServer lbHttpSolrServer) {
		this.lbHttpSolrServer = lbHttpSolrServer;
	}

	public LBHttpSolrServer getLbHttpSolrServer() {
		return lbHttpSolrServer;
	}

	public void delete(String conferenceId) {
		try {
			session.delete(conferenceId);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
