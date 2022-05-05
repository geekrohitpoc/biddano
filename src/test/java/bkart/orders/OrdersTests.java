package test.java.bkart.orders;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelpers;
import main.java.helpers.OrderHelpers;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class OrdersTests extends EnvironmentHelpers {
    final String invoice_start_date = "2022-01-01";
    final String invoice_end_date = "2022-02-01";
    final int page_size = 100;
    final String buyer_business_unit = "2698436a-f8c7-47af-802d-a9e62fa8ca89";

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrders() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("page_size",page_size ).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByBusinessUnit() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByUnpickedStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "unpicked" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByPickupPlannedStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "pickup_planned" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByFieldExecutiveAssignedStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "field_executive_assigned" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByPickedUpStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "picked_up" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByPickedUpAttemptedStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "pickup_attempted" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByReceivedAtSortCenterStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "received_at_sort_center" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByAutoHandoverAtShortCenterStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "auto_handover_at_shortcenter_dd").
                queryParam("page_size",page_size ).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByOrderMisplacedAtSortCenterStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "order_misplaced_in_receipt_at_sort_center" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByOrderPartiallyReceivedAtSortCenterStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "order_partially_received_at_sort_center" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByDeliveryPlannedStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "delivery_planned" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByDeliveryAttemptedStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "delivery_attempted" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByDeliveredStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "delivered" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByPartialDeliveredStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "partial_delivered" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByOrderCancelledByBuyerStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "order_cancelled_by_Buyer" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetOrdersByOrderCancelledBySellerStatus() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("Orders.properties", "GET_ORDERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("invoice_date_to", invoice_end_date).
                queryParam("invoice_date_from", invoice_start_date ).
                queryParam("status", "order_cancelled_by_Seller" ).
                queryParam("page_size",page_size ).
                queryParam("buyer_business_unit",buyer_business_unit).
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
        OrderHelpers.validateGetOrdersAPIContract(jsonPathEvaluator);
    }
}
