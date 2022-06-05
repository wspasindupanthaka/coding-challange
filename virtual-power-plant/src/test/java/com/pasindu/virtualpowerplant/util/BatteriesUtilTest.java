package com.pasindu.virtualpowerplant.util;

import com.pasindu.virtualpowerplant.entity.Battery;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class BatteriesUtilTest {

    @Autowired
    private BatteriesUtil batteriesUtil;


    List<Battery> batteryList = Arrays.asList(new Battery(1,"Bagot",820,27000),
            new Battery(2,"Yirrkala",880,13500),
            new Battery(3,"University of Melbourne",3010,85000),
            new Battery(4,"Norfolk Island",2899,13500),
            new Battery(5,"Ootha",2875,13500));


    @Test
    public void testGetNamesOfABatteryListOrdered_ListIsNotEmpty() {
        List<String> namesOfABatteryListOrdered = batteriesUtil.getNamesOfABatteryListOrdered(batteryList);
        Assert.notEmpty(namesOfABatteryListOrdered,"Names list is empty");

    }

    @Test
    public void testGetNamesOfABatteryListOrdered_ListSizeIsFive() {
        List<String> namesOfABatteryListOrdered = batteriesUtil.getNamesOfABatteryListOrdered(batteryList);
        Assert.isTrue(namesOfABatteryListOrdered.size()==5,"Size is not five");
    }

    @Test
    public void testGetNamesOfABatteryListOrdered_ListOrderIsOK() {
        List<String> namesOfABatteryListOrdered = batteriesUtil.getNamesOfABatteryListOrdered(batteryList);
        Assert.isTrue("Bagot".equals(namesOfABatteryListOrdered.get(0)),"First e lement is Bagot");
        Assert.isTrue("Norfolk Island".equals(namesOfABatteryListOrdered.get(1)),"First element is Norfolk Island");
        Assert.isTrue("Ootha".equals(namesOfABatteryListOrdered.get(2)),"First element is Ootha");
        Assert.isTrue("University of Melbourne".equals(namesOfABatteryListOrdered.get(3)),"First element is University of Melbourne");
        Assert.isTrue("Yirrkala".equals(namesOfABatteryListOrdered.get(4)),"First element is Yirrkala");
    }

    @Test
    public void testGetAverageOfCapacitiesOfABatteryList_AverageIsCorrect() {
        double averageOfCapacitiesOfABatteryList = batteriesUtil.getAverageOfCapacitiesOfABatteryList(batteryList);
       Assert.isTrue(averageOfCapacitiesOfABatteryList==30500, "Average is not 30500");
    }

    @Test
    public void testGetSumOfCapacitiesOfABatteryList_SumIsCorrect() {
        int sumOfCapacitiesOfABatteryList = batteriesUtil.getSumOfCapacitiesOfABatteryList(batteryList);
        Assert.isTrue(sumOfCapacitiesOfABatteryList==152500, "Sum is not 152500");
    }


}
