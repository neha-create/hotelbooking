package com.hotelbooking.BO;

import java.util.List;
public class Variations
{
    private Average average;

    private List<Changes> changes;

    public void setAverage(Average average){
        this.average = average;
    }
    public Average getAverage(){
        return this.average;
    }
    public void setChanges(List<Changes> changes){
        this.changes = changes;
    }
    public List<Changes> getChanges(){
        return this.changes;
    }
}
