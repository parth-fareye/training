package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Getter @Setter @NoArgsConstructor @ToString
public class Car {
    @NotNull @Min(1) @Max(20000)
    private int id;
    @NotNull
    private String name;
    private String model;
}