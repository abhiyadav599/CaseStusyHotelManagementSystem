package com.manager.managerservice.controller;

import com.manager.managerservice.model.Staff;
import com.manager.managerservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public class StaffController {

    @Autowired
    private StaffService staffService  ;

//    @Autowired
//    private RestTemplate restTemplate;

    // get all staff
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/staff")
    public List<Staff> getStaff(){
        return staffService.getStaff();
    }

    // create new staff using rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/staff")
    public Staff saveStaff(@RequestBody Staff staff){
        return staffService.saveStaff(staff);
    }

    // get all staff by id rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/staff/{code}")
    public ResponseEntity<Staff> getStaff(@PathVariable Long code){
        return staffService.getStaffById(code);
    }

    // update staff rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/staff/{code}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long code, @RequestBody Staff staffDetails){
        return staffService.updateStaff(code, staffDetails);
    }

    // delete staff rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/staff/{code}")
    public ResponseEntity<Map<String, Boolean>> deleteGuest(@PathVariable Long code){
        return staffService.deleteStaff(code);
    }


}
