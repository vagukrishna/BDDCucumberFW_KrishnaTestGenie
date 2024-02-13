package org.example.stepDefinitions.API;

import POJO.AddPlace;
import Utilities.TestDataBuilderAPI;
import Utilities.UtilsAPI;
import constants.APIResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.bouncycastle.oer.its.etsi102941.CtlCommand.add;
import static org.testng.AssertJUnit.assertEquals;


public class AddPlaceStepDef extends UtilsAPI {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    Response response;
    TestDataBuilderAPI testDataBuilderAPI=new TestDataBuilderAPI();


    @Given("Add place payload")
    public void add_place_payload() throws IOException {

        HashMap<String,Object> dataMap=new HashMap<>();

        requestSpec=given().spec(requestSpecification()).body(testDataBuilderAPI.addPlacePayLoad());
       // requestSpec=given().spec(requestSpecification()).body();


    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource,String method) {
        responseSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        if(method.equalsIgnoreCase("post")) {
            response = requestSpec.when().post(APIResources.valueOf(resource).getResource()).then().spec(responseSpec).extract().response();
                    }
        else if (method.equalsIgnoreCase("Get")) {
           response=requestSpec.when().get(APIResources.valueOf(resource).getResource()).then().spec(responseSpec).extract().response();

        }

    }
    @Then("the API call is success with {int} Status code")
    public void the_api_call_is_success_with_status_code(int expCode) {

        assertEquals(response.getStatusCode(),expCode);
        System.out.println(expCode);


    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expValue) {

        assertEquals(getJsonPath(response,keyValue),expValue);
        System.out.println(keyValue +"--"+expValue);
    }

    @And("Verify place_id created maps using {string}")
    public void verifyPlace_idCreatedMapsUsing(String resource) throws IOException {

        String place_id=getJsonPath(response,"place_id");
        requestSpec=given().spec(requestSpecification().queryParam("place_id",place_id));
        user_calls_with_http_request(resource,"Get");
        String resp=response.asString();

        System.out.println("resp--"+resp);
        String actualName=getJsonPath(response,"name");
        System.out.println(actualName+"**");
        assertEquals(actualName,testDataBuilderAPI.addPlacePayLoad().getName());


    }
}
