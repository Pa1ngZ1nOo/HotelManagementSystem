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
public class Company {

    private String companyID;
    private String companyNm;
    private String email;
    private String phoneNo;
    private String address;
    private String specialRemark;
    private LocalDate lastUpdated;

    public Company() {

    }

    public Company(String comID, String comNm, String email, String phNo, String address, String remark, LocalDate date) {
        this.companyID = comID;
        this.companyNm = comNm;
        this.email = email;
        this.phoneNo = phNo;
        this.address = address;
        this.specialRemark = remark;
        this.lastUpdated = date;
    }

    /**
     * @return the companyID
     */
    public String getCompanyID() {
        return companyID;
    }

    /**
     * @param companyID the companyID to set
     */
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    /**
     * @return the companyNm
     */
    public String getCompanyNm() {
        return companyNm;
    }

    /**
     * @param companyNm the companyNm to set
     */
    public void setCompanyNm(String companyNm) {
        this.companyNm = companyNm;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * @return the lastUpdated
     */
    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
}
