package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class BulkSellerTypeHelpers {
    public static void validateGetBulkSellerTypeContract(JsonPath jsonPath){
        Map seller_types = (Map) jsonPath.getList("$").get(0);
        if(seller_types!=null){
            Assert.assertTrue(seller_types.containsKey("id"));
            Assert.assertTrue(seller_types.containsKey("name"));
        }

    }
}
