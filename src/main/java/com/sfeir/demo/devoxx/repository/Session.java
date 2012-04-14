package com.sfeir.demo.devoxx.repository;

import org.lilyproject.client.LilyClient;
import org.lilyproject.repository.api.Record;
import org.lilyproject.repository.api.RecordBuilder;
import org.lilyproject.repository.api.RecordException;
import org.lilyproject.repository.api.RecordTypeBuilder;
import org.lilyproject.repository.api.RepositoryException;
import org.lilyproject.repository.api.TypeException;

public interface Session {

	public Session getObject() throws Exception;
	
	public RecordBuilder getRecordBuilder() throws RecordException, InterruptedException;
	
	public RecordTypeBuilder getRecordTypeBuilder() throws TypeException; 
	
	public Record findById(String id) throws RepositoryException, InterruptedException; 
}
