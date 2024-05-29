package com.restaurant.restaurant.service.item;

import com.restaurant.restaurant.entity.MenuItem;
import com.restaurant.restaurant.utility.MenuItemDto;

import java.util.List;

public interface MenuItemService {
    public MenuItem createMenuItem(int menuId , String menuName, MenuItem menuItem );
    public List<MenuItem> getAllMenuItem();
    public String deleteMenuItem(int menuId,int menuItemId);
    public MenuItem updateMenuItem(int menuId, int menuItemId, MenuItemDto menuItemDto);

}
