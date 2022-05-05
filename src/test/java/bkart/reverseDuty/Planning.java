package test.java.bkart.reverseDuty;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.*;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class Planning extends EnvironmentHelpers {
    final String for_single_day = "2022-02-05";
    final String start_date = "2022-02-05";
    final String end_date = "2022-03-05";
    final String business_unit="8e57d9d4-86cc-4ee1-9caf-2a651faf39c9";

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetRevDutyOrdersForSingleDay() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "GET_REVERSE_DUTY_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "rev_duty").
                queryParam("created_at_to", for_single_day ).
                queryParam("created_at_from", for_single_day ).
                queryParam("business_unit",business_unit ).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateGetReverseDutyOrdersContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanCreateDuty() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "CREATE_DUTY_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                body(ReverseDutyHelpers.createBodyForCreateDuty("Automation Create Duty")).
                request("POST", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateCreateDutyContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetRevDutyOrdersForThirtyDays() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "GET_REVERSE_DUTY_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "rev_duty").
                queryParam("created_at_to", end_date ).
                queryParam("created_at_from", start_date ).
                queryParam("business_unit",business_unit ).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateGetReverseDutyOrdersContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetDuties() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "GET_DUTY_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "rev_duty").
                queryParam("created_at_to", end_date ).
                queryParam("created_at_from", start_date ).
                queryParam("business_unit",business_unit ).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateGetDutiesContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetDutiesByAssigned() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "GET_DUTY_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "rev_duty").
                queryParam("created_at_to", end_date ).
                queryParam("status", "assigned" ).
                queryParam("created_at_from", start_date ).
                queryParam("business_unit",business_unit ).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateGetDutiesContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetDutiesByUnassigned() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "GET_DUTY_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "rev_duty").
                queryParam("created_at_to", end_date ).
                queryParam("status", "unassigned" ).
                queryParam("created_at_from", start_date ).
                queryParam("business_unit",business_unit ).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateGetDutiesContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetDutiesByStarted() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "GET_DUTY_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "rev_duty").
                queryParam("created_at_to", end_date ).
                queryParam("status", "started" ).
                queryParam("created_at_from", start_date ).
                queryParam("business_unit",business_unit ).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateGetDutiesContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetDutiesByPendingHandover() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "GET_DUTY_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "rev_duty").
                queryParam("created_at_to", end_date ).
                queryParam("status", "pending_handover" ).
                queryParam("created_at_from", start_date ).
                queryParam("business_unit",business_unit ).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateGetDutiesContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetDutiesByHandoverCompleted() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ReverseDuty.properties", "GET_DUTY_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "rev_duty").
                queryParam("created_at_to", end_date ).
                queryParam("status", "handover_completed" ).
                queryParam("created_at_from", start_date ).
                queryParam("business_unit",business_unit ).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                time(lessThan(5000L)).
                log().all().
                statusCode(200).
                assertThat().
                extract().body();

        JsonPath jsonPathEvaluator = response.jsonPath();
        ReverseDutyHelpers.validateGetDutiesContract(jsonPathEvaluator);
    }
}
