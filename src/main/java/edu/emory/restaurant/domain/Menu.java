package edu.emory.restaurant.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String name;
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        restaurant.getMenus().add(this);
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
        menuItem.setMenu(this);
    }

}
