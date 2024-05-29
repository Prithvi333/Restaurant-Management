package com.restaurant.restaurant.service.restaurant;

import com.restaurant.restaurant.entity.Restaurant;
import com.restaurant.restaurant.exception.restaurantex.EmptyRestaurantList;
import com.restaurant.restaurant.exception.restaurantex.RestaurantNotFound;
import com.restaurant.restaurant.repository.RestaurantRepo;
import com.restaurant.restaurant.utility.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements  RestaurantService{

    @Autowired
    private RestaurantRepo restaurantRepo;


    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {

        List<Restaurant> restaurantList  = restaurantRepo.findAll();
        if(restaurantList.isEmpty())
            throw new EmptyRestaurantList();
        return restaurantList;
    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, RestaurantDto restaurantDto) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(restaurantId);
        if(restaurant.isEmpty())
            throw new RestaurantNotFound();
        Restaurant validRestaurant = restaurant.get();
        validRestaurant.setLocation(restaurantDto.getLocation());
        validRestaurant.setSeatingCapacity(restaurantDto.getSeatingCapacity());
        return restaurantRepo.save(validRestaurant);
    }

    @Override
    public String deleteRestaurant(int restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(restaurantId);
        if(restaurant.isEmpty())
            throw new RestaurantNotFound();
        restaurantRepo.deleteById(restaurantId);
        return "Restaurant with id "+restaurant+" deleted successfully";
    }
}
