package com.driver.UberApplication.Service;

import com.driver.UberApplication.model.Admin;
import com.driver.UberApplication.model.Customer;
import com.driver.UberApplication.model.Driver;

import java.util.List;

public interface AdminService {
    public void adminRegister(Admin admin);

    public Admin updatePassword(Integer adminId, String password);

    public void deleteAdmin(int adminId);

    public List<Driver> getListOfDrivers();

    public List<Customer> getListOfCustomers();

}
