package BooksAPITest;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
public class getBookTest 
{
	@Test
	public void getBooks()
	{
		RestAssured.baseURI="http://fakerestapi.azurewebsites.net";
		Response res=given().
		when().get("/api/Books").then().statusCode(200).and().contentType(ContentType.JSON).
		and().header("Server" , "Microsoft-IIS/10.0").body("size()", equalTo(200)).extract().response();
		String Str=res.asString();
		JsonPath json=new JsonPath(Str);
		int size=json.get("size()");
		for(int i=0;i<size;i++)
		{
			String book=json.get("["+i+"].Title");
			String desc=json.get("["+i+"].Description");
			System.out.println(book);
			System.out.println(desc);
		}
	}

}
