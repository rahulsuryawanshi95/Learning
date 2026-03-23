package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestClass1 
{
	@Test(enabled=false)
	public void test1() throws InterruptedException
	{
		Response response=RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getStatusLine());
		System.out.println(response.getContentType());
		System.out.println(response.getSessionId());
		System.out.println(response.getTime());
		System.out.println(response.getClass());
		
	}
	
	public void test2() throws InterruptedException 
	{
		Thread.sleep(3000);
	}

	@Test
	public void test3()
	{
		baseURI="https://dummy.restapiexample.com";
		given().
			get("/api/v1/employees").
		then().
			statusCode(200).
			body("data[0].employee_name", equalTo("Tiger Nixon")).
			log().all();
		
	}

}
