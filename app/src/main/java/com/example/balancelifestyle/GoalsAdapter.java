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
        View view;
        switch (viewType) {
            case 0:
            view = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.do_now_item,
                    parent,
                    false
            );
            break;
            case 1:
            view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.planning_item,
                    parent,
                    false
            );
            break;
            case 2:
            view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.delegate_item,
                    parent,
                    false
            );
            break;
            case 3:
            view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.delete_item,
                    parent,
                    false
            );
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
        return new NotesMatrixListHolder(view);
    }


    //añade color del fondo para objetos y el texto
    @Override
    public void onBindViewHolder(@NonNull NotesMatrixListHolder viewHolder, int position) {

        NotesMatrixList notesMatrixList = notesMatrixLists.get(position);
        switch (notesMatrixList.getTypeOfMatrixList()){
            case 0:
                viewHolder.textViewNoteDoNowMatrix.setText(notesMatrixList.getText());
                break;
            case 1:
                viewHolder.textViewNotePlanningMatrix.setText(notesMatrixList.getText());
                break;
            case 2:
                viewHolder.textViewNoteDelegateMatrix.setText(notesMatrixList.getText());
                break;
            case 3:
                viewHolder.textViewNoteDeleteMatrix.setText(notesMatrixList.getText());
                break;

        }

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

        private TextView textViewNoteDoNowMatrix;
        private TextView textViewNotePlanningMatrix;
        private TextView textViewNoteDelegateMatrix;
        private TextView textViewNoteDeleteMatrix;

        public NotesMatrixListHolder(@NonNull View itemView){
            super(itemView);
            textViewNoteDoNowMatrix = itemView.findViewById(R.id.textViewNoteDoNowMatrix);
            textViewNotePlanningMatrix = itemView.findViewById(R.id.textViewNotePlanningMatrix);
            textViewNoteDelegateMatrix = itemView.findViewById(R.id.textViewNoteDelegateMatrix);
            textViewNoteDeleteMatrix = itemView.findViewById(R.id.textViewNoteDeleteMatrix);

        }
    }



}
