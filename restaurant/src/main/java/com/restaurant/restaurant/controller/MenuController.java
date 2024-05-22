package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.Menu;
import com.restaurant.restaurant.entity.MenuItem;
import com.restaurant.restaurant.service.menu.MenuDto;
import com.restaurant.restaurant.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
     @PostMapping("/create")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu){
       Menu savedMenu =  menuService.createMenu(menu);
        return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
    }
    @GetMapping("/read")
    public ResponseEntity<List<Menu>> getAllMenu(){
         return new ResponseEntity<>(menuService.getAllMenu(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeById(@PathVariable("id") int menuId){
         return new ResponseEntity<>(menuService.removeMenu(menuId),HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable int id , @RequestBody MenuDto menuDto){
          return new ResponseEntity<>(menuService.updateMenu(id,menuDto),HttpStatus.OK);
    }


}
