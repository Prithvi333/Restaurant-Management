package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.MenuItem;
import com.restaurant.restaurant.service.item.MenuItemDto;
import com.restaurant.restaurant.service.item.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/create")
    public ResponseEntity<MenuItem> createMenuItem(@RequestParam String menuName, @RequestParam int menuId, @RequestBody MenuItem menuItem){
     return new ResponseEntity<>(menuItemService.createMenuItem(menuId,menuName,menuItem),HttpStatus.CREATED);
   }
    @GetMapping("/read")
    public ResponseEntity<List<MenuItem>> getAllMenuItem(){
     return new ResponseEntity<>(menuItemService.getAllMenuItem(),HttpStatus.OK);
    };
    @DeleteMapping("/delete/{menuId}/{menuItemId}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable("menuId")int menuId,@PathVariable("menuItemId") int id){
        return new ResponseEntity<>(menuItemService.deleteMenuItem(menuId,id),HttpStatus.OK);
    }
    @PatchMapping("/update/{menuId}/{menuItemId}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable int menuId , @PathVariable int menuItemId, @RequestBody MenuItemDto menuItemDto){
        return new ResponseEntity<>(menuItemService.updateMenuItem(menuId,menuItemId,menuItemDto),HttpStatus.OK);
    }
}
