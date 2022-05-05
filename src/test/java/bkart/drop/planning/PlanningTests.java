package test.java.bkart.drop.planning;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.DropOrderHelpers;
import main.java.helpers.EnvironmentHelpers;
import main.java.helpers.ReverseDutyHelpers;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class PlanningTests extends EnvironmentHelpers {
    final String start_date = "2019-02-05";
    final String end_date = "2022-03-05";
    final String business_unit="2698436a-f8c7-47af-802d-a9e62fa8ca89";

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetRevDutyOrdersForSingleDay() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("DropPlanning.properties", "GET_ORDERS_ROUTE_WISE_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("route_type", "deliver").
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
        DropOrderHelpers.validateGetOrdersByRouteContract(jsonPathEvaluator);
    }
}
