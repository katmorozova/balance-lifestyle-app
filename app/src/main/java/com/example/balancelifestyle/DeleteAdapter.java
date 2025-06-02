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

public class DeleteAdapter extends RecyclerView.Adapter<DeleteAdapter.DeleteViewHolder>{

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
    public DeleteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.delete_item,
                parent,
                false
        );
        return new DeleteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeleteViewHolder viewHolder, int position) {
        NotesMatrixList notesMatrixList = notesMatrixLists.get(position);
        viewHolder.textViewNoteDeleteMatrix.setText(notesMatrixList.getText());
    }

    @Override
    public int getItemCount() {
        return notesMatrixLists.size();
    }

    class DeleteViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNoteDeleteMatrix;

        public DeleteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoteDeleteMatrix = itemView.findViewById(R.id.textViewNoteDeleteMatrix);
        }
    }


}
