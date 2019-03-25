package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;

public class GetData {
	
	@Test
	public void testResponsecode() 
	{
//		ProxySpecification ps = ProxySpecification.host("").withPort(8080).withAuth("username",
//			    "password");

		Response resp= RestAssured.given().relaxedHTTPSValidation().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		
		int code=resp.getStatusCode();
		
		String data=resp.asString();
		
		System.out.println("Status code is "+code);
		
		System.out.println("Data is "+data);
		
		System.out.println("Response time "+resp.getTime());
		
		//Assert.assertEquals(code, 200);
	}

}
