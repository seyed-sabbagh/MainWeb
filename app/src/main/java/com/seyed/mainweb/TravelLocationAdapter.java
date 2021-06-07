package com.seyed.mainweb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.travelLocationViewHolder> {

    private final List<TravelLocation> travelLocations;

    public TravelLocationAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public travelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new travelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationAdapter.travelLocationViewHolder holder, int position) {
        holder.setLocationData(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    static class travelLocationViewHolder extends RecyclerView.ViewHolder {
        private final ImageView kenBurnsView;
        private final TextView textCity;

        travelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kenBurnsView = itemView.findViewById(R.id.kbvLocation);
            textCity = itemView.findViewById(R.id.txtCity);

        }

        void setLocationData(TravelLocation travelLocation) {
            Picasso.get().load(travelLocation.imageUrl).into(kenBurnsView);
            textCity.setText(travelLocation.cityName);
        }
    }
}
