package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class OrderHelpers {

    public static void validateGetOrdersAPIContract(JsonPath jsonPath){
        Map orders = (Map) jsonPath.getMap("$");
        int count = jsonPath.getInt("count");
        Assert.assertTrue(orders.containsKey("count"));
        Assert.assertTrue(orders.containsKey("next"));
        Assert.assertTrue(orders.containsKey("previous"));
        Assert.assertTrue(orders.containsKey("results"));
        List resultList = (List) orders.get("results");
        if(resultList.size()!=0 && count !=0){
            Map result = (Map) resultList.get(0);
            Assert.assertTrue(result.containsKey("id"));
            Assert.assertTrue(result.containsKey("invoice_number"));
            Assert.assertTrue(result.containsKey("invoice_date"));
            Assert.assertTrue(result.containsKey("payment_type"));
            Assert.assertTrue(result.containsKey("status"));
            Assert.assertTrue(result.containsKey("bulk_seller"));
            Assert.assertTrue(result.containsKey("mapped_bulk_buyer"));
            Assert.assertTrue(result.containsKey("mapped_bulk_buyer_id"));
            Assert.assertTrue(result.containsKey("mapped_bulk_buyer_address"));
            Assert.assertTrue(result.containsKey("total_amount_in_rupees"));
            Assert.assertTrue(result.containsKey("created_by"));
            Assert.assertTrue(result.containsKey("created_at"));
            Assert.assertTrue(result.containsKey("order_source"));
            Assert.assertTrue(result.containsKey("order_by"));
            Assert.assertTrue(result.containsKey("sales_duty_stop"));
        }else{
            System.out.println("No Results Found for this combination");
        }
    }
}
