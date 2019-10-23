package com.lyscharlie.search.elasticsearch.area;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AreaSearch {

	@Value("#{elasticsearch.index.prefix}")
	private String prefix;

	private String index;

	@PostConstruct
	public void initIndexName() {
		index = prefix + "_area";
	}

}
