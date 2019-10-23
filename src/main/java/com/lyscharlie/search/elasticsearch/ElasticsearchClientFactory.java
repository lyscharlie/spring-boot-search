package com.lyscharlie.search.elasticsearch;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ElasticsearchClientFactory {

	@Value("#{elasticsearch.scheme}")
	private String scheme;

	@Value("#{elasticsearch.nodes}")
	private String[] nodes;

	private RestHighLevelClient client;

	public RestHighLevelClient getClient() {

		if (null == client) {
			try {
				HttpHost[] httpHosts = new HttpHost[nodes.length];
				for (int i = 0; i < nodes.length; i++) {
					String[] arr = StringUtils.split(nodes[i], ":");
					httpHosts[i] = new HttpHost(arr[0], Integer.parseInt(arr[1]), scheme);
				}
				client = new RestHighLevelClient(RestClient.builder(httpHosts));
			} catch (NumberFormatException e) {
				log.error("初始化client失败");
			}
		}

		return client;
	}
}
