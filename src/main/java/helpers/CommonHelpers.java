package main.java.helpers;

import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CommonHelpers extends EnvironmentHelpers{
    public static void validateGetVendorContract(Map vendor){
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

    public static void validateBulkSeller(Map bulk_seller){
        Assert.assertTrue(bulk_seller.containsKey("bulk_seller_type"));
        Assert.assertTrue(bulk_seller.containsKey("contact_numbers"));
        Assert.assertTrue(bulk_seller.containsKey("email"));
        Assert.assertTrue(bulk_seller.containsKey("id"));
        Assert.assertTrue(bulk_seller.containsKey("name"));
    }

    public static void validateGetBusinessUnitContract(Map business_unit){
        if(business_unit!=null){
            Assert.assertTrue(business_unit.containsKey("business_unit_geo_fence"));
            Assert.assertTrue(business_unit.containsKey("city"));
            Assert.assertTrue(business_unit.containsKey("created_at"));
            Assert.assertTrue(business_unit.containsKey("id"));
            Assert.assertTrue(business_unit.containsKey("modified_at"));
            Assert.assertTrue(business_unit.containsKey("name"));
        }
        Map business_unit_geo_fence = (Map) business_unit.get("business_unit_geo_fence");
        if(business_unit_geo_fence!=null){
            Assert.assertTrue(business_unit_geo_fence.containsKey("coordinates"));
            Assert.assertTrue(business_unit_geo_fence.containsKey("type"));
        }
        Map city = (Map) business_unit.get("city");
        if(city!=null){
            Assert.assertTrue(city.containsKey("id"));
            Assert.assertTrue(city.containsKey("name"));
        }
    }

    public static void validateUserContract(Map user){
        Map business_unit = (Map) user.get("business_unit");
        List roles = (List) user.get("roles");
        if(roles !=null){
            Map role = (Map) roles.get(0);
            Assert.assertTrue(role.containsKey("id"));
            Assert.assertTrue(role.containsKey("name"));
        }
        Assert.assertTrue(user.containsKey("id"));
        Assert.assertTrue(user.containsKey("first_name"));
        Assert.assertTrue(user.containsKey("last_name"));
        Assert.assertTrue(user.containsKey("phone_number"));
        Assert.assertTrue(user.containsKey("date_of_birth"));
        Assert.assertTrue(user.containsKey("user_type"));
        Assert.assertTrue(user.containsKey("username"));
        Assert.assertTrue(user.containsKey("gender"));
        Assert.assertTrue(user.containsKey("roles"));
        Assert.assertTrue(user.containsKey("created_at"));
        Assert.assertTrue(user.containsKey("modified_at"));
        Assert.assertTrue(user.containsKey("business_unit"));
        Assert.assertTrue(user.containsKey("other_business_unit"));
        if(user.get("user_type")=="vendor"){
            Assert.assertTrue(user.containsKey("vendor"));
        }
        if(business_unit!=null){
            CommonHelpers.validateGetBusinessUnitContract(business_unit);
        }
    }

    public static void validateActivatedUserContract(Map user){
        Assert.assertTrue(user.containsKey("date_of_birth"));
        Assert.assertTrue(user.containsKey("email"));
        Assert.assertTrue(user.containsKey("first_name"));
        Assert.assertTrue(user.containsKey("full_name"));
        Assert.assertTrue(user.containsKey("gender"));
        Assert.assertTrue(user.containsKey("id"));
        Assert.assertTrue(user.containsKey("is_active"));
        Assert.assertEquals(user.get("is_active"), true);
        Assert.assertTrue(user.containsKey("last_name"));
        Assert.assertTrue(user.containsKey("other_business_unit"));
        Assert.assertTrue(user.containsKey("phone_number"));
        Assert.assertTrue(user.containsKey("roles"));
        Assert.assertTrue(user.containsKey("short_centers"));
        Assert.assertTrue(user.containsKey("user_type"));
        Assert.assertTrue(user.containsKey("username"));
        if(user.get("user_type")=="vendor"){
            Assert.assertTrue(user.containsKey("vendor"));
        }
    }

    public static void validateDeActivatedUserContract(Map user){
        Assert.assertTrue(user.containsKey("date_of_birth"));
        Assert.assertTrue(user.containsKey("email"));
        Assert.assertTrue(user.containsKey("first_name"));
        Assert.assertTrue(user.containsKey("full_name"));
        Assert.assertTrue(user.containsKey("gender"));
        Assert.assertTrue(user.containsKey("id"));
        Assert.assertTrue(user.containsKey("is_active"));
        Assert.assertEquals(user.get("is_active"), false);
        Assert.assertTrue(user.containsKey("last_name"));
        Assert.assertTrue(user.containsKey("other_business_unit"));
        Assert.assertTrue(user.containsKey("phone_number"));
        Assert.assertTrue(user.containsKey("roles"));
        Assert.assertTrue(user.containsKey("short_centers"));
        Assert.assertTrue(user.containsKey("user_type"));
        Assert.assertTrue(user.containsKey("username"));
        if(user.get("user_type")=="vendor"){
            Assert.assertTrue(user.containsKey("vendor"));
        }
    }

    public static String getEnvSpecificProperty(String fileName, String propertyName) throws IOException {
        String directory_path = "";
        if(ENV=="https://api.staging.biddano.com"){
            directory_path= "/src/main/resources/properties/dataProperties/staging/";
        }
        String filePath = System.getProperty("user.dir") + directory_path + fileName;
        File f = new File(filePath);
        FileInputStream fis = new FileInputStream(f);
        Properties p = new Properties();
        p.load(fis);
        String propertyValue = p.getProperty(propertyName);
        return propertyValue;
    }

}
