package test.java.bkart.settings;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.BulkSellerTypeHelpers;
import main.java.helpers.EnvironmentHelpers;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BulkSellerTypeTests extends EnvironmentHelpers {
    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetBulkSellerTypes() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Settings.properties", "GET_BULK_SELLER_TYPES_ENDPOINT");
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
        BulkSellerTypeHelpers.validateGetBulkSellerTypeContract(jsonPathEvaluator);
    }
}
