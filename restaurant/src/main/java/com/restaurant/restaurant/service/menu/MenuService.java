package com.restaurant.restaurant.service.menu;

import com.restaurant.restaurant.entity.Menu;
import com.restaurant.restaurant.entity.MenuItem;

import java.util.List;

public interface MenuService {

        Menu createMenu(int restaurantId,Menu menu);
        List<Menu> getAllMenu();
        String removeMenu(int menuId);
        Menu updateMenu(int menuId,MenuDto menuDto);

}
