package edu.emory.restaurant.respository;

import edu.emory.restaurant.domain.MenuItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuItemRepository {
    private final EntityManager em;

    public void save(MenuItem menuItem) {
        em.persist(menuItem);
    }

    public MenuItem findOne(Long id) {
        return em.find(MenuItem.class, id);
    }

    public List<MenuItem> findAll() {
        return em.createQuery("select m from MenuItem m", MenuItem.class).getResultList();
    }

    public List<MenuItem> findByName(String name) {
        return em.createQuery("select m from MenuItem as m where m.name =: name", MenuItem.class)
                .setParameter("name", name)
                .getResultList();
    }
}
