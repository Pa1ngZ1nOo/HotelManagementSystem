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
public class Currency {
    private LocalDate date;
    private double amt;
    private LocalDate validStartDate;
    private LocalDate validEndDate;
    
    public Currency(){
    }
    
    public Currency(LocalDate date, double amount, LocalDate vsd, LocalDate ved){
        this.date = date;
        this.amt = amount;
        this.validStartDate = vsd;
        this.validEndDate = ved;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the amt
     */
    public double getAmt() {
        return amt;
    }

    /**
     * @param amt the amt to set
     */
    public void setAmt(double amt) {
        this.amt = amt;
    }

    /**
     * @return the validStartDate
     */
    public LocalDate getValidStartDate() {
        return validStartDate;
    }

    /**
     * @param validStartDate the validStartDate to set
     */
    public void setValidStartDate(LocalDate validStartDate) {
        this.validStartDate = validStartDate;
    }

    /**
     * @return the validEndDate
     */
    public LocalDate getValidEndDate() {
        return validEndDate;
    }

    /**
     * @param validEndDate the validEndDate to set
     */
    public void setValidEndDate(LocalDate validEndDate) {
        this.validEndDate = validEndDate;
    }
}
