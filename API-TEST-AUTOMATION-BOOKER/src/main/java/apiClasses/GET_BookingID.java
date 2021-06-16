package apiClasses;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import variables.Var;

public class GET_BookingID {
    WebDriver webDriver;


    public GET_BookingID(WebDriver driver) { this.webDriver = driver; }
    public  void get_BookingID_200_Test() {

        RestAssured.baseURI= Var.apiUrl;
        Response response = RestAssured.given()
                .when()
                .get("booking")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();
    }
}
