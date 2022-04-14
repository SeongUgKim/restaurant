package edu.emory.restaurant.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class JsonService {
    public String getRestaurants() throws IOException {
        return readLines("restaurant_data.json");
    }

    private String readLines(String fileName) {
        return new BufferedReader(
                new InputStreamReader(
                        this.getClass().getClassLoader().getResourceAsStream(fileName)
                )
        ).lines().collect(Collectors.joining());
    }
}
