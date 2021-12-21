package com.receptionist.receptionistservice.repository;


import com.receptionist.receptionistservice.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends MongoRepository<Guest, Long> {

}
