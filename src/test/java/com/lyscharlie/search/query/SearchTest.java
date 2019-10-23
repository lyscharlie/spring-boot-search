package com.lyscharlie.search.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lyscharlie.search.SearchApplication;
import com.lyscharlie.search.elasticsearch.ElasticsearchClientFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class SearchTest {

	@Autowired
	private ElasticsearchClientFactory elasticsearchClientFactory;

	@Test
	public void test1(){




	}

}
