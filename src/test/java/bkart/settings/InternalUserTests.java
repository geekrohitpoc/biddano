package test.java.bkart.settings;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelpers;
import main.java.helpers.InternalUserHelper;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class InternalUserTests extends EnvironmentHelpers {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetInternalUsers() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_INTERNAL_USERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("user_type", "internal").
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        InternalUserHelper.validateGetInternalUserContract(jsonPathEvaluator);
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetRoles() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_ROLES_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        InternalUserHelper.validateGetRoleContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatAdminCanDeactivateUser() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "DEACTIVATE_USER_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                body("{\"id\":\"c7a7d5af-b86c-43bd-b083-2ceaba085174\",\"role\":1,\"is_active\":false}").
                request("PATCH", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        InternalUserHelper.validateUserDeActivationContract(jsonPathEvaluator);
    }


    @Test(groups = {"sanity", "regression"}, dependsOnMethods = {"verifyThatAdminCanDeactivateUser"})
    public void verifyThatAdminCanActivateUser() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "ACTIVATE_USER_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                body("{\"id\":\"c7a7d5af-b86c-43bd-b083-2ceaba085174\",\"role\":1,\"is_active\":true}").
                request("PATCH", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        InternalUserHelper.validateUserActivationContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatAdminCanGetActivatedUser() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_INTERNAL_USERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("is_active", true).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        InternalUserHelper.validateGetInternalUserContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatAdminCanGetDeActivatedUser() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_INTERNAL_USERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("is_active", false).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        InternalUserHelper.validateGetInternalUserContract(jsonPathEvaluator);
    }
}
