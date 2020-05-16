package com.zbamba.dev.housecatalog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private enum houseTypology {
        Flat,
        House,
        Loft,
        Mansion
    }

    private enum dealTypology {
        Buy,
        Rent
    }

    private String houseType;
    private String dealType;
    private int rooms;
    private int bathrooms;
    private float price;
    private String city;
    private String country;
    private String url;

    protected House() {}

    public House(String houseType, String dealType, int rooms, int bathrooms, float price, String city, String country, String url) {
        this.houseType = houseType;
        this.dealType = dealType;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.price = price;
        this.city = city;
        this.country = country;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getHouseType() {
        return houseType;
    }

    public String getDealType() {
        return dealType;
    }

    public int getRooms() {
        return rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public float getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return url;
    }
}
