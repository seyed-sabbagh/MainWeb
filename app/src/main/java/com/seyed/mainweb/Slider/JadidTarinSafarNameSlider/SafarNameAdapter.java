package com.seyed.mainweb.Slider.JadidTarinSafarNameSlider;

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


public class SafarNameAdapter extends RecyclerView.Adapter<SafarNameAdapter.TravelLocationViewHolder> {
    private List<ItemContainerSafarnameSlider> itemContainerSafarnameSliders;

    public SafarNameAdapter(List<ItemContainerSafarnameSlider> itemContainerSafarnameSliders) {
        this.itemContainerSafarnameSliders = itemContainerSafarnameSliders;
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
    public void onBindViewHolder(@NonNull @NotNull SafarNameAdapter.TravelLocationViewHolder holder, int position) {
        holder.SetLocationData(itemContainerSafarnameSliders.get(position));
    }

    @Override
    public int getItemCount() {
        return itemContainerSafarnameSliders.size();
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

        void SetLocationData(ItemContainerSafarnameSlider itemContainerSafarnameSlider) {

            Picasso.get().load(itemContainerSafarnameSlider.ImageURL).into(Image);
            txtTitleCityNam.setText(itemContainerSafarnameSlider.cityName);
            textViewNaghd.setText(itemContainerSafarnameSlider.tedadNaghd);
            Log.d("TAG", "SetLocationData: " + itemContainerSafarnameSlider.cityName);
        }
    }

}
