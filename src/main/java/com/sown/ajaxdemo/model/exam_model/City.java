package com.sown.ajaxdemo.model.exam_model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
    @ManyToOne
    private Country country;
//    @Size(min = 1, max = 20)
    private String cityName;
    private double area;
    private int population;
    private double gdp;
    private String description;

}
