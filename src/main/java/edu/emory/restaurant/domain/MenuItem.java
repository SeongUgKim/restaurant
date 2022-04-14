package edu.emory.restaurant.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private String name;
    private Double price;

    public MenuItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void updateMenuItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
