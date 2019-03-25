package getRequest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_PutExample 
{

	@Test
	public void test1() throws Exception 
	{
		RequestSpecification request=RestAssured.given().relaxedHTTPSValidation();
		
//		request.header("Content-Type","application/json");
//		request.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE1NTQ2NTI3Mzd9.eBd1r1HGHzKVQ9E69FEpGsSZ125Ar-s2abrwO-3GMMHgQBJ8bBpL0DoxoM654kEkZRcciATFVQtz8sS-DVBHKQ");
//		
		FileInputStream fis = new FileInputStream("E:\\Selenium\\Api.xlsx");
		
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		
		
		DataFormatter formatter = new DataFormatter();
		
		String Address=sheet.getRow(1).getCell(0).getStringCellValue();
		String Percentage=formatter.formatCellValue(sheet.getRow(1).getCell(1));
		System.out.println(Percentage);
		String Ctime=formatter.formatCellValue(sheet.getRow(1).getCell(2));
		System.out.println(Ctime);
		String Lat=formatter.formatCellValue(sheet.getRow(1).getCell(3));
		System.out.println(Lat);
		String Logsrc=formatter.formatCellValue(sheet.getRow(1).getCell(4));
		System.out.println(Logsrc);
		String Ltime=formatter.formatCellValue(sheet.getRow(1).getCell(5));
		System.out.println(Ltime);
		String Lngt=formatter.formatCellValue(sheet.getRow(1).getCell(6));
		System.out.println(Lngt);
		//String Auth=formatter.formatCellValue(sheet.getRow(1).getCell(7));
		System.out.println(Address);
//		int data = (int)sheet.getRow(1).getCell(7).getNumericCellValue();
//		System.out.println(data);
		Thread.sleep(5000);
//		request.header("Content-Type","application/json");
//		request.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE1NTQ2NTI3Mzd9.eBd1r1HGHzKVQ9E69FEpGsSZ125Ar-s2abrwO-3GMMHgQBJ8bBpL0DoxoM654kEkZRcciATFVQtz8sS-DVBHKQ");
////		
		JSONObject json=new JSONObject();
		json.put("address",Address);
		json.put("batteryPercentage",Percentage);
		json.put("createdDateTime","1545123673200");
		json.put("latitude",Lat);
		json.put("logSource",Logsrc);
		json.put("logTimeAndZone","1538740464774");
		json.put("longitude",Lngt);
		
		
		request.body(json.toJSONString());
		
		
		request.header("Content-Type","application/json");
		request.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE1NTQ4MTg2NDd9.atlP5pJTCtqfpFt2nfHuaieGVlMNopu7ImeImFhWYK2aryyudT9ONqE6hJtWdhfX743k1kplgJefErUxaIfA2g");
//			
		Response response=request.post("https://live.trakeye.com/api/location-logs");
		
		int code=response.getStatusCode();
		Assert.assertEquals(code, 201);
		
	
		//request.header("Content-Type","application/json");
		//request.header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE1NTQ2NTI3Mzd9.eBd1r1HGHzKVQ9E69FEpGsSZ125Ar-s2abrwO-3GMMHgQBJ8bBpL0DoxoM654kEkZRcciATFVQtz8sS-DVBHKQ");

//	    Response response=request.post("");	
//		int code=response.getStatusCode();
//		Assert.assertEquals(code, 201);

		//json.keySet().clear();
		
		
		
        //Boolean bol = json.isEmpty();
		
		//System.out.println(bol);
		
		
	
	}
}
