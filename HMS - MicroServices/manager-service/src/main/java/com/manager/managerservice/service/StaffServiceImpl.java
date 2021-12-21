package com.manager.managerservice.service;

import com.manager.managerservice.exception.ResourceNotFoundException;
import com.manager.managerservice.model.Staff;
import com.manager.managerservice.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService{


    private StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    // add staff
    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    //get all staff
    @Override
    public List<Staff> getStaff(){
        return staffRepository.findAll();
    }

    //get guest by code
    @Override
    public ResponseEntity<Staff> getStaffById(Long code){
        Staff staff = staffRepository.findById(code).
                orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + code));
        return ResponseEntity.ok(staff);
    }

    //update guest
    @Override
    public ResponseEntity<Staff> updateStaff(Long code, Staff staffDetails){
        Staff staff = staffRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + code));

        //used to fill the fields in updating form
        staff.setEmployeeName(staffDetails.getEmployeeName());
        staff.setEmployeeAdd(staffDetails.getEmployeeAdd());
        staff.setNicCode(staffDetails.getNicCode());
        staff.setEmployeeSal(staffDetails.getEmployeeSal());
        staff.setEmployeeAge(staffDetails.getEmployeeAge());
        staff.setOccupation(staffDetails.getOccupation());
        staff.seteMail(staffDetails.geteMail());

        Staff updatedGuest = staffRepository.save(staff);
        return ResponseEntity.ok(updatedGuest);
    }

    //delete guest
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteStaff(Long code){
        Staff staff = staffRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + code));

        staffRepository.delete(staff);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }




}
