package edu.emory.restaurant.service;

import edu.emory.restaurant.domain.Menu;
import edu.emory.restaurant.domain.MenuItem;
import edu.emory.restaurant.respository.MenuItemRepository;
import edu.emory.restaurant.respository.MenuRepository;
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
class MenuServiceTest {

    @Autowired
    MenuService menuService;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuItemService menuItemService;
    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    EntityManager em;


    @Test
    public void save() {
        String name = "lunch";
        Menu menu = new Menu(name);
        Long savedId = menuService.saveMenu(menu);
        em.flush();
        assertThat(menu).isEqualTo(menuService.findMenu(savedId));
    }

    @Test
    public void addItem() {
        String name = "Burger";
        Double price = 9.0;
        MenuItem menuItem = new MenuItem(name, price);
        Long menuItemId = menuItemService.saveMenuItem(menuItem);
        String menuName = "lunch";
        Menu menu = new Menu(menuName);
        Long menuId = menuService.saveMenu(menu);
        menuService.addMenuItem(menuId, menuItemId);
        assertThat(menuService.findMenu(menuId).getMenuItems().get(0)).isEqualTo(menuItemService.findOne(menuItemId));
    }
}