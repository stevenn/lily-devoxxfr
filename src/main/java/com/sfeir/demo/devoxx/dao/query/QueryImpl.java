package com.sfeir.demo.devoxx.dao.query;

import org.apache.solr.client.solrj.impl.LBHttpSolrServer;
import org.springframework.beans.factory.FactoryBean;

public class QueryImpl implements FactoryBean<Object> {

	private String[] solrServers;

	public LBHttpSolrServer getObject() throws Exception {
		return new LBHttpSolrServer(solrServers);
	}

	public Class<QueryImpl> getObjectType() {
		return QueryImpl.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public String[] getSolrServers() {
		return solrServers;
	}

	public void setSolrServers(String[] solrServers) {
		this.solrServers = solrServers;
	}	
}
