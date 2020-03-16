package com.hotelbooking.BO;

public class Room
{
    private String type;

    private TypeEstimated typeEstimated;

    private Description description;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setTypeEstimated(TypeEstimated typeEstimated){
        this.typeEstimated = typeEstimated;
    }
    public TypeEstimated getTypeEstimated(){
        return this.typeEstimated;
    }
    public void setDescription(Description description){
        this.description = description;
    }
    public Description getDescription(){
        return this.description;
    }
}
