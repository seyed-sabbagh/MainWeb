package com.seyed.mainweb.Slider.tarikhifarhangiSlider;

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

public class TarikhiFarhangiAdapter extends RecyclerView.Adapter<TarikhiFarhangiAdapter.ViewHolder> {

    private List<ItemTarikhiFarhangiSlider> itemTarikhiFarhangiSliders;

    public TarikhiFarhangiAdapter(List<ItemTarikhiFarhangiSlider> itemTarikhiFarhangiSliders) {
        this.itemTarikhiFarhangiSliders = itemTarikhiFarhangiSliders;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container__tarikhifarhangi,
                        parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TarikhiFarhangiAdapter.ViewHolder holder, int position) {
        holder.SetData(itemTarikhiFarhangiSliders.get(position));
    }

    @Override
    public int getItemCount() {
        return itemTarikhiFarhangiSliders.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView Image;
        TextView txtTitleCityNam, textViewNaghd;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            Image = itemView.findViewById(R.id.ImgAkstarikhifarhangi);
            txtTitleCityNam = itemView.findViewById(R.id.txtcitytarikhifarhangi);
            textViewNaghd = itemView.findViewById(R.id.txtNaghdtarikhifarhangi);

        }

        void SetData(ItemTarikhiFarhangiSlider itemTarikhiFarhangiSlider) {
            Picasso.get().load(itemTarikhiFarhangiSlider.ImageURL).into(Image);
            txtTitleCityNam.setText(itemTarikhiFarhangiSlider.tedadNaghd);
            textViewNaghd.setText(itemTarikhiFarhangiSlider.cityName);
        }
    }
}
