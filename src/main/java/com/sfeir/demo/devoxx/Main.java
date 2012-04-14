package com.sfeir.demo.devoxx;

import java.util.concurrent.TimeUnit;

import org.restlet.ext.wadl.WadlApplication;
import org.restlet.representation.Representation;
import org.restlet.service.ConnectorService;

public class Main extends WadlApplication {

	public Main() {
        setConnectorService(new ConnectorService() {        
        	
        	private long startTime;
        	
            @Override
            public void beforeSend(Representation entity) {
            	startTime = System.nanoTime();
            }
        	
            @Override
            public void afterSend(Representation entity) {
            	System.out.println("Main - setConnectorService - afterSend : " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
            }
        });
	}

}
