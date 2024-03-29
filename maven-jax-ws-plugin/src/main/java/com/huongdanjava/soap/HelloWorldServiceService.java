
package com.huongdanjava.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "HelloWorldServiceService", targetNamespace = "http://maven.huongdanjava.com/", wsdlLocation = "file:/Users/khanh/Documents/code/huongdanjava.com/maven-jax-ws-plugin/src/main/resources/wsdl/hello.wsdl")
public class HelloWorldServiceService
    extends Service
{

    private static final URL HELLOWORLDSERVICESERVICE_WSDL_LOCATION;
    private static final WebServiceException HELLOWORLDSERVICESERVICE_EXCEPTION;
    private static final QName HELLOWORLDSERVICESERVICE_QNAME = new QName("http://maven.huongdanjava.com/", "HelloWorldServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/Users/khanh/Documents/code/huongdanjava.com/maven-jax-ws-plugin/src/main/resources/wsdl/hello.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOWORLDSERVICESERVICE_WSDL_LOCATION = url;
        HELLOWORLDSERVICESERVICE_EXCEPTION = e;
    }

    public HelloWorldServiceService() {
        super(__getWsdlLocation(), HELLOWORLDSERVICESERVICE_QNAME);
    }

    public HelloWorldServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOWORLDSERVICESERVICE_QNAME, features);
    }

    public HelloWorldServiceService(URL wsdlLocation) {
        super(wsdlLocation, HELLOWORLDSERVICESERVICE_QNAME);
    }

    public HelloWorldServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOWORLDSERVICESERVICE_QNAME, features);
    }

    public HelloWorldServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HelloWorldService
     */
    @WebEndpoint(name = "HelloWorldServicePort")
    public HelloWorldService getHelloWorldServicePort() {
        return super.getPort(new QName("http://maven.huongdanjava.com/", "HelloWorldServicePort"), HelloWorldService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorldService
     */
    @WebEndpoint(name = "HelloWorldServicePort")
    public HelloWorldService getHelloWorldServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://maven.huongdanjava.com/", "HelloWorldServicePort"), HelloWorldService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOWORLDSERVICESERVICE_EXCEPTION!= null) {
            throw HELLOWORLDSERVICESERVICE_EXCEPTION;
        }
        return HELLOWORLDSERVICESERVICE_WSDL_LOCATION;
    }

}
