package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class BarcodeManagerHelpers {

    public static void validateGetBarcodeMatchesContract(JsonPath jsonPath){
        Map barcode = (Map) jsonPath.getList("$").get(0);
        if(barcode!=null){
            Assert.assertTrue(barcode.containsKey("created_at"));
            Assert.assertTrue(barcode.containsKey("created_by"));
            Assert.assertTrue(barcode.containsKey("id"));
            Assert.assertTrue(barcode.containsKey("is_download_available"));
            Assert.assertTrue(barcode.containsKey("name"));
            Assert.assertTrue(barcode.containsKey("quantity"));
            Assert.assertTrue(barcode.containsKey("used_count"));
        }
        Map created_by = (Map) barcode.get("created_by");
        if(created_by!=null){
            Assert.assertTrue(created_by.containsKey("email"));
            Assert.assertTrue(created_by.containsKey("first_name"));
            Assert.assertTrue(created_by.containsKey("id"));
            Assert.assertTrue(created_by.containsKey("last_name"));
            Assert.assertTrue(created_by.containsKey("phone_number"));
        }
    }
}
