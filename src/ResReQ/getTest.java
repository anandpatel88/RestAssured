package ResReQ;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import Files.Reusable;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class getTest {

@Test(priority=1)
public void getTest1()
{
   RestAssured.baseURI="https://reqres.in";
  Headers head= given().
   queryParam("page", "2").
   when().get("/api/users").
   then().assertThat().statusCode(200).extract().headers();
  	Header s= head.get("Server");
  	System.out.println(s.toString());   
}
@Test(priority=2)
public void getTestDetails()
{
   RestAssured.baseURI="https://reqres.in";
  Response res=given().
   queryParam("page", "2").
   when().get("/api/users").
   then().assertThat().statusCode(200).extract().response();
  	String s=res.asString();
  	JsonPath jsp=new JsonPath(s);
  	int pageNumber=jsp.get("page");
  	int tptalPage=jsp.get("total");
  	System.out.println(pageNumber);
  	System.out.println(tptalPage);
}

@Test
public void getAllFirstName()
{
   RestAssured.baseURI="https://reqres.in";
  Response res=given().
   queryParam("page", "2").
   when().get("/api/users").
   then().assertThat().statusCode(200).extract().response();
  	JsonPath jsp=Reusable.rawToJson(res);
  	int size=jsp.get("data.size()");
  	for(int i=0;i<size;i++)
  	{
 
  		int id=jsp.get("data["+i+"].id");
  		System.out.println(id);
  		String fName=jsp.get("data["+i+"].first_name");
  		System.out.println(fName);
  	
  					
  	} 	
}

}
