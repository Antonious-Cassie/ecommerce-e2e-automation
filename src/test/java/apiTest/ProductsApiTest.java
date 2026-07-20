package apiTest;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test; 
import static org.hamcrest.Matchers.containsString;

public class ProductsApiTest {

	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://automationexercise.com";
	}
	
	@Test
	public void verifyAllProductsList() {
		
		given() 
		
		.when() 
		.get("/api/productsList")
		 
		.then() 
		.statusCode(200)
		.body(containsString("\"responseCode\": 200"))
		.body(containsString("\"products\""));
	  
		
		
		
	} 
	
	@Test 
	public void verifyPostToAllProductsList() {
		
		 given()
		 
		 .when()
		 .post("/api/productsList")
			 
		 .then() 
		 .statusCode(200)
		 .body(containsString("\"responseCode\": 405"))
		 .body(containsString("\"This request method is not supported.\""));
		  
	}
	
	@Test
	public void verifyToIndividuallySearchProducts () {
		
		given() 
		.formParam("search_product", "Jeans")
		
		.when()
		.post("/api/searchProduct")
		
		.then()
		.statusCode(200)
		.body(containsString("\"responseCode\": 200"))
		.body(containsString("\"products\""));
		
	}

	@Test
	public void searchProductWithoutSearchProductParameter () {
		
		given()
				
		.when()
		.post("/api/searchProduct") 
		
		.then() 
		.statusCode(200) 
		.body(containsString("\"responseCode\": 400"))
		.body(containsString("\"Bad request, search_product parameter is missing in POST request.\""));
		
		
		
	}
	
	

}
	
	
	
	
	

