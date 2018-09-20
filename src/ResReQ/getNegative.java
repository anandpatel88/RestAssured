package ResReQ;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getNegative
{
	
	@Test
	public void getAllFirstName()
	{
	   RestAssured.baseURI="https://reqres.in";
	  Response res=given().
	   when().get("/api/users/23").
	   then().assertThat().statusCode(404).extract().response();
	 
	  	
}
}


