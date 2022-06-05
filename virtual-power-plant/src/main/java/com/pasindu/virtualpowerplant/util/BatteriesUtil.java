package com.pasindu.virtualpowerplant.util;

import com.pasindu.virtualpowerplant.entity.Battery;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BatteriesUtil {
    public List<String> getNamesOfABatteryListOrdered(List<Battery> batteries) {
        List<String> batteryNames = batteries.stream().map(battery -> battery.getName()).collect(Collectors.toList());
        Collections.sort(batteryNames);
        return batteryNames;
    }

    public double getAverageOfCapacitiesOfABatteryList(List<Battery> batteries) {
        if (!batteries.isEmpty()) {
            return batteries.stream().mapToDouble(battery -> battery.getCapacity()).average().getAsDouble();
        }
        return 0;
    }

    public int getSumOfCapacitiesOfABatteryList(List<Battery> batteries) {
        if (!batteries.isEmpty()) {
            return batteries.stream().mapToInt(Battery::getCapacity).sum();
        }
        return 0;
    }
}
