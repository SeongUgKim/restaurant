package edu.emory.restaurant.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    private String name;
    @JsonProperty(value = "number_of_employees")
    private int numberOfEmployees;
    private List<String> services;
}
