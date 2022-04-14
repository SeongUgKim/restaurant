package edu.emory.restaurant.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();

    public Restaurant(String name) {
        this.name = name;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
        menu.setRestaurant(this);
    }
}
