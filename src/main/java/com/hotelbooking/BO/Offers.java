package com.hotelbooking.BO;

public class Offers
{
    private String id;

    private String rateCode;

    private Description description;

    private String boardType;

    private Room room;

    private Guests guests;

    private Price price;


    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setRateCode(String rateCode){
        this.rateCode = rateCode;
    }
    public String getRateCode(){
        return this.rateCode;
    }
    public void setDescription(Description description){
        this.description = description;
    }
    public Description getDescription(){
        return this.description;
    }
    public void setBoardType(String boardType){
        this.boardType = boardType;
    }
    public String getBoardType(){
        return this.boardType;
    }
    public void setRoom(Room room){
        this.room = room;
    }
    public Room getRoom(){
        return this.room;
    }
    public void setGuests(Guests guests){
        this.guests = guests;
    }
    public Guests getGuests(){
        return this.guests;
    }
    public void setPrice(Price price){
        this.price = price;
    }
    public Price getPrice(){
        return this.price;
    }
  
}
