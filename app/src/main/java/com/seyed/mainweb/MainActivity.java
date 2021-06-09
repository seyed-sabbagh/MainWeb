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

import com.seyed.mainweb.Slider.GhazaSlider.GhazaAdapter;
import com.seyed.mainweb.Slider.GhazaSlider.ItemContainerGhazaSlider;
import com.seyed.mainweb.Slider.JadidTarinSafarNameSlider.ItemContainerSafarnameSlider;
import com.seyed.mainweb.Slider.JadidTarinSafarNameSlider.SafarNameAdapter;
import com.seyed.mainweb.Slider.SliderCity.CitySliderAdapter;
import com.seyed.mainweb.Slider.SliderCity.ItemContainerCity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txtapple, txtchanghal, txtjazebe, txteghamat, txtboomgardi, txttabiatghardi, txtsafarname, txtsoghat;
    Typeface typeface, typeface2;
    ImageView adsBanner, adsBanner2, imgMap;
    ViewPager2 cityViewPager, safarnameViewPager, ViewPagerghaza;
    List<ItemContainerCity> itemContainerCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FindViewByID();
        ViewPagerCity();
        Typface();
        ViewPagerSafarname();
        ViewPagerGhaza();

        Picasso.get().load("https://koochita.com/images/esitrevda/gardeshgary.jpg").into(adsBanner);
        Picasso.get().load("https://koochita.com/images/esitrevda/kishBanner.jpg").into(adsBanner2);
        Picasso.get().load("https://koochita.com/images/mainPics/mapPicture.jpg").into(imgMap);

    }

    public void ViewPagerGhaza() {

        List<ItemContainerGhazaSlider> itemContainerGhazaSliders = new ArrayList<>();

        ItemContainerGhazaSlider aa = new ItemContainerGhazaSlider();
        aa.CityName = "aaa";
        aa.ImageURL = "https://static1.koochita.com/_images/posts/9/1583080117-mainPic.jpg";
        aa.Naghd = "q";
        itemContainerGhazaSliders.add(aa);

        ItemContainerGhazaSlider aaa = new ItemContainerGhazaSlider();
        aaa.CityName = "aaa";
        aaa.ImageURL = "https://static1.koochita.com/_images/posts/9/1583080117-mainPic.jpg";
        aaa.Naghd = "q";
        itemContainerGhazaSliders.add(aaa);

        ViewPagerghaza.setAdapter(new GhazaAdapter(itemContainerGhazaSliders));
    }

    public void ViewPagerSafarname() {

        List<ItemContainerSafarnameSlider> itemContainerSafarnameSliders = new ArrayList<>();

        ItemContainerSafarnameSlider tet = new ItemContainerSafarnameSlider();
        tet.tedadNaghd = "شهر اصفهان";
        tet.cityName = "0 نقد";
        tet.ImageURL = "https://static1.koochita.com/_images/posts/9/1583080117-mainPic.jpg";
        itemContainerSafarnameSliders.add(tet);

        ItemContainerSafarnameSlider tett = new ItemContainerSafarnameSlider();
        tett.tedadNaghd = "0 نقدر";
        tett.cityName = "اصفهان ";
        tett.ImageURL = "https://static1.koochita.com/_images/posts/9/1583080117-mainPic.jpg";
        itemContainerSafarnameSliders.add(tett);

        safarnameViewPager.setAdapter(new SafarNameAdapter(itemContainerSafarnameSliders));

    }

    public void ViewPagerItemCity() {

        itemContainerCities = new ArrayList<>();


        ItemContainerCity travel1 = new ItemContainerCity();
        travel1.imageUrl = "https://static1.koochita.com/_images/bannerPic/mainPage/16045864301593411577c416040d3fc5c22127995825e7176eb4.webp";
        travel1.cityName = "test";
        itemContainerCities.add(travel1);

        ItemContainerCity travel2 = new ItemContainerCity();
        travel2.imageUrl = "https://static1.koochita.com/_images/bannerPic/mainPage/16045863511593343025ee740455ff38b1e825a4f1d87856f843.webp";
        travel2.cityName = "test2";
        itemContainerCities.add(travel2);


    }

    public void ViewPagerCity() {

        ViewPagerItemCity();

        cityViewPager.setAdapter(new CitySliderAdapter(itemContainerCities));


        cityViewPager.setClipToPadding(false);
        cityViewPager.setClipChildren(false);
        cityViewPager.setOffscreenPageLimit(3);
        cityViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });
        cityViewPager.setPageTransformer(compositePageTransformer);

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
        imgMap = findViewById(R.id.imgMap);
        ViewPagerghaza = findViewById(R.id.ViewPagerghaza);
        adsBanner2 = findViewById(R.id.adsBanner2);
        safarnameViewPager = findViewById(R.id.ViewPager22);
        cityViewPager = findViewById(R.id.cityViewPager);
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