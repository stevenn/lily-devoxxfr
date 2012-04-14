package com.sfeir.demo.devoxx.dao.impl;

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
					.field(new QName(nameSpace, "conferenceType"), conference.getConferenceType().name())
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
}
