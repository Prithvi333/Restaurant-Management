package com.restaurant.restaurant.service.item;

import com.restaurant.restaurant.entity.Menu;
import com.restaurant.restaurant.entity.MenuItem;
import com.restaurant.restaurant.exception.itemex.EmptyMenuItem;
import com.restaurant.restaurant.exception.itemex.MenuItemNotFound;
import com.restaurant.restaurant.exception.menuex.MenuNotFound;
import com.restaurant.restaurant.repository.MenuItemRepo;
import com.restaurant.restaurant.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service
public class MenuItemServiceImp implements  MenuItemService{

    @Autowired
    private MenuRepo menuRepo;
    @Autowired
    private MenuItemRepo menuItemRepo;

    @Override
    public MenuItem createMenuItem(int menuId, String menuName, MenuItem menuItem) {
          List<Menu> menuItems = menuRepo.findAll();
          if(menuItems.isEmpty())
              throw  new EmptyMenuItem();
          boolean isPresent = false;
            for(Menu menu : menuItems){
                if(menu.getName().equals(menuName) && menu.getMenuId() == menuId){
                    menuItem.setMenu(menu);
                    menu.getMenuItems().add(menuItem);
                    menuRepo.save(menu);
                    isPresent=true;
                    break;
                }
            }
            if(!isPresent)
                throw new MenuNotFound("Menu not found to add the menuItem");
           return  menuItemRepo.findByName(menuItem.getName()).get();
    }

    @Override
    public List<MenuItem> getAllMenuItem() {
      List<MenuItem> menuItems  =  menuItemRepo.findAll();
      if(menuItems.isEmpty())
          throw new EmptyMenuItem();
      return menuItems;
    }

    @Override
    public String deleteMenuItem(int menuId,int menuItemId) {

         List<Menu> menuList = menuRepo.findAll();
         boolean parentIsPresent = false;
         boolean childIsPresent = false;
         for(int j=0;j<menuList.size();j++){
             if(menuList.get(j).getMenuId() == menuId){
                 parentIsPresent=true;
               List<MenuItem> menuItems = menuList.get(j).getMenuItems();
               for(MenuItem menuItem : menuItems){
                   if(menuItem.getMenuItemId() == menuItemId){
                       childIsPresent=true;
                       menuItems.remove(menuItem);
                       menuRepo.save(menuList.get(j));
                       break;
                   }
               }
                 if(childIsPresent)
                     break;
             }
         }

          if(!parentIsPresent)
              throw new MenuNotFound();
          if(!childIsPresent)
              throw new MenuItemNotFound();
          return "MenuItem deleted successfully";
    }

    @Override
    public MenuItem updateMenuItem(int menuId, int menuItemId, MenuItemDto menuItemDto) {

        List<Menu> menuList =  menuRepo.findAll();
        boolean parentIsPresent =false;
        boolean childIsPresent = false;
        int childId= -1;
        for(int k=0;k<menuList.size();k++){
            if(menuList.get(k).getMenuId() == menuId){
                parentIsPresent=true;
                List<MenuItem> menuItems = menuList.get(k).getMenuItems();
                for(int l=0;l<menuItems.size();l++){
                    if(menuItems.get(l).getMenuItemId() == menuItemId){
                        childIsPresent=true;
                        MenuItem menuItem =  menuItems.get(l);
                        childId = menuItem.getMenuItemId();
                        menuItem.setPrice(menuItemDto.price);
                        menuItem.setCategory(menuItemDto.category);
                        menuRepo.save(menuList.get(k));
                        break;
                    }
                }
            }
            if(parentIsPresent)
                break;
        }
        if(!parentIsPresent)
            throw new MenuNotFound();
        if(!childIsPresent)
            throw new MenuItemNotFound();
        return menuItemRepo.findById(childId).get();
    }
}
