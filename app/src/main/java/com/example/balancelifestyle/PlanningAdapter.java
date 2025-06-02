package com.example.balancelifestyle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.NotesMatrixList;

import java.util.ArrayList;
import java.util.List;

public class PlanningAdapter extends RecyclerView.Adapter<PlanningAdapter.PlanningViewHolder>{

    private List<NotesMatrixList> notesMatrixLists = new ArrayList<>();

    public List<NotesMatrixList> getNotesMatrixLists() {
        return notesMatrixLists;
    }

    public void setNotesMatrixLists(List<NotesMatrixList> notesMatrixLists) {
        this.notesMatrixLists = notesMatrixLists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlanningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.planning_item,
                parent,
                false
        );

        return new PlanningViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanningViewHolder viewHolder, int position) {
        NotesMatrixList notesMatrixList = notesMatrixLists.get(position);
        viewHolder.textViewNotePlanningMatrix.setText(notesMatrixList.getText());
    }

    @Override
    public int getItemCount() {
        return notesMatrixLists.size();
    }

    class PlanningViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNotePlanningMatrix;

        public PlanningViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNotePlanningMatrix = itemView.findViewById(R.id.textViewNotePlanningMatrix);

        }
    }

}
