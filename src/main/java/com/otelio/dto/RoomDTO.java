package com.otelio.dto;

import com.otelio.model.RoomType;

public class RoomDTO {

    private String number;
    private RoomType type;
    private double price;
    private Long hotelId;

    public RoomDTO() {}

    public RoomDTO(String number, RoomType type, double price, Long hotelId) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.hotelId = hotelId;
    }

    // Getters & Setters
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public RoomType getType() { return type; }
    public void setType(RoomType type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Long getHotelId() { return hotelId; }
    public void setHotelId(Long hotelId) { this.hotelId = hotelId; }
}
