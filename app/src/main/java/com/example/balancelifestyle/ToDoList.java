package com.example.balancelifestyle;

public class ToDoList {

    private int id;
    private String text;
    private int typeOfList;

    public ToDoList(int id, String text, int typeOfList) {
        this.id = id;
        this.text = text;
        this.typeOfList = typeOfList;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getTypeOfList() {
        return typeOfList;
    }
}
