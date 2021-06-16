package apiClasses;

import BaseClass.BaseClass;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import variables.Var;

import java.io.IOException;


public class Create_Token extends BaseClass {
    String token;
    Response response;

    public Create_Token(WebDriver driver)
    {
        super(driver);
    }
    public  void post_CreateToken_200_Test(String jsonFile) throws IOException {

        RestAssured.baseURI= Var.apiUrl;

        JSONObject jsonObject = BaseClass.readJsonFile(jsonFile);

        response = RestAssured.given()

         .contentType("application/json")
         .body(jsonObject.toString())
         .when()
         .post("auth")
         .then()
        .extract().response();

        token = response.path("token").toString();
        Assert.assertEquals(200, response.statusCode());
        String Output=response.asString();
        io.restassured.path.json.JsonPath js=new io.restassured.path.json.JsonPath(Output);
        String OutputToken=js.get("token");
        token = OutputToken;
        response.prettyPrint();
    }

}