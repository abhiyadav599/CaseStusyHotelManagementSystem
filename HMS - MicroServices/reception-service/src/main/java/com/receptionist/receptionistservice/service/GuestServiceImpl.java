package com.receptionist.receptionistservice.service;

import com.receptionist.receptionistservice.exception.ResourceNotFoundException;
import com.receptionist.receptionistservice.model.Guest;
import com.receptionist.receptionistservice.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GuestServiceImpl implements GuestService{

    private final GuestRepository guestRepository;

    //autowiring the guest repository which works as the layer between database serviceimpl
    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }

    //add guest
    @Override
    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    //get all guest
    @Override
    public List<Guest> getGuest(){
        return guestRepository.findAll();
    }

    //get guest by id
    @Override
    public ResponseEntity<Guest> getGuestById(Long id){
        Guest guest = guestRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + id));
        return ResponseEntity.ok(guest);
    }

    //update guest
    @Override
    public ResponseEntity<Guest> updateGuest(Long id, Guest guestDetails){
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + id));

        //used to fill the fields in updating form
        guest.setGuestName(guestDetails.getGuestName());
        guest.setPhoneNo(guestDetails.getPhoneNo());
        guest.setCompanyName(guestDetails.getCompanyName());
        guest.seteMail(guestDetails.geteMail());
        guest.setGuestGender(guestDetails.getGuestGender());
        guest.setGuestAdd(guestDetails.getGuestAdd());

        Guest updatedGuest = guestRepository.save(guest);
        return ResponseEntity.ok(updatedGuest);
    }

    //delete guest
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteGuest(Long id){
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + id));

        guestRepository.delete(guest);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
