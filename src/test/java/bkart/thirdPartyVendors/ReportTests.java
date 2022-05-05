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

public class ReportTests extends EnvironmentHelpers {
    final String start_date = "2021-01-01";
    final String end_date = "2022-02-01";
    final String business_unit = "2698436a-f8c7-47af-802d-a9e62fa8ca89";
    final String seller = "82116854-5bfa-4b59-952b-bf1d1b33e145";
    final String vendor = "3c9678c1-ac88-47a1-ba5e-e6a52c6e2133";
    final String field_executive = "54b9f915-0572-4454-b6b8-4bca1eccbf9d";

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetReports() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "GET_3PL_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("sd", start_date).
                queryParam("ed", end_date).
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
        ThirdPartyVendorHelpers.validate3plReportContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetReportsFilterByBusinessUnit() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "GET_3PL_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("sd", start_date).
                queryParam("ed", end_date).
                queryParam("bu", business_unit).
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
        ThirdPartyVendorHelpers.validate3plReportContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetReportsFilterBySeller() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "GET_3PL_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("sd", start_date).
                queryParam("ed", end_date).
                queryParam("seller", seller).
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
        ThirdPartyVendorHelpers.validate3plReportContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetReportsFilterByVendor() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "GET_3PL_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("sd", start_date).
                queryParam("ed", end_date).
                queryParam("vendor", vendor).
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
        ThirdPartyVendorHelpers.validate3plReportContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetReportsFilterByFieldExecutive() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ThirdPartyVendors.properties", "GET_3PL_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("sd", start_date).
                queryParam("ed", end_date).
                queryParam("fe", field_executive).
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
        ThirdPartyVendorHelpers.validate3plReportContract(jsonPathEvaluator);
    }

}
