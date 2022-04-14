package edu.emory.restaurant.service;

import edu.emory.restaurant.domain.Menu;
import edu.emory.restaurant.domain.MenuItem;
import edu.emory.restaurant.domain.Restaurant;
import edu.emory.restaurant.respository.RestaurantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class RestaurantServiceTest {
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MenuService menuService;
    @Autowired
    MenuItemService menuItemService;
    @Autowired
    EntityManager em;

    @Test
    public void save() {
        String name = "pop restaurant";
        Restaurant restaurant = new Restaurant(name);
        Long savedId = restaurantService.saveRestaurant(restaurant);
        em.flush();
        assertThat(restaurant).isEqualTo(restaurantService.findRestaurant(savedId));
    }

    @Test
    public void addMenu() {
        String name = "Burger";
        Double price = 9.0;
        MenuItem menuItem = new MenuItem(name, price);
        Long menuItemId = menuItemService.saveMenuItem(menuItem);
        String menuName = "lunch";
        Menu menu = new Menu(menuName);
        Long menuId = menuService.saveMenu(menu);
        menuService.addMenuItem(menuId, menuItemId);
        String resName = "Pop Restaurant";
        Restaurant restaurant = new Restaurant(resName);
        Long resId = restaurantService.saveRestaurant(restaurant);
        restaurantService.addMenu(resId,menuId);
        assertThat(restaurantService.findRestaurant(resId).getMenus().get(0)).isEqualTo(menuService.findMenu(menuId));
    }
}