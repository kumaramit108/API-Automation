package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	//1. Create Get Method
	public void get(String url) throws ClientProtocolException, IOException{
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request
		 CloseableHttpResponse closablehttpresponse = httpClient.execute(httpget); // hit the url
		 
		 //a. Status code
		 int statuscode = closablehttpresponse.getStatusLine().getStatusCode(); // getting response code
		 System.out.println("Status code"+statuscode);
		 
		 //b. JSON string
		 String responsestring = EntityUtils.toString(closablehttpresponse.getEntity(),"UTF-8"); //
		 
		 JSONObject responseJson = new JSONObject(responsestring);
		 System.out.println("Response JSON from API ----->"+responseJson);
		 
		 //c. All headers
		 Header[] headersArray = closablehttpresponse.getAllHeaders();
		 
		 HashMap<String, String> allHeaders = new HashMap<String, String>();
		 
		 for(Header header: headersArray){
			 allHeaders.put(header.getName(), header.getValue());
		 }
		 System.out.println("Headers Array --->"+allHeaders); 
	}
	
}
