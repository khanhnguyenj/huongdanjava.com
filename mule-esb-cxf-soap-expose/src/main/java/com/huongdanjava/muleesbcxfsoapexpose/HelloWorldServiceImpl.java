package com.huongdanjava.muleesbcxfsoapexpose;

import javax.jws.WebService;

import com.huongdanjava.muleesbcxfsoapexpose.HelloWorldService;

@WebService
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String hello(String name) {
		return "Hello, " + name;
	}

}
