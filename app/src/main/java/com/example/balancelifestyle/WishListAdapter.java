package com.example.balancelifestyle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.NoteList;

import java.util.ArrayList;
import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.WishListViewHolder>{

    private List<NoteList> noteLists = new ArrayList<>();


    public List<NoteList> getNoteLists() {
        return noteLists;
    }

    public void setNoteLists(List<NoteList> noteLists) {
        this.noteLists = noteLists;
        notifyDataSetChanged();
    }

    //mostramos elementos en la pantalla
    @NonNull
    @Override
    public WishListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.note_item,
                parent,
                false
        );
        return new WishListViewHolder(view);
    }

    //añade color del fondo para objetos y el texto
    @Override
    public void onBindViewHolder(@NonNull WishListViewHolder viewHolder, int position) {
        NoteList noteList = noteLists.get(position);
        viewHolder.textViewTitle.setText(noteList.getTitle());
        viewHolder.textViewNote.setText(noteList.getText());
    }

    @Override
    public int getItemCount() {
        return noteLists.size();
    }

    class WishListViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitle;
        private TextView textViewNote;

        public WishListViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewNote = itemView.findViewById(R.id.textViewNote);
        }
    }
}
