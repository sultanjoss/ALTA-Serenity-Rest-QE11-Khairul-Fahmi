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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;
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
     SerenityRest.and().body(ReqresResponses.Page,equalTo(page));
    }

    //Post crate new user
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constans.REQ_BODY +"/User.json");
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
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

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
        SerenityRest.and().body(ReqresResponses.EMAIL,equalTo(Email));
    }

    @And("Response first_name {string}")
    public void responseFirstName(String FirstName) {
        SerenityRest.and().body(ReqresResponses.FIRSTNAME,equalTo(FirstName));
    }

    @And("Response last_name {string}")
    public void responseLastName(String Lastname) {
        SerenityRest.and().body(ReqresResponses.LASTNAME,equalTo(Lastname));
    }

    @And("Response avatar {string}")
    public void responseAvatar(String avatar) {
        SerenityRest.and().body(ReqresResponses.AVATAR,equalTo(avatar));
    }
//put update user
    @Given("Put update user with valid id {int} and json")
    public void putUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constans.REQ_BODY+"/UpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send request user with valid id and json")
    public void sendRequestUserWithValidIdAndJson() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
//Delete User
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
