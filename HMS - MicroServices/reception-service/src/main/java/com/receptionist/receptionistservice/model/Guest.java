package com.receptionist.receptionistservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "guest1")
public class Guest {

    @Id
    private Long id; //member code
    @Field
    private String guestName; // guest name
    @Field
    private Long phoneNo; // phone number
    @Field
    private String companyName; //company name
    @Field
    private String eMail; //email
    @Field
    private String guestGender; //gender
    @Field
    private String guestAdd; // guest address
    @Field
    private Long roomNo;
    @Field
    private String checkIn;
    @Field
    private String checkOut;
    @Field
    private Long price;


    public Guest(){

    }

    public Guest(String guestName, Long phoneNo, String companyName, String eMail, String guestGender, String guestAdd) {
        this.guestName = guestName;
        this.phoneNo = phoneNo;
        this.companyName = companyName;
        this.eMail = eMail;
        this.guestGender = guestGender;
        this.guestAdd = guestAdd;
    }

    public Guest(Long id, String guestName, Long phoneNo, String companyName, String eMail, String guestGender, String guestAdd,
                 Long roomNo, String checkIn, String checkOut, Long price) {
        this.id = id;
        this.guestName = guestName;
        this.phoneNo = phoneNo;
        this.companyName = companyName;
        this.eMail = eMail;
        this.guestGender = guestGender;
        this.guestAdd = guestAdd;
        this.roomNo = roomNo;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(String guestGender) {
        this.guestGender = guestGender;
    }

    public String getGuestAdd() {
        return guestAdd;
    }

    public void setGuestAdd(String guestAdd) {
        this.guestAdd = guestAdd;
    }

    public Long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Long roomNo) {
        this.roomNo = roomNo;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", phoneNo=" + phoneNo +
                ", companyName='" + companyName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", guestGender='" + guestGender + '\'' +
                ", guestAdd='" + guestAdd + '\'' +
                ", roomNo=" + roomNo +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", price=" + price +
                '}';
    }
}






