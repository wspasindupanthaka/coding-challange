package com.pasindu.virtualpowerplant.service.impl;

import com.pasindu.virtualpowerplant.dto.BatteriesGroup;
import com.pasindu.virtualpowerplant.dto.BatteryDTO;
import com.pasindu.virtualpowerplant.entity.Battery;
import com.pasindu.virtualpowerplant.repository.BatteriesRepository;
import com.pasindu.virtualpowerplant.service.BatteriesService;
import com.pasindu.virtualpowerplant.transformers.BatteriesTransformer;
import com.pasindu.virtualpowerplant.util.BatteriesUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteriesServiceImpl implements BatteriesService {

    private final BatteriesRepository batteriesRepository;
    private final BatteriesTransformer batteriesTransformer;
    private final BatteriesUtil batteriesUtil;

    public BatteriesServiceImpl(BatteriesRepository batteriesRepository, BatteriesTransformer batteriesTransformer, BatteriesUtil batteriesUtil) {
        this.batteriesRepository = batteriesRepository;
        this.batteriesTransformer = batteriesTransformer;
        this.batteriesUtil = batteriesUtil;
    }

    @Override
    public void insertBatteries(List<BatteryDTO> batteries) {
        batteries.stream().forEach(batteryDTO -> {
            Battery battery = batteriesTransformer.transformDTOToEntity(batteryDTO);
            batteriesRepository.save(battery);
        });
    }

    @Override
    public BatteriesGroup getBatteriesInAPostCodeRange(int lowerRange, int upperRange) {
        BatteriesGroup batteriesGroup = new BatteriesGroup();

        List<Battery> batteriesInAPostCodeRange = batteriesRepository.findByPostCodeBetween(lowerRange, upperRange);

        batteriesGroup.setNames(batteriesUtil.getNamesOfABatteryListOrdered(batteriesInAPostCodeRange));
        batteriesGroup.setAverageCapacity(batteriesUtil.getAverageOfCapacitiesOfABatteryList(batteriesInAPostCodeRange));
        batteriesGroup.setTotalCapacity(batteriesUtil.getSumOfCapacitiesOfABatteryList(batteriesInAPostCodeRange));
        return batteriesGroup;
    }


}
