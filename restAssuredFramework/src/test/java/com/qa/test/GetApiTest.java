package com.qa.test;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.clients.RestClients;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetApiTest extends TestBase {
	TestBase testbase;
	String appURL;
	String serviceURL;
	String URI;
	RestClients restClient = new RestClients();;
	Response response;
	RequestSpecification request;
	
	@BeforeTest
	public void setUp() {
		testbase = new TestBase();
		 appURL = prop.getProperty("appURL");
		 serviceURL  = prop.getProperty("serviceURL");
		 URI = appURL+serviceURL;
	}
	
	
	@Test
	public void getAPITest() {
		
		 response = restClient.getdata(URI);
		 int code = response.getStatusCode();
			System.out.println("---------------Status code----------");
			Assert.assertEquals(code, status_code_200);
			
			Headers head = response.getHeaders();
			System.out.println("------------Headers------------");
			System.out.println(head);
			
			double time = response.getTime();
			System.out.println("----------Time-----------");
			System.out.println(time);
			
			String body = response.asString();
			System.out.println("------Body-----------");
			String countryName = response.jsonPath().getString("name");
			System.out.println(countryName);
			Assert.assertEquals(countryName, "London");
			
			List<String> lst = new ArrayList<String>();
			lst =response.jsonPath().getList("weather");		
			System.out.println(lst);	
	}


	
	

	





}
