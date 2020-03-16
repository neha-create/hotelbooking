package com.hotelbooking.BO;

import java.util.List;
public class Address
{
    private List<String> lines;

    private String postalCode;

    private String cityName;

    private String countryCode;

    public void setLines(List<String> lines){
        this.lines = lines;
    }
    public List<String> getLines(){
        return this.lines;
    }
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    public String getPostalCode(){
        return this.postalCode;
    }
    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    public String getCityName(){
        return this.cityName;
    }
    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }
    public String getCountryCode(){
        return this.countryCode;
    }
}