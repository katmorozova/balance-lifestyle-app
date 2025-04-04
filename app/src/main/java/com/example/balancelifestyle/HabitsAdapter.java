package com.example.balancelifestyle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.Habit;

import java.util.ArrayList;
import java.util.List;

public class HabitsAdapter extends RecyclerView.Adapter<HabitsAdapter.HabitsViewHolder> {

    private List<Habit> habits = new ArrayList<>();
    private OnHabitClickListener onHabitClickListener;


    public List<Habit> getHabits() {
        return new ArrayList<>(habits);
    }

    public void setOnHabitClickListener(OnHabitClickListener onHabitClickListener) {
        this.onHabitClickListener = onHabitClickListener;
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
        notifyDataSetChanged();
    }
//mostramos elementos en la pantalla
    @NonNull
    @Override
    public HabitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.habit_item,
                parent,
                false
        );
        return new HabitsViewHolder(view);
    }

    //añade color del fondo para objetos y el texto
    @Override
    public void onBindViewHolder(@NonNull HabitsViewHolder viewHolder, int position) {
        Habit habit = habits.get(position);
        viewHolder.textViewHabit.setText(habit.getText());
        int colorResId;
        switch(habit.getTypeOfHabit()){
            case 0:
                colorResId = R.color.verde_nature;
                break;
            case 1:
                colorResId = R.color.turquesa_relajante;
                break;
            case 2:
                colorResId = R.color.rosa_suave_brillante;
                break;
            case 3:
                colorResId = R.color.azul_concentracion;
                break;
            case 4:
                colorResId = R.color.morado_equilibrado;
                break;
            case 5:
                colorResId = R.color.amarillo_dorado;
                break;
            case 6:
                colorResId = R.color.gris_azulado_claro;
                break;
            default:
                colorResId = R.color.coral;
        }
        int color = ContextCompat.getColor(viewHolder.itemView.getContext(), colorResId);
        viewHolder.textViewHabit.setBackgroundColor(color);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onHabitClickListener != null){
                    onHabitClickListener.onHabitClick(habit);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return habits.size();
    }
    class HabitsViewHolder extends  RecyclerView.ViewHolder {

        private TextView textViewHabit;

        public HabitsViewHolder(@NonNull View itemView){
            super(itemView);
            textViewHabit = itemView.findViewById(R.id.textViewHabit);
        }

    }

    public interface OnHabitClickListener {
        void onHabitClick(Habit habit);
    }
}
