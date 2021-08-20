/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BookingDTO {
    private String bookingID;
    private String userID;
    private double totalPrice;
    private Date dateGo;
    private String status;
    private String duration;

    public BookingDTO() {
    }

    public BookingDTO(String bookingID, String userID, double totalPrice, Date dateGo, String status, String duration) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.dateGo = dateGo;
        this.status = status;
        this.duration = duration;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateGo() {
        return dateGo;
    }

    public void setDateGo(Date dateGo) {
        this.dateGo = dateGo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "BookingDTO{" + "bookingID=" + bookingID + ", userID=" + userID + ", totalPrice=" + totalPrice + ", dateGo=" + dateGo + ", status=" + status + ", duration=" + duration + '}';
    }

    
}