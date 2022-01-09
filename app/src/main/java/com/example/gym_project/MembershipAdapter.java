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

import java.util.List;

public class MembershipAdapter extends RecyclerView.Adapter<MembershipAdapter.ViewHolder> {
    private Context context;
    private List<Membership> items;


    public MembershipAdapter(Context context, List<Membership> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardimage,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Membership mem = items.get(position);
        CardView cardView = holder.cardView;

        TextView name = (TextView)cardView.findViewById(R.id.name);
        name.setText(mem.getMname());
        TextView length = (TextView)cardView.findViewById(R.id.length);
        length.setText(mem.getMlength());
        TextView price = (TextView)cardView.findViewById(R.id.price);
        price.setText(mem.getPrice());

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
