package com.priti.RestAssurredProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIDemo 
{
	@Test
	public void secondGetRequest()
	{
		//specify the base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		//Send get request
		Response response=RestAssured.given()
				.when()
				.get("/users/v1");
		//print response body
		System.out.println(response.getBody().toString());
		
	}

}
