package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import regres.ReqresAPI;
import regres.ReqresResponses;
import utils.Constans;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class POSTsuccessfullStepDef {
    @Steps
    ReqresAPI reqresAPI2;

    @Given("Post login successfully with valid json")
    public void postLoginSuccesfully(){
        File json = new File(Constans.REQ_BODY +"/LoginSuccessfull.json");
        reqresAPI2.postLoginSuccessfull(json);
    }
    @When("Send request post login successfully")
    public void sendRequestPostLoginSuccesfully(){
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_SUCCESSFULL);
    }

    @And("Response body {string}")
    public void responseBody(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate post login successfull JSON schema")
    public void validatePostLoginSuccessfullJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA + "/POSTloginSuccessfullSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Post Register successful
    @Given("Post create register with valid json")
    public void Postcreateregisterwithvalidjson() {
        File json = new File(Constans.REQ_BODY + "/RegisterSuccessfull.json");
        reqresAPI2.registerSuccessful(json);
    }

    @When("Send request post register succesfull")
    public void sendRequestPostRegisterSuccesfull() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESSFUL);
    }

    @And("Response body email was {string} and password {string}")
    public void responseBodyEmailWasAndPasword(String email, String password) {
        SerenityRest.and().body(ReqresResponses.EMAIL1, equalTo(email))
                .body(ReqresResponses.PASSWORD, equalTo(password));
    }

    @And("Response body was {} and {}")
    public void responseBodyIdWasAndToken(int id, String token) {
        SerenityRest.and().body(ReqresResponses.ID, equalTo(id)).body(ReqresResponses.TOKEN, equalTo(token));
    }
    @And("Validate post register successfull JSON schema")
    public void validatePostRegisterSuccessfullJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA + "/POSTregistersuccessfullSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//POST Login Successfull in empty email and send password
    @Given("Post login with empty email and send password")
    public void postLoginWithEmptyEmailAndSendPassword() {
        File json = new File(Constans.REQ_BODY + "/LoginwithEmptyEmail.json");
        reqresAPI2.postLoginSuccessfull(json);
    }

    @And("Response body is eror {string}")
    public void responseBodyIsEror(String error) {
        SerenityRest.and().body(ReqresResponses.MISSING_EMAIL_OR_USERNAME,equalTo(error));
    }

    @And("Validate post login successfull JSON schemas")
    public void validatePostLoginSuccessfullJSONSchemas() {
        File json = new File(Constans.JSON_SCHEMA + "/POSTLoginwithEmptyEmailSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//POST Register with empty email and empty password
    @Given("Post register with empty email and empty password in json")
    public void postRegisterWithEmptyEmailAndEmptyPasswordInJson() {
        File json = new File(Constans.REQ_BODY+ "/RegisterwithEmptyemailandpassword.json");
        reqresAPI2.posRegisterwithemptyemailandpassword(json);

    }
    @And("Validate post register unsuccessfull JSON schemas")
    public void validatePostRegisterUnsuccessfullJSONSchemas() {
        File json = new File(Constans.JSON_SCHEMA + "/POSTwithemptyemailandpasswordSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
