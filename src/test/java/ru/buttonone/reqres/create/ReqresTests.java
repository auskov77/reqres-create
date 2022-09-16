package ru.buttonone.reqres.create;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.buttonone.domain.User;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("From API Reqres should")
public class ReqresTests {
    public static final String BASE_URI = "https://reqres.in/api";
    public static final String USERS = "/users";
    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";
    public static final String DELAYED_RESPONSE = "/users?delay=3";
    public static final int USERS_2 = 2;
    public static final int STATUS_CODE_POST_200 = 200;
    public static final int STATUS_CODE_POST_201 = 201;
    public static final int STATUS_CODE_POST_204 = 204;
    public static final int STATUS_CODE_POST_300 = 300;
    public static final int STATUS_CODE_POST_400 = 400;
    private static final String requestBodyPostUser = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";
    private static final String requestBodyPutUser = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"zion resident\"\n" +
            "}";
    private static final String requestBodyPatchUser = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";
    private static final String requestBodyPostRegisterSuccessful = "{\n" +
            "    \"email\": \"eve.holt@reqres.in\",\n" +
            "    \"password\": \"pistol\"\n" +
            "}";
    private static final String requestBodyPostRegisterUnsuccessful = "{\n" +
            "    \"email\": \"sydney@fife\"\n" +
            "}";
    private static final String requestBodyPostLoginSuccessful = "{\n" +
            "    \"email\": \"eve.holt@reqres.in\",\n" +
            "    \"password\": \"cityslicka\"\n" +
            "}";
    private static final String requestBodyPostLoginUnsuccessful = "{\n" +
            "    \"email\": \"peter@klaven\"\n" +
            "}";


    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = BASE_URI;
    }

    @DisplayName(" correct post user")
    @Test
    public void shouldHaveCorrectPostUser() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostUser)
                .when()
                .post(USERS)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_201)
                ;
    }

    @DisplayName(" in correct post user")
    @Test
    public void shouldHaveInCorrectPostUser() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostUser)
                .when()
                .post(USERS)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_300)
                ;
    }

    @DisplayName(" correct put user")
    @Test
    public void shouldHaveCorrectPutUser(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPutUser)
                .when()
                .put(USERS + "/" + USERS_2)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_200)
                ;
    }

    @DisplayName(" in correct put user")
    @Test
    public void shouldHaveInCorrectPutUser(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPutUser)
                .when()
                .put(USERS + "/" + USERS_2)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_201)
                ;
    }

    @DisplayName(" correct patch user")
    @Test
    public void shouldHaveCorrectPatchUser(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPatchUser)
                .when()
                .put(USERS + "/" + USERS_2)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_200)
                ;
    }

    @DisplayName(" in correct patch user")
    @Test
    public void shouldHaveInCorrectPatchUser(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPatchUser)
                .when()
                .put(USERS + "/" + USERS_2)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_201)
                ;
    }

    @DisplayName(" correct delete user")
    @Test
    public void shouldHaveCorrectDeleteUser(){
        given()
                .when()
                .delete(USERS + "/" + USERS_2)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_204)
                ;
    }

    @DisplayName(" in correct delete user")
    @Test
    public void shouldHaveInCorrectDeleteUser(){
        given()
                .when()
                .delete(USERS + "/" + USERS_2)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_200)
                ;
    }

    @DisplayName(" correct post register")
    @Test
    public void shouldHaveCorrectPostRegisterSuccessful(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostRegisterSuccessful)
                .when()
                .post(REGISTER)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_200)
                ;
    }

    @DisplayName(" in correct post register")
    @Test
    public void shouldHaveInCorrectPostRegisterSuccessful(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostRegisterSuccessful)
                .when()
                .post(REGISTER)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_201)
                ;
    }

    @DisplayName(" correct post register unsuccessful")
    @Test
    public void shouldHaveCorrectPostRegisterUnsuccessful(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostRegisterUnsuccessful)
                .when()
                .post(REGISTER)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_400)
                ;
    }

    @DisplayName(" in correct post register unsuccessful")
    @Test
    public void shouldHaveInCorrectPostRegisterUnsuccessful(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostRegisterUnsuccessful)
                .when()
                .post(REGISTER)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_201)
                ;
    }

    @DisplayName(" correct post login successful")
    @Test
    public void shouldHaveCorrectPostLoginSuccessful(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostLoginSuccessful)
                .when()
                .post(LOGIN)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_200)
                ;
    }

    @DisplayName(" in correct post login successful")
    @Test
    public void shouldHaveInCorrectPostLoginSuccessful(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostLoginSuccessful)
                .when()
                .post(LOGIN)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_201)
                ;
    }

    @DisplayName(" correct post login unsuccessful")
    @Test
    public void shouldHaveCorrectPostLoginUnsuccessful(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostLoginUnsuccessful)
                .when()
                .post(LOGIN)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_400)
        ;
    }

    @DisplayName(" in correct post login unsuccessful")
    @Test
    public void shouldHaveInCorrectPostLoginUnsuccessful(){
        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyPostLoginUnsuccessful)
                .when()
                .post(LOGIN)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_200)
        ;
    }

    @DisplayName(" correct get delayed response")
    @Test
    public void shouldHaveCorrectGetDelayedResponse(){
        ValidatableResponse validatableResponse = given()
                .when()
                .get(DELAYED_RESPONSE)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_200);
        List<User> userList = validatableResponse
                .extract()
                .body()
                .jsonPath().getList("data", User.class);
        assertThat(userList, Matchers.containsInAnyOrder(
                new User(1, "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg"),
                new User(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg"),
                new User(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg"),
                new User(4, "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg"),
                new User(5, "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg"),
                new User(6, "tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg")
        ));
    }

    @DisplayName(" in correct get delayed response")
    @Test
    public void shouldHaveInCorrectGetDelayedResponse(){
        ValidatableResponse validatableResponse = given()
                .when()
                .get(DELAYED_RESPONSE)
                .then()
                .log().all()
                .statusCode(STATUS_CODE_POST_201);
        List<User> userList = validatableResponse
                .extract()
                .body()
                .jsonPath().getList("data", User.class);
        assertThat(userList, Matchers.containsInAnyOrder(
                new User(1, "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg"),
                new User(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg"),
                new User(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg"),
                new User(4, "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg"),
                new User(5, "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg"),
                new User(6, "tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg")
        ));
    }

}
