package edu.emory.restaurant.respository;

import edu.emory.restaurant.domain.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepository {
    private final EntityManager em;

    public void save(Restaurant restaurant) {
        em.persist(restaurant);
    }

    public Restaurant findOne(Long id) {
        return em.find(Restaurant.class, id);
    }

    public List<Restaurant> findAll() {
        return em.createQuery("select r from Restaurant r", Restaurant.class).getResultList();
    }
}
