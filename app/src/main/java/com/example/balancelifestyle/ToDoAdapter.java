package com.example.balancelifestyle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.ToDoList;

import java.util.ArrayList;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoListViewHolder>{

    private List<ToDoList> toDoLists = new ArrayList<>();


    public List<ToDoList> getToDoLists() {
        return toDoLists;
    }

    public void setToDoLists(List<ToDoList> toDoLists) {
        this.toDoLists = toDoLists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ToDoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.to_do_item,
                parent,
                false
        );
        return new ToDoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoListViewHolder viewHolder, int position) {
        ToDoList toDoList = toDoLists.get(position);
        viewHolder.textViewToDoList.setText(toDoList.getText());
        int colorResId;
        switch (toDoList.getTypeOfList()){
            case 0:
                colorResId = R.color.red_high;
                break;
            case 1:
                colorResId = R.color.yellow_medium;
                break;
            case 2:
                colorResId = R.color.green_low;
                break;
            default:
                colorResId = R.color.turquesa_relajante;
        }
        int color = ContextCompat.getColor(viewHolder.itemView.getContext(), colorResId);
        viewHolder.textViewToDoList.setBackgroundColor(color);

    }



    @Override
    public int getItemCount() {
        return toDoLists.size();
    }

    class ToDoListViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewToDoList;

        public ToDoListViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewToDoList = itemView.findViewById(R.id.textViewToDoList);
        }
    }
}
