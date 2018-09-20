package Customised;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostAndDeleteCustomised 
{
	@Test
	public static void createAndDeletePlace()
	{
		String b="{"+
			    "\"location\":{"+
		         "\"lat\" : -38.383494,"+
		         "\"lng\" : 33.427362"+
		     "},"+
		     "\"accuracy\":50,"+
		     "\"name\": \"Frontline house\","+
		     "\"phone_number\":\"(+91) 983 893 3937\","+
		    "\"address\" : \"29, side layout, cohen 09\","+
		     "\"types\": [\"shoe park\",\"shop\"],"+
		     "\"website\" : \"http://google.com\","+
		     "\"language\" : \"French-IN\""+
		 "}";
		 RestAssured.baseURI="http://216.10.245.166";
			Response s=given().
			       queryParam("key","qaclick123").
			       body(b).
			 when().
			       post("/maps/api/place/add/json").
			 then().
			       assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("OK")).
			 extract().response();
			
			String resp=s.asString();
			JsonPath jsonpath=new JsonPath(resp);
			System.out.println(resp);
			String placeIdValue=jsonpath.get("place_id");
			System.out.println(placeIdValue);
			
			given().
				queryParam("key","qaclick123").
				body("{"+
    "\"place_id\":\""+placeIdValue+"\""+
"}"+
"").
				when().
				post("/maps/api/place/delete/json").andReturn().
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("OK"));
	}
		

}
