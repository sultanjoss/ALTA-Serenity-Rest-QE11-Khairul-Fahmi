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

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Get List User
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page value should be {int}")
    public void responseBodyPageValueShouldBePage(int page) {
        SerenityRest.and().body(ReqresResponses.Page, equalTo(page));
    }

    @And("Validate get list user JSON schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA + "/ListUsersSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Get log all")
    public void getLogAll() {
        SerenityRest.and().log().all();
    }

    @And("Get log body")
    public void getLogBody() {
        SerenityRest.and().log().body();
    }
    @And("Print if status code {int} ok")
    public void printIfStatusCodeOk(int ok) {
        SerenityRest.and().log().ifStatusCodeIsEqualTo(ok);
    }


    //Post crate new user
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constans.REQ_BODY + "/User.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }
    @And("Validate post create JSON schema")
    public void validatePostCreateJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA + "/POSTcreateSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
