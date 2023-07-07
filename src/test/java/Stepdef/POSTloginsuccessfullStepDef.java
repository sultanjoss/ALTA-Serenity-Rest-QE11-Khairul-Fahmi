package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ja.但し;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import regres.ReqresAPI;
import regres.ReqresResponses;
import utils.Constans;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class POSTloginsuccessfullStepDef {
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
}
