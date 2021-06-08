package com.seyed.mainweb.SliderCity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seyed.mainweb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CitySliderAdapter extends RecyclerView.Adapter<CitySliderAdapter.travelLocationViewHolder> {

    private final List<ItemContainerCity> itemContainerCities;

    public CitySliderAdapter(List<ItemContainerCity> itemContainerCities) {
        this.itemContainerCities = itemContainerCities;
    }

    @NonNull
    @Override
    public travelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new travelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_cityname,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CitySliderAdapter.travelLocationViewHolder holder, int position) {
        holder.setLocationData(itemContainerCities.get(position));
    }

    @Override
    public int getItemCount() {
        return itemContainerCities.size();
    }

    static class travelLocationViewHolder extends RecyclerView.ViewHolder {
        private final ImageView kenBurnsView;
        private final TextView textCity;

        travelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kenBurnsView = itemView.findViewById(R.id.kbvLocation);
            textCity = itemView.findViewById(R.id.txtCity);

        }

        void setLocationData(ItemContainerCity itemContainerCity) {
            Picasso.get().load(itemContainerCity.imageUrl).into(kenBurnsView);
            textCity.setText(itemContainerCity.cityName);
        }
    }
}
