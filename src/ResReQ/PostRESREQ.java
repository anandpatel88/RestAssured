package ResReQ;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import Files.Reusable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRESREQ 
{
	@Test(priority=1)
	public void PostTestStatusCode()
	{
		RestAssured.baseURI="https://reqres.in";
		given().contentType("application/json").
		body("{"+
    "\"name\": \"morpheus\","+
    "\"job\": \"leader\""+
"}").when().
		post("/api/users").then().assertThat().statusCode(201);
	} 
	@Test(priority=2)
	public void PostTestBody()
	{
		RestAssured.baseURI="https://reqres.in";
		Response res=given().contentType("application/json").
		body("{"+
    "\"name\": \"morpheus\","+
    "\"job\": \"leader\""+
"}").when().
		post("/api/users").then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.extract().response();
		JsonPath json=Reusable.rawToJson(res);
		String name=json.get("name");
		String job=json.get("job");
		String id=json.get("id");
		String CDate=json.get("createdAt");
		System.out.println(name);
		System.out.println(id);
		System.out.println(job);
		System.out.println(CDate);
		
	}
}
