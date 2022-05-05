package main.java.builders.reverseDuty;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
public class CreateDuty {
    private String business_unit;
    private String duty_type;
    private String field_executive_id;
    private String name;
    private List<String> order_ids;
    private List<String> seller_ids;
    private String sort_center_id;
    private String start_by;
}
