package regres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.Constans;

import java.io.File;
import java.util.prefs.BackingStoreException;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constans.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constans.BASE_URL+"/api/users/id";

    public static String GET_SINGLE_USER = Constans.BASE_URL+"/api/users/{id}";
    public static String PUT_UPDATE_USER = Constans.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constans.BASE_URL+"/api/users/{id}";

    public static String POST_REGISTER_SUCCESSFUL = Constans.BASE_URL+"/api/register";
    public static String GET_SINGLE_USER_NOT_FOUND = Constans.BASE_URL+"/api/users/{id}";
    @Step("Get single user not found")
    public void getSingleUserNotFound(int id){
        SerenityRest.given().pathParam("id", id);
    }
    public static String POST_LOGIN_SUCCESSFULL = Constans.BASE_URL+"/api/login";
    @Step("Post login successfull")
    public void postLoginSuccessfull(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    public static String POST_LOGIN_UNSUCCESSFULL = Constans.BASE_URL+"/api/login";

    @Step("Post login unsuccessfull")
    public void postLoginUnsuccessfull(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

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

    @Step("Post register successful")
    public void registerSuccessful(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}


