package com.pasindu.virtualpowerplant.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Battery {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int postCode;
    private int capacity;

}
