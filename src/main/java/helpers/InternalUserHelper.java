package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class InternalUserHelper {
    public static void validateGetInternalUserContract(JsonPath jsonPath){
        Map user = (Map) jsonPath.getList("$").get(0);
        CommonHelpers.validateUserContract(user);
    }

    public static void validateGetRoleContract(JsonPath jsonPath){
        Map role = (Map) jsonPath.getList("$").get(0);
        Assert.assertTrue(role.containsKey("id"));
        Assert.assertTrue(role.containsKey("name"));
        validateRoles(jsonPath);
    }

    public static void validateUserActivationContract(JsonPath jsonPath){
        Map user = (Map) jsonPath.getMap("$");
        CommonHelpers.validateActivatedUserContract(user);
    }

    public static void validateUserDeActivationContract(JsonPath jsonPath){
        Map user = (Map) jsonPath.getMap("$");
        CommonHelpers.validateDeActivatedUserContract(user);
    }

    public static void validateRoles(JsonPath jsonPath){
        String[] role_name = {"admin","business_unit_manager", "short_center_manager", "data_entry_user", "bulk_buyer_admin", "shortbuk_tech_api_admin", "supervisor"};
        for (int i = 0; i < 7 ; i++) {
            HashMap roles = (HashMap) jsonPath.getList("$").get(i);
            Assert.assertTrue(roles.containsValue(role_name[i]));
        }
    }
}
