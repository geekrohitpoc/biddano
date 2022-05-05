package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class SortCenterHelpers {

    public static void validateGetSortCenterContract(JsonPath jsonPath){
        Map sort_center = (Map) jsonPath.getList("$").get(0);
        if(sort_center !=null){
            Assert.assertTrue(sort_center.containsKey("address"));
            Assert.assertTrue(sort_center.containsKey("business_unit"));
            Assert.assertTrue(sort_center.containsKey("id"));
            Assert.assertTrue(sort_center.containsKey("is_active"));
            Assert.assertTrue(sort_center.containsKey("location"));
            Assert.assertTrue(sort_center.containsKey("name"));
        }
        Map address = (Map) sort_center.get("address");
        if(address != null){
            Map city = (Map) address.get("city");
            if(city !=null){
                Assert.assertTrue(city.containsKey("country"));
                Assert.assertTrue(city.containsKey("id"));
                Assert.assertTrue(city.containsKey("name"));
                Assert.assertTrue(city.containsKey("state"));
            }
            Assert.assertTrue(address.containsKey("city"));
            Assert.assertTrue(address.containsKey("line_1"));
            Assert.assertTrue(address.containsKey("line_2"));
            Assert.assertTrue(address.containsKey("postal_code"));
        }
        Map business_unit = (Map) sort_center.get("business_unit");
        if(business_unit !=null){
            Map city = (Map) business_unit.get("city");
            if(city !=null){
                Assert.assertTrue(city.containsKey("id"));
                Assert.assertTrue(city.containsKey("name"));
            }
            Assert.assertTrue(business_unit.containsKey("city"));
            Assert.assertTrue(business_unit.containsKey("id"));
            Assert.assertTrue(business_unit.containsKey("name"));
        }
    }


}
