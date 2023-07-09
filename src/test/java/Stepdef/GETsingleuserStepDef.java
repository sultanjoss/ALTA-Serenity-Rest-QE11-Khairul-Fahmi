package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import regres.ReqresAPI;
import regres.ReqresResponses;
import utils.Constans;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GETsingleuserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //GET Single User
    @Given("Get Single User with valid parameter id {int}")
    public void getSingleUserWithValidParameterPage(int Page) {
        reqresAPI.getSingleUser(Page);
    }

    @When("Send request single user")
    public void sendRequestSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response email {string}")
    public void responseEmail(String Email) {
        SerenityRest.and().body(ReqresResponses.EMAIL, equalTo(Email));
    }

    @And("Response first_name {string}")
    public void responseFirstName(String FirstName) {
        SerenityRest.and().body(ReqresResponses.FIRSTNAME, equalTo(FirstName));
    }

    @And("Response last_name {string}")
    public void responseLastName(String Lastname) {
        SerenityRest.and().body(ReqresResponses.LASTNAME, equalTo(Lastname));
    }

    @And("Response avatar {string}")
    public void responseAvatar(String avatar) {
        SerenityRest.and().body(ReqresResponses.AVATAR, equalTo(avatar));
    }


    //GET Single User Not Found
    @Given("Get single user not found with invalid {}")
    public void getSingleUserNotFound(int id) {
        reqresAPI.getSingleUserNotFound(id);
    }

    @When("Send request single user not found")
    public void sendRequestSingleUserNotFound() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER_NOT_FOUND);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBe(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }

    @And("Validate get single JSON schema")
    public void validateGetSingleJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA +"/GETsingleuserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//GET List Resource
    @Given("Get list resource with valid parameter id {}")
    public void getListResourceWithValidParameterId(int id) {
        reqresAPI.getListResource(id);
    }
    @When("Send request list resource")
    public void sendRequestListResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }
    @And("Response body displays several options {} {} {} {}")
    public void responseBodyShouldBeContainNameYearColorPantone_value(String name, int year, String color, String pantone_value) {
        SerenityRest.then()
                .body(ReqresResponses.NAME_GET_LIST_RESOURCE, equalTo(name))
                .body(ReqresResponses.YEAR, equalTo(year))
                .body(ReqresResponses.COLOR, equalTo(color))
                .body(ReqresResponses.PANTONE_VALUE, equalTo(pantone_value));

    }
    @And("Validate get list resource JSON schema")
    public void validateGetListResourceJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA+"/GETlistresourceSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body displays support url {string}")
    public void responseBodyDisplaysSupportUrl(String url) {
        SerenityRest.and().body(ReqresResponses.SUPPORT_URL, equalTo(url));
    }
//Get single resource not found
    @Given("Get single resource not found with valid id {}")
    public void getSingleResourceNotFoundWithValidId(int id){
            SerenityRest.given().pathParam("id", id);
    }

    @When("Send request single resource not found")
    public void sendRequestSingleResourceNotFound() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }
//GET Delayed
    @Given("Get delayed response {}")
    public void getDelayedResponse(int second) {
        reqresAPI.getDelayed(second);
    }

    @When("Send request get delayed response")
    public void sendRequestGetDelayedResponse() {
        SerenityRest.when().get(ReqresAPI.GET_DELAYED);
    }
}
