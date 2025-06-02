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

public class DoNowAdapter extends RecyclerView.Adapter<DoNowAdapter.DoNowViewHolder>{

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
    public DoNowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.do_now_item,
                parent,
                false
        );

        return new DoNowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoNowViewHolder viewHolder, int position) {
        NotesMatrixList notesMatrixList = notesMatrixLists.get(position);
        viewHolder.textViewNoteDoNowMatrix.setText(notesMatrixList.getText());
    }

    @Override
    public int getItemCount() {
        return notesMatrixLists.size();
    }


    class DoNowViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNoteDoNowMatrix;

        public DoNowViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoteDoNowMatrix = itemView.findViewById(R.id.textViewNoteDoNowMatrix);
        }
    }
}
