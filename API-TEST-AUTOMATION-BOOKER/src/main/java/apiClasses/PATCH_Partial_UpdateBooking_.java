package apiClasses;

import BaseClass.BaseClass;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import variables.Var;

import java.io.IOException;

public class PATCH_Partial_UpdateBooking_ extends CreateBooking {

    public PATCH_Partial_UpdateBooking_(WebDriver driver)
    {

        super(driver);
    }
    public void patch_PartialUpdateBooking_Test(String jsonFile) throws IOException {

        post_CreateToken_200_Test("createToken");
        post_CreateBooking_200_Test("createBooking");

        RestAssured.baseURI= Var.apiUrl;

        JSONObject jsonObject = BaseClass.readJsonFile(jsonFile);

        Response response_PatchBooking = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token="+token)
                .body(jsonObject.toString())
                .pathParam("id",bookingID)
                .when()
                .patch("booking/{id}")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();
    }

}
