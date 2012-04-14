package com.sfeir.demo.devoxx.repository;

import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.lilyproject.client.LilyClient;
import org.springframework.beans.factory.FactoryBean;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

@SuppressWarnings("rawtypes")
public class LilyClientFactory implements FactoryBean {

	protected static final String ZOOKEEPER_NODE = "zk.node.";
	protected static final String COMMA = ",";

	private List<String> zookeeperNodes;
	private Integer zookeeperSessionTimeout;

	public Object getObject() throws Exception {
		final String zookeeperConnectionString = Joiner.on(COMMA).skipNulls()
				.join(zookeeperNodes);
		LilyClient lilyclient = new LilyClient(zookeeperConnectionString,
				zookeeperSessionTimeout);
		return lilyclient;
	}

	public Class<?> getObjectType() {
		return LilyClient.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void setZookeeperNodesList(final List<String> zookeeperNodes) {
		this.zookeeperNodes = zookeeperNodes;
	}

	public void setZookeeperNodes(final Properties zookeeperNodesDefinition) {
		zookeeperNodes = Lists.newArrayList();
		for (final Enumeration en = zookeeperNodesDefinition.keys(); en
				.hasMoreElements();) {
			final String key = (String) en.nextElement();
			if (key.startsWith(ZOOKEEPER_NODE)) {
				zookeeperNodes.add(zookeeperNodesDefinition.getProperty(key));
			}
		}
	}

	public void setZookeeperSessionTimeout(final Integer zookeeperSessionTimeout) {
		this.zookeeperSessionTimeout = zookeeperSessionTimeout;
	}
}
