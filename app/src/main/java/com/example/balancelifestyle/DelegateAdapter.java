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

public class DelegateAdapter extends RecyclerView.Adapter<DelegateAdapter.DelegateViewHolder>{

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
    public DelegateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.delegate_item,
                parent,
                false
        );
        return new DelegateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DelegateViewHolder viewHolder, int position) {
        NotesMatrixList notesMatrixList = notesMatrixLists.get(position);
        viewHolder.textViewNoteDelegateMatrix.setText(notesMatrixList.getText());
    }

    @Override
    public int getItemCount() {
        return notesMatrixLists.size();
    }

    class DelegateViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNoteDelegateMatrix;

        public DelegateViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoteDelegateMatrix = itemView.findViewById(R.id.textViewNoteDelegateMatrix);
        }
    }


}
