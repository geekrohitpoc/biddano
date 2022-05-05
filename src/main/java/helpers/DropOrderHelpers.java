package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class DropOrderHelpers {
    public static void validateGetOrdersByRouteContract(JsonPath jsonPath){
        Map total_orders = jsonPath.get("$");
        Assert.assertTrue(total_orders.containsKey("grouped"));
        Assert.assertTrue(total_orders.containsKey("ungrouped"));
        List ungrouped_orders = (List) total_orders.get("ungrouped");
        if(ungrouped_orders.size()!=0){
            Map order = (Map) ungrouped_orders.get(0);
            Map bulk_seller = (Map) order.get("bulk_seller");
            Assert.assertTrue(order.containsKey("bulk_seller"));
            CommonHelpers.validateBulkSeller(bulk_seller);
            Assert.assertTrue(order.containsKey("created_at"));
            Assert.assertTrue(order.containsKey("created_by"));
            Assert.assertTrue(order.containsKey("id"));
            Assert.assertTrue(order.containsKey("invoice_date"));
            Assert.assertTrue(order.containsKey("invoice_image"));
            Assert.assertTrue(order.containsKey("invoice_number"));
            Assert.assertTrue(order.containsKey("mapped_bulk_buyer"));
            Assert.assertTrue(order.containsKey("ordered_package_count"));
            Assert.assertTrue(order.containsKey("payment_type"));
            Assert.assertTrue(order.containsKey("received_signed_pod_at"));
            Assert.assertTrue(order.containsKey("received_signed_pos_at"));
            Assert.assertTrue(order.containsKey("status"));
            Assert.assertTrue(order.containsKey("total_amount_in_rupees"));
            Assert.assertTrue(order.containsKey("unmapped_buyer_address"));
            Assert.assertTrue(order.containsKey("unmapped_buyer_name"));
        }
    }

    public static void validateAddressContract(Map address){
        Assert.assertTrue(address.containsKey("city"));
        Assert.assertTrue(address.containsKey("country"));
        Assert.assertTrue(address.containsKey("id"));
        Assert.assertTrue(address.containsKey("line_1"));
        Assert.assertTrue(address.containsKey("line_2"));
        Assert.assertTrue(address.containsKey("postal_code"));
        Assert.assertTrue(address.containsKey("state"));
    }
}
