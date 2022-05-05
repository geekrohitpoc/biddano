package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class FieldExecutiveHelpers {
    public static void validategetFieldExecutivesContract(JsonPath jsonPath){
        Map field_executive = (Map) jsonPath.getList("$").get(0);
        if(field_executive!=null){
            Assert.assertTrue(field_executive.containsKey("business_unit"));
            Assert.assertTrue(field_executive.containsKey("first_name"));
            Assert.assertTrue(field_executive.containsKey("id"));
            Assert.assertTrue(field_executive.containsKey("isOnDuty"));
            Assert.assertTrue(field_executive.containsKey("is_active"));
            Assert.assertTrue(field_executive.containsKey("last_name"));
            Assert.assertTrue(field_executive.containsKey("phone_number"));
            Assert.assertTrue(field_executive.containsKey("supervisor"));
            Assert.assertTrue(field_executive.containsKey("supervisor"));
        }
    }

    public static void validateFieldExecutiveContract(JsonPath jsonPath){
        Map field_executive = jsonPath.getMap("$");
        if(field_executive!=null){
            Assert.assertTrue(field_executive.containsKey("alternate_phone_number"));
            Assert.assertTrue(field_executive.containsKey("business_unit"));
            Assert.assertTrue(field_executive.containsKey("default_profile_image"));
            Assert.assertTrue(field_executive.containsKey("field_executive_type"));
            Assert.assertTrue(field_executive.containsKey("id"));
            Assert.assertTrue(field_executive.containsKey("isOnDuty"));
            Assert.assertTrue(field_executive.containsKey("profile_bio"));
            Assert.assertTrue(field_executive.containsKey("profile_image"));
            Assert.assertTrue(field_executive.containsKey("routes"));
            Assert.assertTrue(field_executive.containsKey("supervisor"));
            Assert.assertTrue(field_executive.containsKey("user"));
            Assert.assertTrue(field_executive.containsKey("vendor"));
        }
        Map business_unit = (Map) field_executive.get("business_unit");
        if(business_unit!= null){
            Map business_unit_geo_fence = (Map) business_unit.get("business_unit_geo_fence");
            Map city = (Map) business_unit.get("city");
            if(business_unit_geo_fence!=null){
                Assert.assertTrue(business_unit_geo_fence.containsKey("coordinates"));
                Assert.assertTrue(business_unit_geo_fence.containsKey("type"));
            }
            if(city!=null){
                Assert.assertTrue(city.containsKey("id"));
                Assert.assertTrue(city.containsKey("name"));
            }
            Assert.assertTrue(business_unit.containsKey("business_unit_geo_fence"));
            Assert.assertTrue(business_unit.containsKey("city"));
            Assert.assertTrue(business_unit.containsKey("created_at"));
            Assert.assertTrue(business_unit.containsKey("id"));
            Assert.assertTrue(business_unit.containsKey("modified_at"));
            Assert.assertTrue(business_unit.containsKey("name"));
        }
        Map profile_image = (Map) field_executive.get("profile_image");
        if(profile_image!=null){
            Assert.assertTrue(profile_image.containsKey("id"));
            Assert.assertTrue(profile_image.containsKey("url"));
        }
        Map supervoisor = (Map) field_executive.get("supervisor");
        if(supervoisor!=null){
            Assert.assertTrue(supervoisor.containsKey("email"));
            Assert.assertTrue(supervoisor.containsKey("first_name"));
            Assert.assertTrue(supervoisor.containsKey("id"));
            Assert.assertTrue(supervoisor.containsKey("last_name"));
            Assert.assertTrue(supervoisor.containsKey("phone_number"));
        }
        Map user = (Map) field_executive.get("user");
        if(user!=null){
            Map vendor = (Map) user.get("vendor");
            if(vendor!=null){
                Assert.assertTrue(vendor.containsKey("alias"));
                Assert.assertTrue(vendor.containsKey("contact_numbers"));
                Assert.assertTrue(vendor.containsKey("email"));
                Assert.assertTrue(vendor.containsKey("id"));
                Assert.assertTrue(vendor.containsKey("legal_name"));
            }
            Assert.assertTrue(user.containsKey("bulk_buyer"));
            Assert.assertTrue(user.containsKey("bulk_seller"));
            Assert.assertTrue(user.containsKey("business_unit"));
            Assert.assertTrue(user.containsKey("created_at"));
            Assert.assertTrue(user.containsKey("date_of_birth"));
            Assert.assertTrue(user.containsKey("first_name"));
            Assert.assertTrue(user.containsKey("gender"));
            Assert.assertTrue(user.containsKey("id"));
            Assert.assertTrue(user.containsKey("is_active"));
            Assert.assertTrue(user.containsKey("last_name"));
            Assert.assertTrue(user.containsKey("modified_at"));
            Assert.assertTrue(user.containsKey("other_business_unit"));
            Assert.assertTrue(user.containsKey("phone_number"));
            Assert.assertTrue(user.containsKey("roles"));
            Assert.assertTrue(user.containsKey("user_type"));
            Assert.assertTrue(user.containsKey("username"));
            Assert.assertTrue(user.containsKey("vendor"));
        }
        Map vendors = (Map) field_executive.get("vendors");
        CommonHelpers.validateGetVendorContract(vendors);
    }
}
