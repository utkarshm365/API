package com.qa.clients;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class RestClients {

	//get method
	
	public Response getdata(String url) {
		
		Response resp = get(url);
		
		return resp;
	}
	
//	public Response postData(String url , String entityString) {
//		ContentType(entityString).post(url);
//		return resp;
//	}
}
