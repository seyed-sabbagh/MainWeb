package com.seyed.mainweb.Slider.GhazaSlider;

import android.util.Log;
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

public class GhazaAdapter extends RecyclerView.Adapter<GhazaAdapter.ViewHolder> {

    private List<ItemContainerGhazaSlider> itemContainerGhazaSliders;

    public GhazaAdapter(List<ItemContainerGhazaSlider> itemContainerGhazaSliders) {
        this.itemContainerGhazaSliders = itemContainerGhazaSliders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container__ghazaslider,
                        parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GhazaAdapter.ViewHolder holder, int position) {
        holder.SetLocationDataGHaza(itemContainerGhazaSliders.get(position));
    }

    @Override
    public int getItemCount() {
        return itemContainerGhazaSliders.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtcityGhaza, txtNaghdGhaza;
        ImageView ImgAks;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtcityGhaza = itemView.findViewById(R.id.txtcityGhaza);
            txtNaghdGhaza = itemView.findViewById(R.id.txtNaghdGhaza);
            ImgAks = itemView.findViewById(R.id.ImgAks);

        }

        void SetLocationDataGHaza(ItemContainerGhazaSlider itemContainerGhazaSlider) {


            Picasso.get().load(itemContainerGhazaSlider.ImageURL).into(ImgAks);
            txtcityGhaza.setText(itemContainerGhazaSlider.CityName);
            txtNaghdGhaza.setText(itemContainerGhazaSlider.Naghd);

            Log.d("TAG", "SetLocationDataGHaza: " + itemContainerGhazaSlider.CityName);
        }
    }
}