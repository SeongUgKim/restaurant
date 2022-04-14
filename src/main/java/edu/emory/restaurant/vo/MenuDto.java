package edu.emory.restaurant.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.emory.restaurant.domain.MenuItem;

import java.util.List;

public class MenuDto {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("menu_items")
    @Expose
    private List<MenuItem> menuItems = null;
    @SerializedName("dishes")
    @Expose
    private List<DishDto> dishes = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<DishDto> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishDto> dishes) {
        this.dishes = dishes;
    }

}