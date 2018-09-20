package ResReQ;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class DeleteREQRES 
{
	@Test(priority=1)
	public void PostTestStatusCode()
	{
		RestAssured.baseURI="https://reqres.in";
		given().when().delete("/api/users/2").
		then().assertThat().statusCode(204).and().statusLine("HTTP/1.1 204 No Content");
		
	}

}
