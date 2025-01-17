package com.driver.UberApplication.Controller;

import com.driver.UberApplication.Service.impl.CustomerServiceImpl;
import com.driver.UberApplication.model.Customer;
import com.driver.UberApplication.model.TripBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;
    @PostMapping("/register")
    public ResponseEntity<Void> registerCustomer(@RequestBody Customer customer){
        customerServiceImpl.register(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestParam Integer customerId){
        customerServiceImpl.deleteCustomer(customerId);
    }

    @PostMapping("/bookTrip")
    public ResponseEntity<Integer> bookTrip(@RequestParam Integer customerId, @RequestParam String fromLocation, @RequestParam String toLocation, @RequestParam Integer distanceInKm) throws Exception {
        TripBooking bookedTrip = customerServiceImpl.bookTrip(customerId,fromLocation,toLocation,distanceInKm);
        return new ResponseEntity<>(bookedTrip.getTripBookingId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/complete")
    public void completeTrip(@RequestParam Integer tripId){
        customerServiceImpl.completeTrip(tripId);
    }

    @DeleteMapping("/cancelTrip")
    public void cancelTrip(@RequestParam Integer tripId){
        customerServiceImpl.cancelTrip(tripId);
    }
}
