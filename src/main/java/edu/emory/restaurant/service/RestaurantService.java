package edu.emory.restaurant.service;

import edu.emory.restaurant.domain.Menu;
import edu.emory.restaurant.domain.Restaurant;
import edu.emory.restaurant.respository.MenuRepository;
import edu.emory.restaurant.respository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Long saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurant.getId();
    }

    @Transactional
    public void addMenu(Long restaurantId, Long menuId) {
        Menu findMenu = menuRepository.findOne(menuId);
        Restaurant findRestaurant = restaurantRepository.findOne(restaurantId);
        findRestaurant.addMenu(findMenu);
    }

    public List<Restaurant> findRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant findRestaurant(Long restaurantId) {
        return restaurantRepository.findOne(restaurantId);
    }
}
