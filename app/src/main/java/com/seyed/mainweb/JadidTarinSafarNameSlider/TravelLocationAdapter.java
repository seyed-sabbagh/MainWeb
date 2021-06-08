package com.seyed.mainweb.JadidTarinSafarNameSlider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seyed.mainweb.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder> {
    private List<TravelLocation> travelLocations;

    public TravelLocationAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container__safarnameslider
                        , parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TravelLocationAdapter.TravelLocationViewHolder holder, int position) {
        holder.SetLocationData(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder {

        ImageView Image;
        TextView txtTitleCityNam, textViewNaghd;

        public TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);

            Image = itemView.findViewById(R.id.kbvLocation2);
            txtTitleCityNam = itemView.findViewById(R.id.txtTitleCityNam2);
            textViewNaghd = itemView.findViewById(R.id.textViewNaghd2);
        }

        void SetLocationData(TravelLocation travelLocation) {
            Picasso.get().load(travelLocation.ImageURL).into(Image);
            txtTitleCityNam.setText(travelLocation.cityName);
            textViewNaghd.setText(travelLocation.tedadNaghd);
        }
    }

}
