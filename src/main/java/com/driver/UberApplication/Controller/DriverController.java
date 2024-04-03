package com.driver.UberApplication.Controller;
import com.driver.UberApplication.Service.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {

    @Autowired
    DriverServiceImpl driverServiceImpl;

    @PostMapping(value = "/register")
    public ResponseEntity<Void> registerDriver(@RequestParam String mobile, @RequestParam String password) {
        driverServiceImpl.register(mobile, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public void deleteDriver(@RequestParam Integer driverId) {
        driverServiceImpl.removeDriver(driverId);
    }

    @PutMapping("/status")
    public void updateStatus(@RequestParam Integer driverId) {
        driverServiceImpl.updateStatus(driverId);
    }
}
