package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Reusable
{
	public static JsonPath rawToJson(Response res)
	{
		String s=res.asString();
	  	JsonPath jsp=new JsonPath(s);
	  	return jsp;
	}
	
	public static XmlPath rawToXML(Response res)
	{
		String s=res.asString();
	  	XmlPath xml=new XmlPath(s);
	  	return xml;
	}
	
	public static String generateStringFromResource(String path) throws IOException
	{
		return new  String(Files.readAllBytes(Paths.get(path)));
	}
	///path of the xml

}
