package com.example.balancelifestyle;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HabitsAdapter extends RecyclerView.Adapter<> {

    private ArrayList<Habit> habits = new ArrayList<>();

    public void setHabits(ArrayList<Habit> habits) {
        this.habits = habits;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return habits.size();
    }
}
