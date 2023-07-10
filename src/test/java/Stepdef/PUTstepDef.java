package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import regres.ReqresAPI;
import utils.Constans;

import java.io.File;

public class PUTstepDef {
    @Steps
    ReqresAPI reqresAPI;


    //put update user
    @Given("Put update user with valid id {} and json")
    public void putUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constans.REQ_BODY + "/PUTUpdateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request user with valid id and json")
    public void sendRequestUserWithValidIdAndJson() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Validate put update JSON schema")
    public void validatePutUpdateJSONSchema() {
        File json = new File(Constans.JSON_SCHEMA +"/PUTupdateSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//PUT Update Negative Case
    @Given("Put update user with invalid id {int} and json")
    public void putUpdateUserWithInvalidIdAndJson(int id) {
        File json = new File(Constans.REQ_BODY + "/PUTUpdateinvalidUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request user with invalid id and json")
    public void sendRequestUserWithInvalidIdAndJson() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
}
