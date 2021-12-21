package com.receptionist.receptionistservice.service;


import com.receptionist.receptionistservice.model.Guest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface GuestService {

    //list of all guest
    public List<Guest> getGuest();
    //add guest to database
    public Guest saveGuest(Guest guest);
    //get the guest by id
    public ResponseEntity<Guest> getGuestById(Long id);
    //update the guest details
    public ResponseEntity<Guest> updateGuest(Long id, Guest guestDetails);
    //delete the guest
    public ResponseEntity<Map<String, Boolean>> deleteGuest(Long id);

}
