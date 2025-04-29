package com.example.balancelifestyle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.NoteMatrix;

import java.util.ArrayList;
import java.util.List;

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.GoalsHolder>{

    private List<NoteMatrix> noteMatrices = new ArrayList<>();
    private String category; // Nueva variable para filtrar notas por categoría


    public GoalsAdapter(String category) {
        this.category = category;
    }

    public List<NoteMatrix> getNoteMatrices() {
        return noteMatrices;
    }

    public void setNoteMatrices(List<NoteMatrix> noteMatrices) {
        this.noteMatrices = noteMatrices;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GoalsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.note_matrix,
                parent,
                false
        );
        return new GoalsAdapter.GoalsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoalsHolder viewHolder, int position) {
        NoteMatrix noteMatrix = noteMatrices.get(position);
        viewHolder.textViewNoteMatrix.setText(noteMatrix.getText());

    }

    @Override
    public int getItemCount() {
        return noteMatrices.size();
    }

    class GoalsHolder extends RecyclerView.ViewHolder{

        private TextView textViewNoteMatrix;

        public GoalsHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoteMatrix = itemView.findViewById(R.id.textViewNoteMatrix);
        }
    }
}
