package com.restaurant.restaurant.service.menu;

import com.restaurant.restaurant.entity.Menu;
import com.restaurant.restaurant.entity.Restaurant;
import com.restaurant.restaurant.exception.menuex.EmptyMenu;
import com.restaurant.restaurant.exception.menuex.MenuNotFound;
import com.restaurant.restaurant.exception.restaurantex.RestaurantNotFound;
import com.restaurant.restaurant.repository.MenuRepo;
import com.restaurant.restaurant.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public Menu createMenu(int restaurantId,Menu menu) {
        Optional<Restaurant> restaurant  = restaurantRepo.findById(restaurantId);
        if(restaurant.isEmpty())
            throw new RestaurantNotFound();

         Restaurant validRestaurant = restaurant.get();
         validRestaurant.setMenu(menu);
         menu.setRestaurant(restaurant.get());
         restaurantRepo.save(validRestaurant);
         return restaurantRepo.findById(restaurantId).get().getMenu();
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
