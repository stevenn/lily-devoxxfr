package com.sfeir.demo.devoxx.repository;

import org.lilyproject.client.LilyClient;
import org.lilyproject.repository.api.IdGenerator;
import org.lilyproject.repository.api.Record;
import org.lilyproject.repository.api.RecordBuilder;
import org.lilyproject.repository.api.RecordException;
import org.lilyproject.repository.api.RecordId;
import org.lilyproject.repository.api.RecordTypeBuilder;
import org.lilyproject.repository.api.RepositoryException;
import org.lilyproject.repository.api.TypeException;
import org.springframework.beans.factory.FactoryBean;

import com.google.common.base.Preconditions;

@SuppressWarnings("rawtypes")
public class SessionFactory implements FactoryBean, Session {

	private LilyClient lilyClient;
	
	private IdGenerator idGenerator;

	public Session getObject() throws Exception {
		idGenerator = lilyClient.getRepository().getIdGenerator();
		return this;
	}

	public Class getObjectType() {
		return SessionFactory.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
    public void setLilyClient(final LilyClient lilyClient) {
    	Preconditions.checkNotNull(lilyClient, "Could not create a LilyClient with a null LilyClient reference");
        this.lilyClient = lilyClient;
    }
    
    public RecordTypeBuilder getRecordTypeBuilder() throws TypeException {
    	return lilyClient.getRepository().getTypeManager().recordTypeBuilder();
    }
    
    public RecordBuilder getRecordBuilder() throws RecordException, InterruptedException {
    	return lilyClient.getRepository().recordBuilder();
    }

	public Record findById(String id) throws RepositoryException, InterruptedException {
		Preconditions.checkNotNull(id, "Could not retreive a record with a null identifier");
		return lilyClient.getRepository().read(idGenerator.fromString(id));
	}
	
	public void delete(String id) throws RepositoryException, InterruptedException {
		Preconditions.checkNotNull(id, "Could not delete a record with a null identifier");
		lilyClient.getRepository().delete(idGenerator.fromString(id));
	}
	
	public RecordId getRecordId(String identifier) {
		return idGenerator.fromString(identifier);
	}
}
