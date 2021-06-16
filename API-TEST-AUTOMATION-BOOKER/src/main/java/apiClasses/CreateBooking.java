package apiClasses;

import BaseClass.BaseClass;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import variables.Var;

import java.io.IOException;


public class CreateBooking extends Create_Token {
    //WebDriver  webDriver;
    String bookingID;

    public CreateBooking(WebDriver driver)
    {
        super(driver);
    }
    public  void post_CreateBooking_200_Test(String jsonFile) throws IOException {

        RestAssured.baseURI= Var.apiUrl;
        JSONObject jsonObject = BaseClass.readJsonFile(jsonFile);

        Response response = RestAssured.given()

                .contentType("application/json")
                .body(jsonObject.toString())
                .when()
                .post("booking")
                .then()
                .extract().response();
        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();

        bookingID = response.path("bookingid").toString();
    }
    public  void post_CreateBooking_200_Test1()
    {
        System.out.println(response.asString());
    }
    }
