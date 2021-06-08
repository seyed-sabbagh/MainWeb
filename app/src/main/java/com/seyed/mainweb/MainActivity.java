package com.seyed.mainweb;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.seyed.mainweb.SliderCity.TravelLocation;
import com.seyed.mainweb.SliderCity.TravelLocationAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txtapple, txtchanghal, txtjazebe, txteghamat, txtboomgardi, txttabiatghardi, txtsafarname, txtsoghat;
    Typeface typeface, typeface2;
    ImageView adsBanner;
    ViewPager2 locationviewpager2;
    List<TravelLocation> travelLocations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FindViewByID();
        ViewPagerCity();
        Typface();
        Picasso.get().load("https://koochita.com/images/esitrevda/gardeshgary.jpg").into(adsBanner);

    }

    public void ViewPagerItem() {

        travelLocations = new ArrayList<>();


        TravelLocation travel1 = new TravelLocation();
        travel1.imageUrl = "https://static1.koochita.com/_images/bannerPic/mainPage/16045864301593411577c416040d3fc5c22127995825e7176eb4.webp";
        travel1.cityName = "test";
        travelLocations.add(travel1);

        TravelLocation travel2 = new TravelLocation();
        travel2.imageUrl = "https://static1.koochita.com/_images/bannerPic/mainPage/16045863511593343025ee740455ff38b1e825a4f1d87856f843.webp";
        travel2.cityName = "test2";
        travelLocations.add(travel2);


    }

    public void ViewPagerCity() {

        ViewPagerItem();

        locationviewpager2.setAdapter(new TravelLocationAdapter(travelLocations));


        locationviewpager2.setClipToPadding(false);
        locationviewpager2.setClipChildren(false);
        locationviewpager2.setOffscreenPageLimit(3);
        locationviewpager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });
        locationviewpager2.setPageTransformer(compositePageTransformer);

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
        locationviewpager2 = findViewById(R.id.locationviewpager);
        adsBanner = findViewById(R.id.adsBanner);
        txtapple = findViewById(R.id.txtapple);
        txtchanghal = findViewById(R.id.txtchanghal);
        txtjazebe = findViewById(R.id.txtjazebe);
        txteghamat = findViewById(R.id.txteghamat);
        txtboomgardi = findViewById(R.id.txtboomgardi);
        txttabiatghardi = findViewById(R.id.txttabiatghardi);
        txtsafarname = findViewById(R.id.txtsafarname);
        txtsoghat = findViewById(R.id.txtsoghat);

    }
}