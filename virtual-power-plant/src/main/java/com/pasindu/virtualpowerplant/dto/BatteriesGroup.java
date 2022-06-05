package com.pasindu.virtualpowerplant.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BatteriesGroup {
    private List<String> names;
    private double averageCapacity;
    private int totalCapacity;
}
