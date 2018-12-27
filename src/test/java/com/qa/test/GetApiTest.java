package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetApiTest extends TestBase{

	TestBase testBase;
	String serviceurl;
	String apiurl;
	public String url;
	RestClient restClient;
	
	@BeforeMethod
	public void setUP() throws ClientProtocolException, IOException{
		testBase = new TestBase();
		serviceurl = prop.getProperty("url");
		apiurl = prop.getProperty("serviceURL");
		url = serviceurl + apiurl;	
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException{
		
		restClient = new RestClient();
		restClient.get(url);
	}
}
