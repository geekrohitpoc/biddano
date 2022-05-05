package main.java.helpers;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class DashboardHelpers {

    public static void validateDasboardAPIContract(JsonPath jsonPath, int timeframe) {
        Map parentDictionary = jsonPath.getMap("$");
        Assert.assertTrue(parentDictionary.containsKey("daily_data"));
        Assert.assertTrue(parentDictionary.containsKey("buyer_type"));
        Assert.assertTrue(parentDictionary.containsKey("buyer_city"));
        Assert.assertEquals(parentDictionary.size(), 3);
        List daily_data = jsonPath.getList("daily_data");
        Assert.assertNotNull(daily_data);
        Assert.assertEquals(daily_data.size(), timeframe);
        Map daily_data_map = jsonPath.getMap("daily_data[0]");
        Assert.assertTrue(daily_data_map.containsKey("gmv"));
        Assert.assertTrue(daily_data_map.containsKey("date"));
        Assert.assertTrue(daily_data_map.containsKey("total_orders"));
        Assert.assertTrue(daily_data_map.containsKey("total_orders"));
        Assert.assertTrue(daily_data_map.containsKey("cancelled_orders"));
        Assert.assertEquals(daily_data_map.size(), 5);
    }

    public static void validateDashboardOnboardingChartAPIContract(JsonPath jsonPath, int timeframe) {
        Map parentDictionary = jsonPath.getMap("$");
        Assert.assertTrue(parentDictionary.containsKey("daily_data"));
        Assert.assertTrue(parentDictionary.containsKey("buyer_type"));
        Assert.assertTrue(parentDictionary.containsKey("buyer_city"));
        Assert.assertEquals(parentDictionary.size(), 3);
        List daily_data = jsonPath.getList("daily_data");
        Assert.assertNotNull(daily_data);
        Assert.assertEquals(daily_data.size(), timeframe);
        Map daily_data_map = jsonPath.getMap("daily_data[0]");
        Assert.assertTrue(daily_data_map.containsKey("onboardings"));
        Assert.assertTrue(daily_data_map.containsKey("date"));
        Assert.assertEquals(daily_data_map.size(), 2);
    }

}
