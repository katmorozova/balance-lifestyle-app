package com.example.balancelifestyle;

public class WishList {

    private int id;
    private String text;
    private String typeOfCategory;

    public WishList(int id, String text, String typeOfCategory){
        this.id = id;
        this.text = text;
        this.typeOfCategory = typeOfCategory;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTypeOfCategory() {
        return typeOfCategory;
    }
}
