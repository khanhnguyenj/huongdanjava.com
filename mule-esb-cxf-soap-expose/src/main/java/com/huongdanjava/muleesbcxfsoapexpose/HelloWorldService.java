package com.huongdanjava.muleesbcxfsoapexpose;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorldService {

	@WebMethod
	String hello(String name);

}
