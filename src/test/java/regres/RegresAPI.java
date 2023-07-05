package regres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.Constans;

import java.io.File;

public class RegresAPI {
    public static String GET_LIST_USERS = Constans.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constans.BASE_URL+"/api/users";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page", page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}


