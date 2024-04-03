package com.driver.UberApplication.Controller;

import com.driver.UberApplication.Service.impl.AdminServiceImpl;
import com.driver.UberApplication.model.Admin;
import com.driver.UberApplication.model.Customer;
import com.driver.UberApplication.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServiceImpl adminServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<Void> registerAdmin(@RequestBody Admin admin){
        adminServiceImpl.adminRegister(admin);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Admin> updateAdminPassword(@RequestParam Integer adminId, @RequestParam String password){
        Admin updatedAdmin = adminServiceImpl.updatePassword(adminId,password);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public void deleteAdmin(@RequestParam Integer adminId){
        adminServiceImpl.deleteAdmin(adminId);
    }
    @GetMapping("/listOfCustomers")
    public List<Customer> listOfCustomers() {
        return adminServiceImpl.getListOfCustomers();
    }
    @GetMapping("/listOfDrivers")
    public List<Driver> listOfDrivers() {
        return adminServiceImpl.getListOfDrivers();
    }
}
