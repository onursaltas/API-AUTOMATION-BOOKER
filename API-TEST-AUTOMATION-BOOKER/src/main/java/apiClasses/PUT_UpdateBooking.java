package apiClasses;

import BaseClass.BaseClass;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import variables.Var;

import java.io.IOException;

public class PUT_UpdateBooking extends CreateBooking {

    public PUT_UpdateBooking(WebDriver driver)
    {
        super(driver);
    }
    public void put_UpdateBooking_200_Test(String jsonFile) throws IOException {

        post_CreateToken_200_Test("createToken");
        post_CreateBooking_200_Test("createBooking");

        RestAssured.baseURI= Var.apiUrl;

        JSONObject jsonObject = BaseClass.readJsonFile(jsonFile);

        Response response_UpdateBooking = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token="+token)
                .body(jsonObject.toString())
                .pathParam("id",bookingID)
                .when()
                .put("booking/{id}")
                .then()
                .extract().response();

        Assert.assertEquals(200, response_UpdateBooking.statusCode());
        response_UpdateBooking.prettyPrint();
    }

}