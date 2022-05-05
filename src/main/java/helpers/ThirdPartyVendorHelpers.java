package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class ThirdPartyVendorHelpers {
    public static void validateGetVendorContract(JsonPath jsonPath){
        Map vendor = (Map) jsonPath.getList("$").get(0);
        CommonHelpers.validateGetVendorContract(vendor);
    }

    public static void validateGetBusinessUnitContract(JsonPath jsonPath){
        Map business_unit = (Map) jsonPath.getList("$").get(0);
        CommonHelpers.validateGetBusinessUnitContract(business_unit);
    }

    public static void validateGetVendorUsersContract(JsonPath jsonPath){
        Map vendor = (Map) jsonPath.getList("$").get(0);
        CommonHelpers.validateUserContract(vendor);
    }

    public static void validateDeActivateVendorContract(JsonPath jsonPath){
        Map vendor = (Map) jsonPath.getMap("$");
        CommonHelpers.validateDeActivatedUserContract(vendor);
    }

    public static void validateActivateVendorContract(JsonPath jsonPath){
        Map vendor = (Map) jsonPath.getMap("$");
        CommonHelpers.validateActivatedUserContract(vendor);
    }

    public static void validate3plReportContract(JsonPath jsonPath){
        Map field_executive = (Map) jsonPath.getList("$").get(0);
        if(field_executive!=null){
            Assert.assertTrue(field_executive.containsKey("field_executive"));
            Assert.assertTrue(field_executive.containsKey("vendor"));
            Assert.assertTrue(field_executive.containsKey("seller"));
            Assert.assertTrue(field_executive.containsKey("business_unit"));
            Assert.assertTrue(field_executive.containsKey("business_unit"));
            Assert.assertTrue(field_executive.containsKey("completed_touchpoints"));
            Assert.assertTrue(field_executive.containsKey("total_duties"));
            Assert.assertTrue(field_executive.containsKey("working_days"));
        }
    }
}
