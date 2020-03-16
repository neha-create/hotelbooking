package com.hotelbooking.BO;

public class Description {
	private String lang;

    private String text;

    public void setLang(String lang){
        this.lang = lang;
    }
    public String getLang(){
        return this.lang;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
}
