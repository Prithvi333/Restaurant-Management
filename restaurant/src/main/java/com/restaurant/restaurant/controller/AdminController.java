package com.restaurant.restaurant.controller;
import com.restaurant.restaurant.entity.Admin;
import com.restaurant.restaurant.service.admin.AdminDto;
import com.restaurant.restaurant.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }
    @GetMapping("/read")
    public ResponseEntity<List<Admin>> getAllAdmin(){
        return new ResponseEntity<>(adminService.getAllAdmin(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{adminId}")
    public  ResponseEntity<String> deleteAdmin(@PathVariable("adminId") int id){
        return new ResponseEntity<>(adminService.deleteAdmin(id),HttpStatus.OK);
    }

    @PatchMapping("/update/{adminId}")
    public  ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") int id, @RequestBody AdminDto adminDto){
        return new ResponseEntity<>(adminService.updateAdmin(id,adminDto),HttpStatus.OK);
    }
}
