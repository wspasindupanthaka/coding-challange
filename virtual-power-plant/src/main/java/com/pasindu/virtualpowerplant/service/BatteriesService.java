package com.pasindu.virtualpowerplant.service;

import com.pasindu.virtualpowerplant.dto.BatteriesGroup;
import com.pasindu.virtualpowerplant.dto.BatteryDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BatteriesService {
    void insertBatteries(@RequestBody List<BatteryDTO> batteries);
    BatteriesGroup getBatteriesInAPostCodeRange(@RequestParam int lowerRange, @RequestParam int upperRange);
}
