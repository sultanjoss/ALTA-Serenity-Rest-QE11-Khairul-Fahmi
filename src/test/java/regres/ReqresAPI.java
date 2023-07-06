package regres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.Constans;

import java.io.File;
import java.util.prefs.BackingStoreException;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constans.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constans.BASE_URL+"/api/users";

    public static String GET_SINGLE_USER = Constans.BASE_URL+"/api/users/{id}";
    public static String PUT_UPDATE_USER = Constans.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constans.BASE_URL+"/{id}";

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page", page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Get Single User")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Put update user")
    public void putUpdateUser(int id,File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
}


