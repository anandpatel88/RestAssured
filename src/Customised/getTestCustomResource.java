package Customised;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Files.Resource;

public class getTestCustomResource
{
	String url;
	String key;
	@BeforeTest
	public void pre() throws Exception
	{
		File f=new File("C:\\Users\\anand.mohan.patel\\workspace2\\DemoProject\\src\\Files\\env.properties");
		FileInputStream fis=new FileInputStream(f);
		Properties prop =new Properties();
		prop.load(fis);
	    url=prop.get("hostGet").toString();
	    System.out.println(url);
	    key=prop.get("keyGet").toString();
	    System.out.println(key);
	}
    @Test
	public void googleMapGet()
	{
		RestAssured.baseURI=url;
		given().
		        param("location","-33.8670522,151.1957362").
		        param("radius","500").
		        param("key",key).
		  when().
		  get(Resource.getRes()).
		  then().assertThat().
		  statusCode(200).and().body("results[0].name",equalTo("Sydney")).
		  and().body("results[0].id",equalTo("044785c67d3ee62545861361f8173af6c02f4fae")).
		  and().header("Server", "scaffolding on HTTPServer2").and().contentType(ContentType.JSON);
		
	}
}
