package com.revature.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.soap.ServiceEndpointInterface;

public class App {
	public static void main(String[] args) {
		String url = "http://localhost:8080/soap-service/endpoint";
		JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(ServiceEndpointInterface.class);
		beanFactory.setAddress(url);
		
		ServiceEndpointInterface service = (ServiceEndpointInterface) beanFactory.create();
		System.out.println(service.readData());
	}
}
