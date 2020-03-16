package com.hotelbooking.BO;

public class Price
{
    private String currency;

    private String total;

    private Variations variations;

    public void setCurrency(String currency){
        this.currency = currency;
    }
    public String getCurrency(){
        return this.currency;
    }
    public void setTotal(String total){
        this.total = total;
    }
    public String getTotal(){
        return this.total;
    }
    public void setVariations(Variations variations){
        this.variations = variations;
    }
    public Variations getVariations(){
        return this.variations;
    }
}
