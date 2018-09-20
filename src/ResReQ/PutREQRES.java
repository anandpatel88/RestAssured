package ResReQ;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class PutREQRES
{
	@Test
	public void putStatusCode()
	{
		RestAssured.baseURI="https://reqres.in";
		given().
		contentType("application/json").
		body("{"+
    "\"name\": \"morpheus\","+
    "\"job\": \"zion resident\""+
    "}")
		.when().
		put("/api/users/2").
		then().assertThat().statusCode(200).assertThat().header("Content-Encoding", "gzip");
		
	}
}
