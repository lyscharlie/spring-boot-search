package com.lyscharlie.search.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

	@RequestMapping("hello.htm")
	public String hello() {
		return "hello";
	}
}
