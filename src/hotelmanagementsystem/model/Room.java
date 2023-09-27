/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Room {
    private int roomCount;
    private String roomNumber;
    private String roomType;
    private String floorNumber;
    private String roomStatus;
    private double price;
    private LocalDate lastUpdated;
    
    public Room(){
    }
    
    public Room(int count,String status){
        this.roomCount = count;
        this.roomStatus = status;
    }
    
    public Room(String roomNumber, String roomType, String floorNumber, String roomStatus, double price, LocalDate lastUpdated){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floorNumber = floorNumber;
        this.roomStatus = roomStatus;
        this.price = price;
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the roomNumber
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return the roomType
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * @return the floorNumber
     */
    public String getFloorNumber() {
        return floorNumber;
    }

    /**
     * @param floorNumber the floorNumber to set
     */
    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * @return the roomStatus
     */
    public String getRoomStatus() {
        return roomStatus;
    }

    /**
     * @param roomStatus the roomStatus to set
     */
    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
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

    /**
     * @return the roomCount
     */
    public int getRoomCount() {
        return roomCount;
    }

    /**
     * @param roomCount the roomCount to set
     */
    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }
}
