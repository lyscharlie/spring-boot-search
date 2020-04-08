package com.lyscharlie.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyscharlie.search.biz.mapper")
public class SpringBootSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSearchApplication.class, args);
	}

}
