package com.example.balancelifestyle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.WishList;

import java.util.ArrayList;
import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.WishListViewHolder>{

    private List<WishList> wishLists = new ArrayList<>();


    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
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
        WishList wishList = wishLists.get(position);
        viewHolder.textViewTitle.setText(wishList.getText());
        viewHolder.textViewNote.setText(wishList.getText());
    }

    @Override
    public int getItemCount() {
        return wishLists.size();
    }

    class WishListViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayoutWishlist; //en teoria en este layout tenemos que pasar los valores de datos recibidos y mostrarles en pantalla
        private TextView textViewTitle;
        private TextView textViewNote;

        public WishListViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutWishlist = itemView.findViewById(R.id.linearLayoutWishList);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewNote = itemView.findViewById(R.id.textViewNote);
        }
    }
}
