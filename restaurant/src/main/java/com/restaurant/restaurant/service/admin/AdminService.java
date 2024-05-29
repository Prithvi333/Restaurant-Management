package com.restaurant.restaurant.service.admin;

import com.restaurant.restaurant.entity.Admin;
import com.restaurant.restaurant.utility.AdminDto;

import java.util.List;

public interface AdminService {
    Admin createAdmin(Admin admin);
    List<Admin> getAllAdmin();
    String deleteAdmin(int adminId);
    Admin updateAdmin(int adminId, AdminDto adminDto);
}
