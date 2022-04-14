package edu.emory.restaurant.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MenuItemDto {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}