package com.hotelbooking.BO;

import java.util.List;
public class Data
{
    private String type;

    private Hotel hotel;

    private boolean available;

    private List<Offers> offers;

    private String self;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }
    public Hotel getHotel(){
        return this.hotel;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }
    public boolean getAvailable(){
        return this.available;
    }
    public void setOffers(List<Offers> offers){
        this.offers = offers;
    }
    public List<Offers> getOffers(){
        return this.offers;
    }
    public void setSelf(String self){
        this.self = self;
    }
    public String getSelf(){
        return this.self;
    }
}
