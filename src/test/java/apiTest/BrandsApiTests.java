package apiTest;
import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test; 
import static org.hamcrest.Matchers.containsString;

public class BrandsApiTests {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://automationexercise.com";
	}
	
	@Test
	public void verifyAllBrandsList () {
		
		given() 
		
		.when() 
		.get("/api/brandsList") 
		
		.then() 
		.statusCode(200) 
		.body(containsString("\"responseCode\": 200"))
		.body(containsString("\"brands\""));
		
	}
	
	@Test
	public void verifyPutMethodsNotSupported() {
		
		given() 
		
		.when() 
		.put("/api/brandsList")
		
		.then()
		.statusCode(200) 
		.body(containsString("\"responseCode\": 405"))
		.body(containsString("\"This request method is not supported.\""));
		
	}
	
	
	@Test
	public void verifySpecificBrandExists() {
		
		given() 
		
		
		.when() 
		.get("/api/brandsList") 
		
		.then()
		.statusCode(200) 
		.body(containsString("\"responseCode\": 200"))
	    .body(containsString("H&M"));
		
		
		
	}
	
	
}


	
	