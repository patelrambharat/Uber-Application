package com.driver.UberApplication.Service;

import com.driver.UberApplication.model.Customer;
import com.driver.UberApplication.model.TripBooking;

public interface CustomerService {
    public void register(Customer customer);

    public void deleteCustomer(Integer customerId);

    public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception;

    public void cancelTrip(Integer tripId);

    public void completeTrip(Integer tripId);
}
