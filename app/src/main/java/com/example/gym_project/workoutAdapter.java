package com.example.gym_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gym_project.Model.Membership;
import com.example.gym_project.Model.workouts;

import java.util.List;

public class workoutAdapter extends RecyclerView.Adapter<workoutAdapter.ViewHolder> {
    private Context context;
    private List<workouts> items;


    public workoutAdapter(Context context, List<workouts> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.worjoutcard,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final workouts workouts = items.get(position);
        CardView cardView = holder.cardView;

        TextView name = (TextView)cardView.findViewById(R.id.name);
        name.setText(workouts.getName());
        TextView text = (TextView)cardView.findViewById(R.id.text);
        text.setText(workouts.getWeeklySchedule());


        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
