package com.cloudera.demo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CollectionFacade {

	private static final Logger logger = Logger.getLogger(CollectionFacade.class);

	private static final String URL_QUERY_POSTFIX = "/solr/test_collection/select?_=1560983742598&q=*:*";

	private static final String URL_POST_POSTFIX = "/solr/test_collection/update/json/docs";

	
	private static final String URL_PREFIX = "http://";

	private Integer port;

	private String hostname;

	public String createQueryUrl() {
		if (port == null) {
			throw new RuntimeException("The port must be set");
		}

		if (hostname == null) {
			throw new RuntimeException("The hostname must be set");
		}

		return URL_PREFIX + hostname + ":" + port + URL_QUERY_POSTFIX;
	}

	public String createPostUrl() {
		if (port == null) {
			throw new RuntimeException("The port must be set");
		}

		if (hostname == null) {
			throw new RuntimeException("The hostname must be set");
		}

		return URL_PREFIX + hostname + ":" + port + URL_POST_POSTFIX;
	}
	
	public void query() {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String url = createQueryUrl();

		HttpGet httpGet = new HttpGet(url);
		try {
			CloseableHttpResponse response1 = httpclient.execute(httpGet);

			try {
				System.out.println(response1.getStatusLine());
				HttpEntity entity1 = response1.getEntity();
				// do something useful with the response body
				// and ensure it is fully consumed

				try (InputStream inStream = entity1.getContent();
						ByteArrayOutputStream output = new ByteArrayOutputStream()) {
					IOUtils.copy(inStream, output);

					logger.info("Received:\n" + output.toString());
				}

			} finally {
				response1.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Protocol exception: " + e.getMessage());
		}
	}

	public void create(Item item) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			String itemStr = objectMapper.writeValueAsString(item);

			CloseableHttpClient httpclient = HttpClients.createDefault();
			
			HttpPost httpPost = new HttpPost(createPostUrl());
			
		    StringEntity entity = new StringEntity(itemStr);
		    httpPost.setEntity(entity);
		    httpPost.setHeader("Accept", "application/json");
		    httpPost.setHeader("Content-type", "application/json");
		    
		    
		    CloseableHttpResponse response2 = httpclient.execute(httpPost);
		    
		    try {
		    		HttpEntity entity2 = response2.getEntity();
				try (InputStream inStream = entity2.getContent();
						ByteArrayOutputStream output = new ByteArrayOutputStream()) {
					IOUtils.copy(inStream, output);

					logger.info("Received:\n" + output.toString());
				}
			} finally {
			    response2.close();
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Unable to create new Solr item: " + e.getMessage());

		}
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

}
