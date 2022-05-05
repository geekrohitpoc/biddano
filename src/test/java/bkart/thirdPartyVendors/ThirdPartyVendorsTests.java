package test.java.bkart.thirdPartyVendors;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelpers;
import main.java.helpers.ThirdPartyVendorHelpers;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ThirdPartyVendorsTests extends EnvironmentHelpers {
    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetVendorsList() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "GET_VENDORS_LIST_ENDPOINT");
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
        ThirdPartyVendorHelpers.validateGetVendorContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetBusinessUnits() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "GET_BUSINESS_UNIT_LIST_ENDPOINT");
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
        ThirdPartyVendorHelpers.validateGetBusinessUnitContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetVendorUsers() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "GET_USERS_LIST_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("user_type", "vendor").
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
        ThirdPartyVendorHelpers.validateGetVendorUsersContract(jsonPathEvaluator);
    }


    @Test(groups = {"sanity", "regression"}, dependsOnMethods = {"verifyThatUserCanDeActivateVendors"})
    public void verifyThatUserCanActivateVendors() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "ACTIVATE_VENDOR_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("user_type", "vendor").
                log().ifValidationFails().
                body("{\"vendor_id\":\"44b544f7-64fe-491c-b735-5014a67a31fe\",\"id\":\"21219947-b9aa-4ec2-9240-6b642fb9ec5a\",\"is_active\":true,\"phone_number\":\"+919876543211\",\"role\":1,\"user_type\":\"vendor\"}").
                when().
                request("PATCH", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ThirdPartyVendorHelpers.validateActivateVendorContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanDeActivateVendors() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "DEACTIVATE_VENDOR_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("user_type", "vendor").
                log().ifValidationFails().
                body("{\"vendor_id\":\"44b544f7-64fe-491c-b735-5014a67a31fe\",\"id\":\"21219947-b9aa-4ec2-9240-6b642fb9ec5a\",\"is_active\":false,\"phone_number\":\"+919876543211\",\"role\":1,\"user_type\":\"vendor\"}").
                when().
                request("PATCH", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ThirdPartyVendorHelpers.validateDeActivateVendorContract(jsonPathEvaluator);
    }
}
