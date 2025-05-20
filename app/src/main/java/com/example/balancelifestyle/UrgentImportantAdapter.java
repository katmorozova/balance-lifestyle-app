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

public class UrgentImportantAdapter extends RecyclerView.Adapter<UrgentImportantAdapter.UrgentImportantViewHolder>{

    private List<NoteMatrix> noteMatrixList = new ArrayList<>();

    public List<NoteMatrix> getNoteMatrixList() {
        return noteMatrixList;
    }

    public void setNoteMatrixList(List<NoteMatrix> noteMatrixList) {
        this.noteMatrixList = noteMatrixList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UrgentImportantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.note_matrix_item,
                parent,
                false
        );
        return new UrgentImportantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UrgentImportantViewHolder viewHolder, int position) {
        NoteMatrix noteMatrix = noteMatrixList.get(position);
        viewHolder.textViewNoteMatrix.setText(noteMatrix.getText());
    }

    @Override
    public int getItemCount() {
        return noteMatrixList.size();
    }


    class UrgentImportantViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewNoteMatrix;

        public UrgentImportantViewHolder(@NonNull View itemView){
            super(itemView);
            textViewNoteMatrix = itemView.findViewById(R.id.textViewNoteMatrix);
        }
    }


}
