package com.manager.managerservice.service;

import com.manager.managerservice.model.Staff;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StaffService{

    public List<Staff> getStaff();
    public Staff saveStaff(Staff staff);
    public ResponseEntity<Staff> getStaffById(Long code);
    public ResponseEntity<Staff> updateStaff(Long code, Staff staffDetails);
    public ResponseEntity<Map<String, Boolean>> deleteStaff(Long code);

}
