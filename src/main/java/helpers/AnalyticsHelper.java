package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class AnalyticsHelper {

    public static void validateAnalyticsAPIContractForAllBusinessUnits(JsonPath jsonPath){
        Map parentDictionary = jsonPath.getMap("$");
        Assert.assertTrue(parentDictionary.containsKey("buyers"));
        Assert.assertTrue(parentDictionary.containsKey("sellers"));
        Assert.assertTrue(parentDictionary.containsKey("short_center"));
        Assert.assertTrue(parentDictionary.containsKey("all_invalid_locations"));
        Assert.assertEquals(parentDictionary.size(), 4);
        Map buyers = jsonPath.getMap("buyers[0]");
        Assert.assertTrue(buyers.containsKey("id"));
        Assert.assertTrue(buyers.containsKey("location"));
        Assert.assertEquals(buyers.size(), 2);
        Map sellers = jsonPath.getMap("sellers[0]");
        Assert.assertTrue(sellers.containsKey("id"));
        Assert.assertTrue(sellers.containsKey("location"));
        Assert.assertEquals(sellers.size(), 2);
        Map short_center = jsonPath.getMap("short_center[0]");
        Assert.assertTrue(short_center.containsKey("id"));
        Assert.assertTrue(short_center.containsKey("type"));
        Assert.assertTrue(short_center.containsKey("location"));
        Assert.assertEquals(short_center.size(), 3);
        Map invalid_location = jsonPath.getMap("all_invalid_locations[0]");
        Assert.assertTrue(invalid_location.containsKey("id"));
        Assert.assertTrue(invalid_location.containsKey("type"));
        Assert.assertTrue(invalid_location.containsKey("location"));
        Assert.assertEquals(invalid_location.size(), 3);
    }

    public static void validateAnalyticsAPIContractForSpecificBusinessUnits(JsonPath jsonPath){
        Map parentDictionary = jsonPath.getMap("$");
        Assert.assertTrue(parentDictionary.containsKey("buyers"));
        Assert.assertTrue(parentDictionary.containsKey("sellers"));
        Assert.assertTrue(parentDictionary.containsKey("short_center"));
        Assert.assertEquals(parentDictionary.size(), 3);
        Map buyers = jsonPath.getMap("buyers[0]");
        if(buyers != null){
            Assert.assertTrue(buyers.containsKey("id"));
            Assert.assertTrue(buyers.containsKey("location"));
            Assert.assertEquals(buyers.size(), 2);
        }
        Map sellers = jsonPath.getMap("sellers[0]");
        if(sellers !=null ){
            Assert.assertTrue(sellers.containsKey("id"));
            Assert.assertTrue(sellers.containsKey("location"));
            Assert.assertEquals(sellers.size(), 2);
        }
        Map short_center = jsonPath.getMap("short_center[0]");
        if(short_center!=null){
            Assert.assertTrue(short_center.containsKey("id"));
            Assert.assertTrue(short_center.containsKey("location"));
            Assert.assertEquals(short_center.size(), 2);
        }
    }

    public static void validateBusinessUnitAPIContract(JsonPath jsonPath){
        Map units = (Map) jsonPath.getList("$").get(0);
        Assert.assertTrue(units.containsKey("id"));
        Assert.assertTrue(units.containsKey("name"));
        Assert.assertTrue(units.containsKey("created_at"));
        Assert.assertTrue(units.containsKey("modified_at"));
        Assert.assertTrue(units.containsKey("city"));
        Assert.assertTrue(units.containsKey("business_unit_geo_fence"));
        Map city = (Map) units.get("city");
        Assert.assertTrue(city.containsKey("id"));
        Assert.assertTrue(city.containsKey("name"));
        Map business_unit_geo_fence = (Map) units.get("business_unit_geo_fence");
        Assert.assertTrue(business_unit_geo_fence.containsKey("type"));
        Assert.assertTrue(business_unit_geo_fence.containsKey("coordinates"));
    }
}
