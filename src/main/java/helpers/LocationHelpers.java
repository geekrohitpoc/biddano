package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class LocationHelpers {

    public static void validateGetCitiesContract(JsonPath jsonPath){
        Map city = (Map) jsonPath.getList("$").get(0);
        if(city !=null){
            Assert.assertTrue(city.containsKey("id"));
            Assert.assertTrue(city.containsKey("name"));
            Assert.assertTrue(city.containsKey("state"));
        }
        Map state = (Map) city.get("state");
        if(state!=null){
            Assert.assertTrue(state.containsKey("id"));
            Assert.assertTrue(state.containsKey("name"));
            Assert.assertTrue(state.containsKey("country"));
        }
        Map country = (Map) state.get("country");
        if(country!=null){
            Assert.assertTrue(country.containsKey("id"));
            Assert.assertTrue(country.containsKey("name"));
        }
    }

    public static void validateGetStatesContract(JsonPath jsonPath){
        Map states = (Map) jsonPath.getList("$").get(0);
        if(states != null){
            Assert.assertTrue(states.containsKey("id"));
            Assert.assertTrue(states.containsKey("name"));
            Assert.assertTrue(states.containsKey("country"));
        }
        Map country = (Map) states.get("country");
        if(country!=null){
            Assert.assertTrue(country.containsKey("id"));
            Assert.assertTrue(country.containsKey("name"));
        }
    }

    public static void validateGetBusinessUnitsContract(JsonPath jsonPath){
        Map business_unit = (Map) jsonPath.getList("$").get(0);
        CommonHelpers.validateGetBusinessUnitContract(business_unit);
    }
}
