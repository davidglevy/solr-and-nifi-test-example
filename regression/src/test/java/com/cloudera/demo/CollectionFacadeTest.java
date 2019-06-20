package com.cloudera.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CollectionFacadeTest {

	private static final Logger logger = Logger.getLogger(CollectionFacadeTest.class);
	
	private CollectionFacade target;
	
	private ItemCreator creator = new ItemCreator();
	
	@Before
	public void setupTarget() {
		CollectionFacade facade = new CollectionFacade();
		
		AppTestPropertyUtil propUtil = new AppTestPropertyUtil();
		
		String hostname = propUtil.getProperty("solr.host");
		facade.setHostname(hostname);
		
		String port = propUtil.getProperty("solr.port");
		facade.setPort(Integer.valueOf(port));
		target = facade;
	}
	
	@Test
	public void testQuery() {
		target.query();
	}
	
	@Test
	public void testCreate() {
		Item item = creator.createNext();
		target.create(item);
	}
	
	@Test
	public void testCreateMany() {
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Item item = creator.createNext();
			items.add(item);
		}
		
		target.create(items);
	}
	
	@Test
	public void testForDemo() {
		Item item = creator.createNext();
		item.setName("Steve");
		target.create(item);
		Assert.fail("Bad result");
	}
}
