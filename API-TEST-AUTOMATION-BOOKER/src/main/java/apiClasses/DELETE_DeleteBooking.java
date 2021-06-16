package apiClasses;


import org.testng.Assert;
import variables.Var;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DELETE_DeleteBooking extends CreateBooking {

    public DELETE_DeleteBooking(WebDriver driver) {

        super(driver);
    }

    public void delete_DeleteBooking_200_Test() throws IOException {

        post_CreateToken_200_Test("createToken");
        post_CreateBooking_200_Test("createBooking");

        RestAssured.baseURI= Var.apiUrl;


        Response response_UpdateBooking = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token="+token)
                .pathParam("id",bookingID)
                .when()
                .delete("booking/{id}")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();
        System.out.println("Kayıt Silindi");

    }
}
