package test.java.bkart.dashboard;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.DashboardHelpers;
import main.java.helpers.EnvironmentHelpers;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DashboardTests extends EnvironmentHelpers {
    final String business_unit = "8e57d9d4-86cc-4ee1-9caf-2a651faf39c9";

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanVisualizeTheDataOnDashboardForLastSevenDays() throws IOException {
        final String start_date = "2022-02-03";
        final String end_Date = "2022-02-09";
        String ENDPOINT = UtilsHelpers.getProperties("Dashboard.properties", "GET_CHAT_DATA_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                queryParam("start_date", start_date ).
                queryParam("end_date", end_Date ).
                queryParam("business_unit", business_unit).
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
        DashboardHelpers.validateDasboardAPIContract(jsonPathEvaluator, 7);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanVisualizeTheDataOnDashboardForLastFifteenDays() throws IOException {
        final String start_date = "2022-01-26";
        final String end_Date = "2022-02-09";
        String ENDPOINT = UtilsHelpers.getProperties("Dashboard.properties", "GET_CHAT_DATA_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                queryParam("start_date", start_date ).
                queryParam("end_date", end_Date ).
                queryParam("business_unit", business_unit).
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                log().ifValidationFails().
                time(lessThan(5000L)).
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        DashboardHelpers.validateDasboardAPIContract(jsonPathEvaluator, 15);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanVisualizeTheDataOnDashboardForLastThirtyDays() throws IOException {
        final String start_date = "2022-01-11";
        final String end_Date = "2022-02-09";
        String ENDPOINT = UtilsHelpers.getProperties("Dashboard.properties", "GET_CHAT_DATA_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                queryParam("start_date", start_date ).
                queryParam("end_date", end_Date ).
                queryParam("business_unit", business_unit).
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                log().ifValidationFails().
                time(lessThan(5000L)).
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        DashboardHelpers.validateDasboardAPIContract(jsonPathEvaluator, 30);
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanVisualizeTheDataOnDashboardForLastSixtyDays() throws IOException {
        final String start_date = "2021-12-12";
        final String end_Date = "2022-02-09";
        String ENDPOINT = UtilsHelpers.getProperties("Dashboard.properties", "GET_CHAT_DATA_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                queryParam("start_date", start_date ).
                queryParam("end_date", end_Date ).
                queryParam("business_unit", business_unit).
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                log().ifValidationFails().
                time(lessThan(5000L)).
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        DashboardHelpers.validateDasboardAPIContract(jsonPathEvaluator, 60);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanVisualizeTheDataOnDashboardForCustomDays() throws IOException {
        final String start_date = "2022-02-06";
        final String end_Date = "2022-02-09";
        String ENDPOINT = UtilsHelpers.getProperties("Dashboard.properties", "GET_CHAT_DATA_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                queryParam("start_date", start_date ).
                queryParam("end_date", end_Date ).
                queryParam("business_unit", business_unit).
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                log().all().
                time(lessThan(5000L)).
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        DashboardHelpers.validateDasboardAPIContract(jsonPathEvaluator, 4);
    }
}
