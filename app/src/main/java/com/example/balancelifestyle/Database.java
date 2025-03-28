package com.example.balancelifestyle;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Habit> habits = new ArrayList<>();

    public void add(Habit habit){
        habits.add(habit);
    }

    public void remove(int id){
        for(int i = 0; i < habits.size(); i++){
            Habit habit = habits.get(i);
        }
    }
}
