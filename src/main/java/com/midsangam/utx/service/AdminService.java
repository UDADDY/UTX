package com.midsangam.utx.service;

import com.midsangam.utx.entity.Admin;
import com.midsangam.utx.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void create(Admin admin) {
        adminRepository.save(admin);
    }

    public Admin readById(int adminId) {
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if(!adminOptional.isPresent())
            return null;
        return adminOptional.get();
    }

    public List<Admin> readAll(){
        List<Admin> adminList = adminRepository.findAll();
        return adminList;
    }

    public void update(Admin admin) {
        adminRepository.save(admin);
    }

    public void deleteById(int adminId) {
        adminRepository.deleteById(adminId);
    }

}
