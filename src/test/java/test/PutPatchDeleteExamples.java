package test;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples 
{
	@Test
	public void testPut()
	{		
		JSONObject request= new JSONObject();
		
		request.put("name", "Rahul Suryawanshi");
		request.put("salary", "200001");
		request.put("age", "30");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://dummy.restapiexample.com/api";
		
		given().
			header("content-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/v1/update/24"). 
		then().
			statusCode(200).
			log().all();
		
	}

//	@Test //this method has issue because patch request we dont have on server hence it produces 405 error
	public void testPatch()
	{		
		JSONObject request= new JSONObject();
		
		request.put("name", "Rahul Suryawanshi");
		request.put("salary", "200001");
		request.put("age", "30");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://dummy.restapiexample.com/api";
		
		given().
			header("content-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/v1/update/24"). 
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void testDelete()
	{				
		baseURI="https://dummy.restapiexample.com/api";
		
		when().
			delete("/v1/delete/2"). 
		then().
			statusCode(200).
			log().all();
		
	}
	
}
