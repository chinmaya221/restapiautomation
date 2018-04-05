package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.services.Service;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {

	public static Service service;
	public static Properties prop;
	public static XmlPath rawToXML(Response res)
	{
		String response=res.asString();
		XmlPath xml = new XmlPath(response);
		return xml;
		
	}
	
	public static JsonPath rawToJson(Response res)
	{
		String response=res.asString();
		JsonPath js = new JsonPath(response);
		return js;
		
	}
	
	public static String jsonToString(Object obj)
			throws JsonProcessingException {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonString = mapperObj.writeValueAsString(obj);
		return jsonString;
	}
	
	public static String getPropData(String key)throws Exception
	{
		FileInputStream fin = new FileInputStream(new File("./src/main/java/utils/env.properties"));
		prop= new Properties();
		prop.load(fin);
		String value=prop.getProperty(key);
		return value;
	}
	
}
