package test.java.bkart.fieldExecutives;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ExecutiveTests extends EnvironmentHelpers {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetFieldExecutivesDetails() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_FIELD_EXECUTIVES_ENDPOINT");
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
        FieldExecutiveHelpers.validategetFieldExecutivesContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetSupervoisorAndFieldExecutive() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_INTERNAL_USERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("role", "supervisor").
                queryParam("user_type", "field_executive").
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
    public void verifyThatUserCanGetBusinessUnits() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_BUSINESS_UNITS_ENDPOINT");
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
        LocationHelpers.validateGetBusinessUnitsContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"}, dependsOnMethods = {"verifyThatAdminCanDeActivateFieldExecutiveProfile"})
    public void verifyThatAdminCanActivateFieldExecutiveProfile() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "ACTIVATE_FIELD_EXECUTIVES_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                body("{\"id\":\"b917c2c0-40a3-47d1-88be-f528921806a9\",\"name\":\"Test Five\",\"business_unit\":\"Pune\",\"vendor\":\"Self\",\"gender\":\"male\",\"is_active\":true,\"supervisor\":\"UdayCandula\"}").
                request("PATCH", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        FieldExecutiveHelpers.validateFieldExecutiveContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatAdminCanDeActivateFieldExecutiveProfile() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "DEACTIVATE_FIELD_EXECUTIVES_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                body("{\"id\":\"b917c2c0-40a3-47d1-88be-f528921806a9\",\"name\":\"Test Five\",\"business_unit\":\"Pune\",\"vendor\":\"Self\",\"gender\":\"male\",\"is_active\":true,\"supervisor\":\"UdayCandula\"}").
                request("PATCH", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        FieldExecutiveHelpers.validateFieldExecutiveContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatAdminCanGetFieldExecutiveProfile() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_FIELD_EXECUTIVE_DETAILS_ENDPOINT");
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
        FieldExecutiveHelpers.validateFieldExecutiveContract(jsonPathEvaluator);
    }

}
