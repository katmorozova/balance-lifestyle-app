package com.example.balancelifestyle.database;

public class NotesMatrixList {

    private int id;
    private String text;
    private int typeOfMatrixList;

    public NotesMatrixList(int id, String text, int typeOfMatrixList){
        this.id = id;
        this.text = text;
        this.typeOfMatrixList = typeOfMatrixList;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getTypeOfMatrixList() {
        return typeOfMatrixList;
    }
}
