package main.java.helpers;

import io.restassured.path.json.JsonPath;
import main.java.builders.reverseDuty.CreateDuty;
import org.testng.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReverseDutyHelpers {

    public static void validateGetReverseDutyOrdersContract(JsonPath jsonPath){
        List orders = jsonPath.getList("$");
        if(orders.size()!=0){
            Map order = (Map) orders.get(0);
            Map bulk_seller = (Map) order.get("bulk_seller");
            Map mapped_bulk_buyer = (Map) order.get("mapped_bulk_buyer");
            Assert.assertTrue(order.containsKey("bulk_seller"));
            CommonHelpers.validateBulkSeller(bulk_seller);
            Assert.assertTrue(order.containsKey("created_by"));
            Assert.assertTrue(order.containsKey("id"));
            Assert.assertTrue(order.containsKey("invoice_date"));
            Assert.assertTrue(order.containsKey("invoice_number"));
            Assert.assertTrue(order.containsKey("mapped_bulk_buyer"));
            ReverseDutyHelpers.validatemappedBulkBuyer(mapped_bulk_buyer);
            Assert.assertTrue(order.containsKey("payment_type"));
            Assert.assertTrue(order.containsKey("received_signed_pod_at"));
            Assert.assertTrue(order.containsKey("received_signed_pos_at"));
            Assert.assertTrue(order.containsKey("status"));
            Assert.assertTrue(order.containsKey("total_amount_in_rupees"));
            Assert.assertTrue(order.containsKey("unmapped_buyer_address"));
            Assert.assertTrue(order.containsKey("unmapped_buyer_name"));
        }
    }


    public static void validatemappedBulkBuyer(Map mapped_bulk_buyer){
        Assert.assertTrue(mapped_bulk_buyer.containsKey("id"));
        Assert.assertTrue(mapped_bulk_buyer.containsKey("name"));
    }

    public static CreateDuty createBodyForCreateDuty(String name) throws IOException {
        String unique_name = name+getUniqueNumber();
        String start_by = String.valueOf(LocalDateTime.now());
        List<String> order_ids = new ArrayList<>();
        List<String> seller_ids = new ArrayList<>();
        String seller_id = CommonHelpers.getEnvSpecificProperty("CreateDuty.properties", "SELLER_ID");
        String business_unit = CommonHelpers.getEnvSpecificProperty("CreateDuty.properties", "BUSINESS_UNIT_ID");
        String duty_type = CommonHelpers.getEnvSpecificProperty("CreateDuty.properties", "DUTY_TYPE");
        String field_executive_id = CommonHelpers.getEnvSpecificProperty("CreateDuty.properties", "FIELD_EXECUTIVE_ID");
        String sort_center_id = CommonHelpers.getEnvSpecificProperty("CreateDuty.properties", "SORT_CENTER_ID");
        seller_ids.add(seller_id);
        CreateDuty createDuty = new CreateDuty(
                business_unit,
                duty_type,
                field_executive_id,
                unique_name,
                order_ids,
                seller_ids,
                sort_center_id,
                start_by );
        return createDuty;
    }

    public static void validateCreateDutyContract(JsonPath jsonPath){
        Map create_duty = jsonPath.getMap("$");
        Map field_executive = (Map) create_duty.get("field_executive");
        Map sort_center = (Map) create_duty.get("sort_center");
        Map created_by = (Map) create_duty.get("created_by");
        List stops = (List) create_duty.get("stops");
        Map stop = (Map) stops.get(0);
        Assert.assertTrue(create_duty.containsKey("id"));
        Assert.assertTrue(create_duty.containsKey("name"));
        Assert.assertTrue(create_duty.containsKey("status"));
        Assert.assertTrue(create_duty.containsKey("duty_type"));
        Assert.assertTrue(create_duty.containsKey("field_executive"));
        ReverseDutyHelpers.validateFieldExecutiveContract(field_executive);
        Assert.assertTrue(create_duty.containsKey("route"));
        Assert.assertTrue(create_duty.containsKey("business_unit"));
        Assert.assertTrue(create_duty.containsKey("sort_center"));
        ReverseDutyHelpers.validateSortCenterContract(sort_center);
        Assert.assertTrue(create_duty.containsKey("started_at"));
        Assert.assertTrue(create_duty.containsKey("start_by"));
        Assert.assertTrue(create_duty.containsKey("completed_at"));
        Assert.assertTrue(create_duty.containsKey("handover_at"));
        Assert.assertTrue(create_duty.containsKey("created_at"));
        Assert.assertTrue(create_duty.containsKey("modified_at"));
        Assert.assertTrue(create_duty.containsKey("created_by"));
        ReverseDutyHelpers.validateCreatedByContract(created_by);
        Assert.assertTrue(create_duty.containsKey("last_modified_by"));
        Assert.assertTrue(create_duty.containsKey("stops"));
        ReverseDutyHelpers.validateStopsContract(stop);
        Assert.assertTrue(create_duty.containsKey("duty_coordinates"));
    }

    public static void validateFieldExecutiveContract(Map fieldExecutive){
        Map vendor = (Map) fieldExecutive.get("vendor");
        Assert.assertTrue(fieldExecutive.containsKey("id"));
        Assert.assertTrue(fieldExecutive.containsKey("first_name"));
        Assert.assertTrue(fieldExecutive.containsKey("last_name"));
        Assert.assertTrue(fieldExecutive.containsKey("phone_number"));
        Assert.assertTrue(fieldExecutive.containsKey("vendor"));
        ReverseDutyHelpers.validateVendorContract(vendor);
    }

    public static void validateSortCenterContract(Map sortCenter){
        Map business_unit = (Map) sortCenter.get("business_unit");
        Map location = (Map) sortCenter.get("location");
        Map address = (Map) sortCenter.get("address");
        Assert.assertTrue(sortCenter.containsKey("id"));
        Assert.assertTrue(sortCenter.containsKey("name"));
        Assert.assertTrue(sortCenter.containsKey("is_active"));
        Assert.assertTrue(sortCenter.containsKey("business_unit"));
        ReverseDutyHelpers.validateBusinessUnitContract(business_unit);
        Assert.assertTrue(sortCenter.containsKey("location"));
        ReverseDutyHelpers.validateLocationContract(location);
        Assert.assertTrue(sortCenter.containsKey("address"));
        ReverseDutyHelpers.validateAddressContract(address);
    }

    public static void validateBusinessUnitContract(Map businessUnit){
        Map city = (Map) businessUnit.get("city");
        Assert.assertTrue(businessUnit.containsKey("id"));
        Assert.assertTrue(businessUnit.containsKey("name"));
        Assert.assertTrue(businessUnit.containsKey("city"));
        ReverseDutyHelpers.validateCityContract(city);
    }

    public static void validateCityContract(Map city){
        Assert.assertTrue(city.containsKey("id"));
        Assert.assertTrue(city.containsKey("name"));
    }

    public static void validateLocationContract(Map location){
        Assert.assertTrue(location.containsKey("type"));
        Assert.assertTrue(location.containsKey("coordinates"));
    }

    public static void validateAddressContract(Map address){
        Map city = (Map) address.get("city");
        Assert.assertTrue(address.containsKey("line_1"));
        Assert.assertTrue(address.containsKey("line_2"));
        Assert.assertTrue(address.containsKey("postal_code"));
        ReverseDutyHelpers.validateAddressCityContract(city);
    }

    public static void validateAddressCityContract(Map city){
        Assert.assertTrue(city.containsKey("id"));
        Assert.assertTrue(city.containsKey("name"));
        Assert.assertTrue(city.containsKey("state"));
        Assert.assertTrue(city.containsKey("country"));
    }

    public static void validateCreatedByContract(Map createdBy){
        Assert.assertTrue(createdBy.containsKey("id"));
        Assert.assertTrue(createdBy.containsKey("first_name"));
        Assert.assertTrue(createdBy.containsKey("last_name"));
        Assert.assertTrue(createdBy.containsKey("phone_number"));
        Assert.assertTrue(createdBy.containsKey("email"));
    }

    public static void validateStopsContract(Map stop){
        Map location = (Map) stop.get("location");
        Assert.assertTrue(stop.containsKey("id"));
        Assert.assertTrue(stop.containsKey("status"));
        Assert.assertTrue(stop.containsKey("stop_type"));
        Assert.assertTrue(stop.containsKey("stop_sub_type"));
        Assert.assertTrue(stop.containsKey("contact_numbers"));
        Assert.assertTrue(stop.containsKey("name"));
        ReverseDutyHelpers.validateLocationContract(location);
        Assert.assertTrue(stop.containsKey("location_accuracy"));
        Assert.assertTrue(stop.containsKey("address"));
        Assert.assertTrue(stop.containsKey("reference_id"));
        Assert.assertTrue(stop.containsKey("orders"));
        Assert.assertTrue(stop.containsKey("started_at"));
        Assert.assertTrue(stop.containsKey("completed_at"));
        Assert.assertTrue(stop.containsKey("point_close_image"));
        Assert.assertTrue(stop.containsKey("orders_sku_count"));
    }

    public static void validateVendorContract(Map vendor){
        Assert.assertTrue(vendor.containsKey("id"));
        Assert.assertTrue(vendor.containsKey("legal_name"));
        Assert.assertTrue(vendor.containsKey("alias"));
        Assert.assertTrue(vendor.containsKey("email"));
        Assert.assertTrue(vendor.containsKey("contact_numbers"));
    }

    public  static String getUniqueNumber() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyymm");
        String strDate = sdf.format(dt);
        return strDate;
    }

    public static void validateGetDutiesContract(JsonPath jsonPath){
        Map data = jsonPath.getMap("$");
        Assert.assertTrue(data.containsKey("count"));
        Assert.assertTrue(data.containsKey("next"));
        Assert.assertTrue(data.containsKey("previous"));
        List duties = (List) data.get("results");
        if(duties.size()!=0){
            Map duty = (Map) duties.get(0);
            Assert.assertTrue(duty.containsKey("business_unit_id"));
            Assert.assertTrue(duty.containsKey("completed_at"));
            Assert.assertTrue(duty.containsKey("duty_type"));
            Assert.assertTrue(duty.containsKey("field_executive"));
            Assert.assertTrue(duty.containsKey("field_executive_mobile"));
            Assert.assertTrue(duty.containsKey("handover_at"));
            Assert.assertTrue(duty.containsKey("id"));
            Assert.assertTrue(duty.containsKey("name"));
            Assert.assertTrue(duty.containsKey("orders_count"));
            Assert.assertTrue(duty.containsKey("orders_gmv"));
            Assert.assertTrue(duty.containsKey("orders_sku_count"));
            Assert.assertTrue(duty.containsKey("start_by"));
            Assert.assertTrue(duty.containsKey("started_at"));
            Assert.assertTrue(duty.containsKey("status"));
        }
    }
}
