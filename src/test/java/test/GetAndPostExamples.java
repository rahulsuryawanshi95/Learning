package test;

//this import should be statically and manualy
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
//this import should be statically and manualy
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExamples 
{
	@Test
	public void testGet()
	{
		baseURI="https://dummy.restapiexample.com";
		
		given().
			get("api/v1/employees").
		then().
			statusCode(200).
			body("data[3].employee_name", equalTo("Cedric Kelly")).
			body("data.employee_name", hasItems("Sonya Frost","Cedric Kelly"));	//one or more items can verify in this method.
	}
	
	@Test
	public void testPost()
	{
		Map<String, Object> map=new HashMap<>();
//		map.put("name", "Rahul Suryawanshi");
//		map.put("salary", "20000");
//		map.put("age", "29");
//		
//		System.out.println(map);
//		
//		JSONObject request= new JSONObject(map);
		
		JSONObject request= new JSONObject();
		
		request.put("name", "Rahul Suryawanshi");
		request.put("salary", "20000");
		request.put("age", "29");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://dummy.restapiexample.com/api";
		
		given().
			header("content-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/v1/create").
		then().
			statusCode(200).
			log().all();
		
	}

}
