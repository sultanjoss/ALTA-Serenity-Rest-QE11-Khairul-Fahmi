package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import regres.ReqresAPI;
import regres.ReqresResponses;
import utils.Constans;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class POSTloginUNsuccessfull {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login unsuccessfully with invalid json")
    public void loginUNsuccessfullwithinvalidjson(){
        File json = new File(Constans.REQ_BODY +"/LoginUNsuccessfull.json");
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

    @And("Response body is eror {string}")
    public void responseBodyIsEror(String eror) {
        SerenityRest.and().body(ReqresResponses.EROR, equalTo(eror));
    }
}
