package com.soapwebservice.endpoint;

import com.soapwebservice.ws.ItemWebServiceImplementation;
import javax.xml.ws.Endpoint;

public class WebServicePublisher {
	public static void main(String[] args) {
		   System.out.println("In WebServicePublisher");
		   Endpoint.publish("http://localhost:3131/ws/items", new ItemWebServiceImplementation());
	}
}
