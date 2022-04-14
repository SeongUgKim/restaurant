package edu.emory.restaurant.service;

import edu.emory.restaurant.domain.MenuItem;
import edu.emory.restaurant.respository.MenuItemRepository;
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
class MenuItemServiceTest {
    @Autowired
    MenuItemService menuItemService;
    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    EntityManager em;

    @Test
    public void save() {
        // given
        String name = "Burger";
        Double price = 9.0;
        MenuItem menuItem = new MenuItem(name, price);
        Long savedId = menuItemService.saveMenuItem(menuItem);
        em.flush();
        assertThat(menuItem).isEqualTo(menuItemService.findOne(savedId));
    }

    @Test
    public void duplicate_menuItem_exception() throws Exception {
        // given
        String name = "Burger";
        Double price = 9.0;
        MenuItem menuItem1 = new MenuItem(name, price);
        MenuItem menuItem2 = new MenuItem(name, price);
        // when
        menuItemService.saveMenuItem(menuItem1);
        // then
        assertThrows(IllegalStateException.class, () -> {
            menuItemService.saveMenuItem(menuItem2);
        });
    }

    @Test
    public void update() {
        // given
        String name = "Burger";
        Double price = 9.0;
        MenuItem menuItem = new MenuItem(name, price);
        Long savedId = menuItemService.saveMenuItem(menuItem);
        // when
        menuItemService.updateMenuItem(savedId,"Steak", 40.0);
        // then
        assertThat(menuItemService.findOne(savedId).getName()).isEqualTo("Steak");
        assertThat(menuItemService.findOne(savedId).getPrice()).isEqualTo(40.0);
    }
}