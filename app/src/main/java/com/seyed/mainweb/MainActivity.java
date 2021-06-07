package com.seyed.mainweb;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txtapple, txtchanghal, txtjazebe, txteghamat, txtboomgardi, txttabiatghardi, txtsafarname, txtsoghat;
    Typeface typeface, typeface2;
    ImageSlider slider_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("",""));
        slideModels.add(new SlideModel("",""));
        slideModels.add(new SlideModel("",""));
        slideModels.add(new SlideModel("",""));
        slider_main.setImageList(slideModels,true);

        FindViewByID();
        Typface();

    }

    public void Typface() {
        typeface = Typeface.createFromAsset(getAssets(), "shazdemosafer.ttf");
        typeface2 = Typeface.createFromAsset(getAssets(), "shazdemosafer.ttf");
        txtapple.setTypeface(typeface);
        txtsafarname.setTypeface(typeface2);
        txtchanghal.setTypeface(typeface);
        txtjazebe.setTypeface(typeface);
        txtboomgardi.setTypeface(typeface);
        txttabiatghardi.setTypeface(typeface);
        txteghamat.setTypeface(typeface);
        txtsoghat.setTypeface(typeface);
    }

    public void FindViewByID() {
        slider_main = findViewById(R.id.slider_main);
        txtapple = (TextView) findViewById(R.id.txtapple);
        txtchanghal = (TextView) findViewById(R.id.txtchanghal);
        txtjazebe = (TextView) findViewById(R.id.txtjazebe);
        txteghamat = (TextView) findViewById(R.id.txteghamat);
        txtboomgardi = (TextView) findViewById(R.id.txtboomgardi);
        txttabiatghardi = (TextView) findViewById(R.id.txttabiatghardi);
        txtsafarname = (TextView) findViewById(R.id.txtsafarname);
        txtsoghat = (TextView) findViewById(R.id.txtsoghat);

    }
}