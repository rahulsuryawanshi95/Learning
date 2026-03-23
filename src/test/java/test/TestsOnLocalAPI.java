package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class TestsOnLocalAPI 
{
//	@Test
	public void get()
	{
		baseURI="http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
	}
	
//	@Test
	public void post()
	{
		JSONObject request=new JSONObject();
		
		request.put("firstName", "Raj");
		request.put("lastName", "Surya");
		request.put("subjectId", 1);
		request.put("Id", 4);
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);			
	}
	
	@Test
	public void put()
	{
		JSONObject request=new JSONObject();
		
		request.put("firstName", "Albert");
		request.put("lastName", "Einstein");
		request.put("subjectId", 2);
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/3").
		then().
			statusCode(200);			
	}
	
//	@Test
	public void patch()
	{
		JSONObject request=new JSONObject();
		
		request.put("lastName", "Doe");
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/3").
		then().
			statusCode(200);			
	}

}
