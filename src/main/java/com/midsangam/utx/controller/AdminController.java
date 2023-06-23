package com.midsangam.utx.controller;

import com.midsangam.utx.entity.Admin;
import com.midsangam.utx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public void create(@RequestBody Admin admin){
        adminService.create(admin);
    }

    @GetMapping("{adminId}")
    public Admin read(@PathVariable int adminId){
        Admin admin = adminService.readById(adminId);
        if(admin == null)
            return null;
        return admin;
    }

    @GetMapping("/all")
    public List<Admin> readAll(){
        List<Admin> adminList = adminService.readAll();
        return adminList;
    }

    @PutMapping
    public void update(@RequestBody Admin admin){
        adminService.update(admin);
    }

    @DeleteMapping("{adminId}")
    public void delete(@PathVariable int adminId){
        adminService.deleteById(adminId);
    }
}
