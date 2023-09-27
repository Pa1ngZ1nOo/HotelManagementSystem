/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem.model;

import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String nrcNo;
    private String passportNo;
    private String gender;
    private String address;
    private String country;
    private String nationality;
    private String phoneNo;
    private LocalDate birthday;
    private String specialRemark;
    
    public Customer(int cid, String fName, String lName, String nrc, String passport, String gender, String address, String country, String nationality, String phoneNo, LocalDate birthday, String remark){
        this.customerID = cid;
        this.firstName = fName;
        this.lastName = lName;
        this.nrcNo = nrc;
        this.passportNo = passport;
        this.gender = gender;
        this.address = address;
        this.country = country;
        this.nationality = nationality;
        this.phoneNo = phoneNo;
        this.birthday = birthday;
        this.specialRemark = remark;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the nrcNo
     */
    public String getNrcNo() {
        return nrcNo;
    }

    /**
     * @param nrcNo the nrcNo to set
     */
    public void setNrcNo(String nrcNo) {
        this.nrcNo = nrcNo;
    }

    /**
     * @return the passportNo
     */
    public String getPassportNo() {
        return passportNo;
    }

    /**
     * @param passportNo the passportNo to set
     */
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the specialRemark
     */
    public String getSpecialRemark() {
        return specialRemark;
    }

    /**
     * @param specialRemark the specialRemark to set
     */
    public void setSpecialRemark(String specialRemark) {
        this.specialRemark = specialRemark;
    }
}
