package apiClasses;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import variables.Var;

public class GET_BookingDetails {
    WebDriver webDriver;


    public GET_BookingDetails(WebDriver driver)
    {
        this.webDriver = driver;
    }
    public  void get_BookingDetails_200_Test() {

        RestAssured.baseURI= Var.apiUrl;

        Response response = RestAssured.given()
                .contentType("application/json")
                .when()
                .get("booking/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();


    }
}
