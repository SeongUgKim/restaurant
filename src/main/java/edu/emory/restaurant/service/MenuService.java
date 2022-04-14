package edu.emory.restaurant.service;

import edu.emory.restaurant.domain.Menu;
import edu.emory.restaurant.domain.MenuItem;
import edu.emory.restaurant.respository.MenuItemRepository;
import edu.emory.restaurant.respository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {
    private final MenuItemRepository menuItemRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public Long saveMenu(Menu menu) {
        menuRepository.save(menu);
        return menu.getId();
    }

    @Transactional
    public void addMenuItem(Long menuId, Long menuItemId) {
        MenuItem findItem = menuItemRepository.findOne(menuItemId);
        Menu findMenu = menuRepository.findOne(menuId);
        findMenu.addMenuItem(findItem);
    }

    public List<Menu> findMenus() {
        return menuRepository.findAll();
    }

    public Menu findMenu(Long menuId) {
        return menuRepository.findOne(menuId);
    }

}
