package edu.emory.restaurant.service;

import edu.emory.restaurant.domain.MenuItem;
import edu.emory.restaurant.respository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    @Transactional
    public Long saveMenuItem(MenuItem menuItem) {
        validateDuplicateMenuItem(menuItem);
        menuItemRepository.save(menuItem);
        return menuItem.getId();
    }

    private void validateDuplicateMenuItem(MenuItem menuItem) {
        List<MenuItem> findMenuItem = menuItemRepository.findByName(menuItem.getName());
        if (!findMenuItem.isEmpty()) {
            throw new IllegalStateException("Already existed member name");
        }
    }

    @Transactional
    public void updateMenuItem(Long menuItemId, String name, Double price) {
        MenuItem item = menuItemRepository.findOne(menuItemId);
        item.updateMenuItem(name, price);
    }

    public List<MenuItem> findMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem findOne(Long menuItemId) {
        return menuItemRepository.findOne(menuItemId);
    }
}
