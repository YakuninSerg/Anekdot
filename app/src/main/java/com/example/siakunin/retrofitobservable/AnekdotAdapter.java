package com.example.siakunin.retrofitobservable;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by siakunin on 05.12.2017.
 */

public class AnekdotAdapter extends RecyclerView.Adapter<AnekdotAdapter.AnekdotViewHolder> {


    private List<String> anekdots;

    public AnekdotAdapter(List<String> anekdots) {
        this.anekdots = anekdots;
    }

    public void setAnekdots(List<String> anekdots) {
        this.anekdots = anekdots;
    }

    @Override
    public AnekdotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new AnekdotViewHolder(v);

    }

    @Override
    public void onBindViewHolder(AnekdotViewHolder holder, int position) {

        String anekdot = anekdots.get(position);
        holder.postView.setText(anekdot);

    }

    @Override
    public int getItemCount() {
        return anekdots.size();
    }


    public static class AnekdotViewHolder extends RecyclerView.ViewHolder{
        TextView postView;
        public AnekdotViewHolder(View itemView) {
            super(itemView);
            postView = itemView.findViewById(R.id.post_textView);
        }
    }
}
