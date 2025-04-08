package com.example.balancelifestyle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.WishListViewHolder>{


    //mostramos elementos en la pantalla
    @NonNull
    @Override
    public WishListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    //añade color del fondo para objetos y el texto
    @Override
    public void onBindViewHolder(@NonNull WishListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class WishListViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewNote;

        public WishListViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNote = itemView.findViewById(R.id.textViewNote);
        }
    }
}
