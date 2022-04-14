package edu.emory.restaurant.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.emory.restaurant.domain.Menu;

import java.util.List;

public class RestaurantDto {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("menus")
    @Expose
    private List<Menu> menus = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
