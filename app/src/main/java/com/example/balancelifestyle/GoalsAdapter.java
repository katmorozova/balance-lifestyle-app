package com.example.balancelifestyle;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.NotesMatrixList;

import java.util.ArrayList;
import java.util.List;

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.NotesMatrixListHolder>{


    private List<NotesMatrixList> notesMatrixLists = new ArrayList<>();

    public List<NotesMatrixList> getNotesMatrixLists() {
        return notesMatrixLists;
    }

    public void setNotesMatrixLists(List<NotesMatrixList> notesMatrixLists) {
        this.notesMatrixLists = notesMatrixLists;
        notifyDataSetChanged();
    }

    //mostramos elementos en la pantalla
    @NonNull
    @Override
    public NotesMatrixListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        return new NotesMatrixListHolder(view);
    }


    //añade color del fondo para objetos y el texto
    @Override
    public void onBindViewHolder(@NonNull NotesMatrixListHolder viewHolder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return notesMatrixLists.get(position).getTypeOfMatrixList();
    }


    @Override
    public int getItemCount() {
        return notesMatrixLists.size();
    }


    class NotesMatrixListHolder extends RecyclerView.ViewHolder {



        public NotesMatrixListHolder(@NonNull View itemView){
            super(itemView);



        }
    }



}
