import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class getTest
{
    @Test
	public void googleMapGet()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		given().
		        param("location","-33.8670522,151.1957362").
		        param("radius","500").
		        param("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
		  when().
		  get("/maps/api/place/nearbysearch/json").
		  then().assertThat().
		  statusCode(200).and().body("results[0].name",equalTo("Sydney")).
		  and().body("results[0].id",equalTo("044785c67d3ee62545861361f8173af6c02f4fae")).
		  and().header("Server", "scaffolding on HTTPServer2").and().contentType(ContentType.JSON);
		
	}
}
