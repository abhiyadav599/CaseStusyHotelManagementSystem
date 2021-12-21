package com.receptionist.receptionistservice.controller;

import com.receptionist.receptionistservice.model.Guest;
import com.receptionist.receptionistservice.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/receptionist")
public class GuestController {

    //autowiring the guest service which works as the layer between repo and controller
    @Autowired
    private GuestService guestService ;

    // get all guest
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/guest")
    public List<Guest> getGuest(){
        return guestService.getGuest();
    }

    // create new guest using rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/guest")
    public Guest saveGuest(@RequestBody Guest guest){
        return guestService.saveGuest(guest);
    }

    // get all guest by id rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/guest/{id}")
    public ResponseEntity<Guest> getGuest(@PathVariable Long id){
        return guestService.getGuestById(id);
    }

    // update employee rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/guest/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guestDetails){
        return guestService.updateGuest(id, guestDetails);
    }

    // delete employee rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/guest/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGuest(@PathVariable Long id){
        return guestService.deleteGuest(id);
    }

/*
    private final GuestRepository guestRepository;

        @Autowired
        public GuestController(GuestRepository guestRepository){
            this.guestRepository = guestRepository;
        }

    // create new guest using rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/guest")
    public Guest saveGuest(@RequestBody Guest guest){
        return guestRepository.save(guest);

//        return "added guest with id : " + guest.getId();
    }

    // get all guest
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/guest")
    public List<Guest> getGuest(){
        return guestRepository.findAll();
    }

    // get all guest by id rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/guest/{id}")
    public Optional<Guest> getGuest(@PathVariable Long id){
        return guestRepository.findById(id);
    }

    // update employee rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/guest/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guestDetails){
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        guest.setGuestName(guestDetails.getGuestName());
        guest.setPhoneNo(guestDetails.getPhoneNo());
        guest.setCompanyName(guestDetails.getCompanyName());
        guest.seteMail(guestDetails.geteMail());
        guest.setGuestGender(guestDetails.getGuestGender());
        guest.setGuestAdd(guestDetails.getGuestAdd());

        Guest updatedGuest = guestRepository.save(guest);
        return ResponseEntity.ok(updatedGuest);
    }

    // delete employee rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/guest/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGuest(@PathVariable Long id){
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + id));

        guestRepository.delete(guest);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
*/
}
