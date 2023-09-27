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
public class Group {
    private String groupID;
    private String groupNm;
    private String email;
    private String phoneNo;
    private String address;
    private String specialRemark;
    private LocalDate lastUpdated;
    
    public Group(){
    }
    
    public Group(String gpID, String gpNm, String email, String phNo, String address, String specialRemark, LocalDate lastUpdated){
        this.groupID = gpID;
        this.groupNm = gpNm;
        this.email = email;
        this.phoneNo = phNo;
        this.address = address;
        this.specialRemark = specialRemark;
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the groupID
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * @param groupID the groupID to set
     */
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    /**
     * @return the groupNm
     */
    public String getGroupNm() {
        return groupNm;
    }

    /**
     * @param groupNm the groupNm to set
     */
    public void setGroupNm(String groupNm) {
        this.groupNm = groupNm;
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
