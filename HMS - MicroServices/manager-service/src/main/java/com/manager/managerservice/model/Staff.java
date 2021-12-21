package com.manager.managerservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("staff")
public class Staff {

    @Id
    public Long code;

    @Field
    public String employeeName;

    @Field
    public String employeeAdd;

    @Field
    public int nicCode;

    @Field
    public Long employeeSal;

    @Field
    public int employeeAge;

    @Field
    public String occupation;

    @Field
    public String eMail;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAdd() {
        return employeeAdd;
    }

    public void setEmployeeAdd(String employeeAdd) {
        this.employeeAdd = employeeAdd;
    }

    public int getNicCode() {
        return nicCode;
    }

    public void setNicCode(int nicCode) {
        this.nicCode = nicCode;
    }

    public Long getEmployeeSal() {
        return employeeSal;
    }

    public void setEmployeeSal(Long employeeSal) {
        this.employeeSal = employeeSal;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Staff(){

    }

    public Staff(Long code, String employeeName, String employeeAdd, int nicCode, Long employeeSal, int employeeAge, String occupation, String eMail) {
        this.code = code;
        this.employeeName = employeeName;
        this.employeeAdd = employeeAdd;
        this.nicCode = nicCode;
        this.employeeSal = employeeSal;
        this.employeeAge = employeeAge;
        this.occupation = occupation;
        this.eMail = eMail;
    }

    public Staff(String employeeName, String employeeAdd, int nicCode, Long employeeSal, int employeeAge, String occupation, String eMail) {
        this.employeeName = employeeName;
        this.employeeAdd = employeeAdd;
        this.nicCode = nicCode;
        this.employeeSal = employeeSal;
        this.employeeAge = employeeAge;
        this.occupation = occupation;
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "code=" + code +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAdd='" + employeeAdd + '\'' +
                ", nicCode=" + nicCode +
                ", employeeSal=" + employeeSal +
                ", employeeAge=" + employeeAge +
                ", occupation='" + occupation + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
