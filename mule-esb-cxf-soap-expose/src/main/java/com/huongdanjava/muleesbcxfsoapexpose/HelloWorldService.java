package com.huongdanjava.muleesbcxfsoapexpose;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;

@WebService
public interface HelloWorldService {

	@WebMethod
	String hello(@WebParam(header = true, mode = Mode.INOUT) String clientId, @WebParam String name);

}
