package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class BulkBuyerTypeHelpers {
    public static void validateGetBulkBuyerTypeContract(JsonPath jsonPath){
        Map bulk_buyer = (Map) jsonPath.getList("$").get(0);
        if(bulk_buyer!=null){
            Assert.assertTrue(bulk_buyer.containsKey("id"));
            Assert.assertTrue(bulk_buyer.containsKey("name"));
        }
    }
}
