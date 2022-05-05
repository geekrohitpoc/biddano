package test.java.bkart.analytics;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.AnalyticsHelper;
import main.java.helpers.EnvironmentHelpers;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class AnalyticsTests extends EnvironmentHelpers {
    final String business_unit = "2698436a-f8c7-47af-802d-a9e62fa8ca89";

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanVisualizeTheAnalyticsForAllBusinessUnits() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Analytics.properties", "BUYER_SELLER_ANALYTICS_ENDPOINT");
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
        AnalyticsHelper.validateAnalyticsAPIContractForAllBusinessUnits(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanVisualizeTheAnalyticsForSpecificBusinessUnits() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Analytics.properties", "BUYER_SELLER_ANALYTICS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("business_unit", business_unit).
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
        AnalyticsHelper.validateAnalyticsAPIContractForSpecificBusinessUnits(jsonPathEvaluator);
    }
}
