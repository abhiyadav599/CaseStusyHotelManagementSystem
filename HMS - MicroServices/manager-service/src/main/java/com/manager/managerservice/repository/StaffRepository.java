package com.manager.managerservice.repository;

import com.manager.managerservice.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<Staff, Long> {



}
