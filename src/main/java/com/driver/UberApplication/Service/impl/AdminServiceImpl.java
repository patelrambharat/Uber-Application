package com.driver.UberApplication.Service.impl;

import com.driver.UberApplication.Repository.AdminRepository;
import com.driver.UberApplication.Repository.CustomerRepository;
import com.driver.UberApplication.Repository.DriverRepository;
import com.driver.UberApplication.Service.AdminService;
import com.driver.UberApplication.model.Admin;
import com.driver.UberApplication.model.Customer;
import com.driver.UberApplication.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    DriverRepository driverRepository1;

    @Autowired
    CustomerRepository customerRepository1;

    @Override
    public void adminRegister(Admin admin) {
        //Save the admin in the database
        adminRepository1.save(admin);
    }
    @Override
    public Admin updatePassword(Integer adminId , String password){
        //Update the password of admin with given id
        Admin admin = adminRepository1.findById(adminId).get();
        admin.setPassword(password);
        adminRepository1.save(admin);

        return admin;
    }

    @Override
    public void deleteAdmin(int adminId) {
        Admin admin = adminRepository1.findById(adminId).get();
        adminRepository1.delete(admin);
    }

    @Override
    public List<Driver> getListOfDrivers() {
        //Find the list of all drivers
        return driverRepository1.findAll();
    }

    @Override
    public List<Customer> getListOfCustomers() {
        return customerRepository1.findAll();
    }

}
