import static io.restassured.RestAssured.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Base64;


public class TestApi {

    private String userEmail = "userTest02@example.com";
    private String userPassword = "user02";
    private String expectedUserFullName = "User Test 02";
    private String original;
    private String encodedString;



    @Before
    public void before() {
        RestAssured.baseURI = "https://todo.ly/api";
    }

    @Test
    public void getTest(){
        original = userEmail + ":" + userPassword;
        encodedString = Base64.getEncoder().encodeToString(original.getBytes());
        String authorization = "Basic " + encodedString;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", authorization);
        Response response = httpRequest.get("/user.json");
        int statusCode = response.getStatusCode();
        Assert.assertEquals("Is not was expected", statusCode, 200);
        JsonPath jsonPathEvaluator = response.jsonPath();
        String actualEmail = jsonPathEvaluator.get("Email");
        Assert.assertEquals("Wrong email received in the Response", userEmail, actualEmail);
        String actualPassword = jsonPathEvaluator.get("Password");
        Assert.assertEquals("Wrong password received in the Response", null, actualPassword);
        String actualFullName = jsonPathEvaluator.get("FullName");
        Assert.assertEquals("Wrong password received in the Response", expectedUserFullName, actualFullName);
    }

    @Test
    public void postTest(){
        UserPost userPost = new UserPost("userTest1014@example.com", "user1014", "User TC1014");


        String requestBody = "{\n" +
                "  \"Email\": \"userTest1014@example.com\",\n" +
                "  \"Password\": \"user1014\",\n" +
                "  \"FullName\": \"User TC1014\" \n}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/user.json")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(userPost.getEmail(), response.jsonPath().getString("Email"));
        Assert.assertEquals(null, response.jsonPath().getString("Password"));
        Assert.assertEquals(userPost.getFullName(), response.jsonPath().getString("FullName"));
    }
}
