package com.restaurant.restaurant.service.menu;

import com.restaurant.restaurant.entity.Menu;
import com.restaurant.restaurant.exception.menuex.EmptyMenu;
import com.restaurant.restaurant.exception.menuex.MenuNotFound;
import com.restaurant.restaurant.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public Menu createMenu(Menu menu) {
        Menu addedMenu  = menuRepo.save(menu);
         return menu;
    }

    @Override
    public List<Menu> getAllMenu() {
      List<Menu> menuList=  menuRepo.findAll();
      if(menuList.isEmpty())
          throw  new EmptyMenu();
      return menuList;

    }

    @Override
    public String removeMenu(int menuId) {
      Menu menu=  Optional.of(menuRepo.findById(menuId)).get().orElseThrow(MenuNotFound::new);
       menuRepo.delete(menu);
       return "Menu deleted successfully";
    }

    @Override
    public Menu updateMenu(int menuId,MenuDto menuDto) {
        Menu menu=  Optional.of(menuRepo.findById(menuId)).get().orElseThrow(MenuNotFound::new);
          menu.setName(menuDto.getName());
          menu.setDescription(menuDto.getDescription());
          return menuRepo.save(menu);
    }
}
