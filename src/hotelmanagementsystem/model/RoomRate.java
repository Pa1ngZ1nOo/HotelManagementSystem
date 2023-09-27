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
public class RoomRate {
    private String rateCd;
    private String rateCdNm;
    private String roomType;
    private double priceMMR;
    private double priceDollar;
    private LocalDate lastUpdated;
    
    public RoomRate(){
    
    }
    
    public RoomRate(String rateCd, String rateCdNm, String roomType, double pricemmr, double pricedollar, LocalDate lastUpdated){
        this.rateCd = rateCd;
        this.rateCdNm = rateCdNm;
        this.roomType = roomType;
        this.priceMMR = pricemmr;
        this.priceDollar = pricedollar;
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the rateCd
     */
    public String getRateCd() {
        return rateCd;
    }

    /**
     * @param rateCd the rateCd to set
     */
    public void setRateCd(String rateCd) {
        this.rateCd = rateCd;
    }

    /**
     * @return the rateCdNm
     */
    public String getRateCdNm() {
        return rateCdNm;
    }

    /**
     * @param rateCdNm the rateCdNm to set
     */
    public void setRateCdNm(String rateCdNm) {
        this.rateCdNm = rateCdNm;
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
     * @return the priceMMR
     */
    public double getPriceMMR() {
        return priceMMR;
    }

    /**
     * @param priceMMR the priceMMR to set
     */
    public void setPriceMMR(double priceMMR) {
        this.priceMMR = priceMMR;
    }

    /**
     * @return the priceDollar
     */
    public double getPriceDollar() {
        return priceDollar;
    }

    /**
     * @param priceDollar the priceDollar to set
     */
    public void setPriceDollar(double priceDollar) {
        this.priceDollar = priceDollar;
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
