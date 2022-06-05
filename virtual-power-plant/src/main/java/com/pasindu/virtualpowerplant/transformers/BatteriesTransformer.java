package com.pasindu.virtualpowerplant.transformers;

import com.pasindu.virtualpowerplant.dto.BatteryDTO;
import com.pasindu.virtualpowerplant.entity.Battery;
import org.springframework.stereotype.Component;

@Component
public class BatteriesTransformer {

    public Battery transformDTOToEntity(BatteryDTO batteryDTO) {
        return Battery.builder()
                .name(batteryDTO.getName())
                .capacity(batteryDTO.getCapacity())
                .postCode(Integer.parseInt(batteryDTO.getPostcode()))
                .build();
    }

    public BatteryDTO transformEntityToDTO(Battery battery) {
        return BatteryDTO.builder()
                .name(battery.getName())
                .capacity(battery.getCapacity())
                .postcode(String.valueOf(battery.getPostCode()))
                .build();
    }

}
