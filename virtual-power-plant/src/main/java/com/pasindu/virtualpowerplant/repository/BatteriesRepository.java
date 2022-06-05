package com.pasindu.virtualpowerplant.repository;

import com.pasindu.virtualpowerplant.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatteriesRepository extends JpaRepository<Battery, Long> {

    List<Battery> findByPostCodeBetween(int lowerLimit, int upperLimit);

}
