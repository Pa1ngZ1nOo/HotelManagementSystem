/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem.model;

/**
 *
 * @author Lenovo
 */
public class Floor {
    private String floorNo;
    private int count;
    private String roomType;
    
    public Floor(){
    
    }
    
    public Floor(String floorNo, int count, String type){
        this.floorNo = floorNo;
        this.count = count;
        this.roomType = type;
    }

    /**
     * @return the floorNo
     */
    public String getFloorNo() {
        return floorNo;
    }

    /**
     * @param floorNo the floorNo to set
     */
    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
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
}
