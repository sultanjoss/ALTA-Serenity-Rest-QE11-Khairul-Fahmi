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
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class POSTUNsuccessfull {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login unsuccessfully with invalid json")
    public void loginUNsuccessfullwithinvalidjson() {
        File json = new File(Constans.REQ_BODY + "/LoginUNsuccessfull.json");
        reqresAPI.postLoginUnsuccessfull(json);
    }

    @When("Send request post login unsuccessfully")
    public void sendRequestPostLoginUnsuccessfully() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_UNSUCCESSFULL);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @And("Response body is {string}")
    public void responseBodyIsEror(String eror) {
        SerenityRest.then().body(ReqresResponses.MISSING_PASSWORD, equalTo(eror));
    }

    @And("Validate post login unsuccessfull JSON schema")
    public void validatePostLoginUnsuccessfullJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA + "/POSTloginUNSuccessfullSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //POST REGISTER UNSUCCESSFULL
    @Given("Post register with valid email and empty password")
    public void postRegisterWithValidEmailAndEmptyPassword() {
        File json = new File(Constans.REQ_BODY + "/RegisterUNsuccessfull.json");
        reqresAPI.postRegisterUnssuccesfull(json);
    }

    @When("Send request register unsuccessfull")
    public void sendRequestRegisterUnsuccessfull() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_UNSSUCCESSFULL);
    }

    @And("Responses body is {string}")
    public void responsesBodyIs(String error) {
        SerenityRest.and().body(ReqresResponses.MISSING_PASSWORD, equalTo(error));
    }

    @And("Validate post register unsuccessfull JSON schema")
    public void validatePostRegisterUnsuccessfullJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA + "/POSTregisterUnsuccessfullSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
