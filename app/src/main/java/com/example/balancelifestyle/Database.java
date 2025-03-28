package com.example.balancelifestyle;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private ArrayList<Habit> habits = new ArrayList<>();

    public void add(Habit habit){
        habits.add(habit);
    }

    public void remove(int id){
        for(int i = 0; i < habits.size(); i++){
            Habit habit = habits.get(i);
            if(habit.getId() == id){
                habits.remove(habit);
            }
        }
    }

    public ArrayList<Habit> getHabits() {
        return new ArrayList<>(habits);
    }
}
