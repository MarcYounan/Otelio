package com.otelio.model;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;   

    @Enumerated(EnumType.STRING)
    private RoomType type;      

    private double price;

    
    @ManyToOne
    @JoinColumn(name = "hotel_id") 
    private Hotel hotel;

    public Room() {}

    public Room(String number, RoomType type, double price, Hotel hotel) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.hotel = hotel;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public RoomType getType() { return type; }
    public void setType(RoomType type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }
}
