package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class VendorHelpers {
    public static void validateGetVendorsContract(JsonPath jsonPath){
        Map vendor = (Map) jsonPath.getList("$").get(0);
        if(vendor!=null){
            Assert.assertTrue(vendor.containsKey("alias"));
            Assert.assertTrue(vendor.containsKey("contact_numbers"));
            Assert.assertTrue(vendor.containsKey("created_at"));
            Assert.assertTrue(vendor.containsKey("email"));
            Assert.assertTrue(vendor.containsKey("id"));
            Assert.assertTrue(vendor.containsKey("is_active"));
            Assert.assertTrue(vendor.containsKey("legal_name"));
            Assert.assertTrue(vendor.containsKey("modified_at"));
        }
    }

}
