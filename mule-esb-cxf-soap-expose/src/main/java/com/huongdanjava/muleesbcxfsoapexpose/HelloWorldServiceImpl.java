package com.huongdanjava.muleesbcxfsoapexpose;

import javax.jws.WebService;

@WebService
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String hello(String name) {
		return "Hello, " + name;
	}

}