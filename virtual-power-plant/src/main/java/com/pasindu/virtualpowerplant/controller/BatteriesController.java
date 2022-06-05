package com.pasindu.virtualpowerplant.controller;

import com.pasindu.virtualpowerplant.dto.BatteriesGroup;
import com.pasindu.virtualpowerplant.dto.BatteryDTO;


import com.pasindu.virtualpowerplant.service.BatteriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("batteries")
@RestController
public class BatteriesController {


    private BatteriesService batteriesService;

    public BatteriesController(BatteriesService batteriesService) {
        this.batteriesService = batteriesService;
    }

    @PostMapping()
    public ResponseEntity insertBatteries(@RequestBody List<BatteryDTO> batteries) {
        batteriesService.insertBatteries(batteries);
        return new ResponseEntity("Batteries Inserted Successfully", HttpStatus.OK);
    }

    @GetMapping("in-a-post-code-range")
        public BatteriesGroup getBatteriesInAPostCodeRange(@RequestParam int lowerRange, @RequestParam int upperRange) {
        return batteriesService.getBatteriesInAPostCodeRange(lowerRange,upperRange);
    }

}
