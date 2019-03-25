package getRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAssuredDemo {
	
	@Test
	public void test1()
	{
		RequestSpecification request=RestAssured.given().relaxedHTTPSValidation();
		
		JSONObject json=new JSONObject();
		json.put("address","Rajajinagar, Bangalore");
		json.put("batteryPercentage","68");
		json.put("createdDateTime","1545123673200");
		json.put("latitude","13.011324");
		json.put("logSource","GPS");
		json.put("logTimeAndZone","1538740464774");
		json.put("longitude","77.552675");
		
		
		request.body(json.toJSONString());
		
		int code=RestAssured.given()
		.auth().preemptive()
		.basic("user1","Trak@1234")
		.when()
		.post("https://live.trakeye.com/api/location-logs")
		.getStatusCode();
		
		System.out.println("Response Code from server is "+code);
	}

}
