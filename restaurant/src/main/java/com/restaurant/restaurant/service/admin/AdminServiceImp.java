package com.restaurant.restaurant.service.admin;

import com.restaurant.restaurant.entity.Admin;
import com.restaurant.restaurant.exception.adminex.AdminNotFound;
import com.restaurant.restaurant.exception.adminex.EmptyAdminList;
import com.restaurant.restaurant.repository.AdminRepo;
import com.restaurant.restaurant.utility.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService{

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Admin createAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole("ROLE_"+admin.getRole().toUpperCase());
        return adminRepo.save(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {

        List<Admin> adminList = adminRepo.findAll();
        if(adminList.isEmpty())
            throw new EmptyAdminList();
        return adminList;

    }

    @Override
    public String deleteAdmin(int adminId) {
        Optional<Admin> admin = adminRepo.findById(adminId);
        if(admin.isEmpty()){
            throw new AdminNotFound();
        }

        adminRepo.delete(admin.get());
        return "Admin with id "+adminId+" deleted successfully";
    }

    @Override
    public Admin updateAdmin(int adminId, AdminDto adminDto) {
        Optional<Admin> admin = adminRepo.findById(adminId);
        if(admin.isEmpty()){
            throw new AdminNotFound();
        }
        Admin validAdmin = admin.get();
        validAdmin.setName(adminDto.getName());
        validAdmin.setRole("ROLE_"+adminDto.getRole());
        return adminRepo.save(validAdmin);
    }
}
