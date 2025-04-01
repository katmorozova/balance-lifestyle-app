package com.example.balancelifestyle;

import java.util.ArrayList;
import java.util.Random;

public class Database {

    private ArrayList<Habit> habits = new ArrayList<>();

    private static Database instance = null;

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Database(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            Habit habit = new Habit(i, "Habit"+i, random.nextInt(6));
            habits.add(habit);
        }
    }

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
