package com.pasindu.virtualpowerplant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BatteryDTO {

    private String name;
    private String postcode;
    private int capacity;

}
