package edu.emory.restaurant.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("restaurants")
    @Expose
    private List<RestaurantDto> restaurants = null;

    public List<RestaurantDto> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantDto> restaurants) {
        this.restaurants = restaurants;
    }

}