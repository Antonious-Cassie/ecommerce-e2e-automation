package apiTest;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test; 
import static org.hamcrest.Matchers.containsString;

public class LoginApiTest {

	
@BeforeClass
public void setup() {
	RestAssured.baseURI = "https://automationexercise.com";
}
	
	
@Test 
public void verifyLoginWithValidDetails() {
	
	given()
	
	.formParam("email", "cass901a@gmail.com")
	.formParam("password", "Password123") 

	.when()
	.post("/api/verifyLogin") 
	
	.then()
	.statusCode(200)
	.body(containsString("\"responseCode\": 200"))
    .body(containsString("\"message\": \"User exists!\""));
	
}


@Test 

public void verifyLoginWithInvalidDetails() {
	
	given()
	
	.formParam("email", "wrong@gmail.com")
	.formParam("password", "Password321")
	
	.when()
	.post("/api/verifyLogin")
	
	.then() 
	.statusCode(200) 
	.body(containsString("\"responseCode\": 404"))
    .body(containsString("\"message\": \"User not found!\""));
	
	
}

@Test 
public void verifyLoginWithoutEmail() {
	
	given()
	
	.formParam("password", "Password123")
	
	.when()
	.post("/api/verifyLogin")
	
	.then()
	.statusCode(200) 
	.body(containsString("\"responseCode\": 400"))
    .body(containsString("\"message\": \"Bad request, email or password parameter is missing in POST request.\""));
	
}




	
}


