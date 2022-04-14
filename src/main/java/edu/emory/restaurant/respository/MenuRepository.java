package edu.emory.restaurant.respository;

import edu.emory.restaurant.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepository {
    private final EntityManager em;

    public void save(Menu menu) {
        em.persist(menu);
    }

    public Menu findOne(Long id) {
        return em.find(Menu.class, id);
    }

    public List<Menu> findAll() {
        return em.createQuery("select m from Menu m", Menu.class).getResultList();
    }

}
