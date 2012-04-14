package com.sfeir.demo.devoxx.dao.impl;

import java.util.Collections;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.LBHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.lilyproject.repository.api.Link;
import org.lilyproject.repository.api.QName;
import org.lilyproject.repository.api.Record;
import org.lilyproject.repository.api.RecordException;
import org.lilyproject.repository.api.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sfeir.demo.devoxx.dao.VoteDao;
import com.sfeir.demo.devoxx.dao.mapper.impl.VoteMapperImpl;
import com.sfeir.demo.devoxx.domain.Vote;
import com.sfeir.demo.devoxx.repository.Session;

@Repository
public class VoteDaoImpl implements VoteDao {

	private String nameSpace;

	private Session session;
	
	private LBHttpSolrServer lbHttpSolrServer = null;
	
	@Autowired
	public VoteDaoImpl(Session session) {
		this.session = session;
	}

	public void create(final Vote vote, final String conferenceId) {
		/* @formatter:off */
		try {
			session.getRecordBuilder()
					.recordType(new QName(nameSpace, "Vote"))
					.field(new QName(nameSpace, "conferences"), new Link(session.getRecordId(conferenceId)))
					.field(new QName(nameSpace, "notation"), vote.getNotation())
					.field(new QName(nameSpace, "remarks"), vote.getRemarks())
					.create();
		} catch (RecordException e) {
			e.printStackTrace();
		} catch (RepositoryException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		/* @formatter:on */
	}

	public Vote findById(String voteId) {
		try {
			Record record = session.findById(voteId);
			return new VoteMapperImpl().map(record, nameSpace);
		} catch (RepositoryException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Vote> getVotes() {
		final SolrQuery solrQuery = new SolrQuery("notation:[* TO *]");
		QueryResponse response; 
		try {
			response = lbHttpSolrServer.query(solrQuery);
			return new VoteMapperImpl().mapList(response);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public void delete(String voteId) {
		try {
			session.delete(voteId);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public LBHttpSolrServer getLbHttpSolrServer() {
		return lbHttpSolrServer;
	}

	public void setLbHttpSolrServer(LBHttpSolrServer lbHttpSolrServer) {
		this.lbHttpSolrServer = lbHttpSolrServer;
	}
}
