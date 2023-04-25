package com.example.hamburgermenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;


public class  HomeFragment extends Fragment {
    ArrayList<news_banner> news_banners = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageSlider imageSlider = getView().findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add( new SlideModel(R.drawable.sutd_campus, ScaleTypes.FIT));
        slideModels.add( new SlideModel(R.drawable.sutd_community1, ScaleTypes.FIT));
        slideModels.add( new SlideModel(R.drawable.sutd_community2, ScaleTypes.FIT));
        slideModels.add( new SlideModel(R.drawable.sutd_community3, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        CardView dashFood = view.findViewById(R.id.dashboardFood);
        CardView dashMarketplace = view.findViewById(R.id.dashboardMarketplace);
        CardView dashEvents = view.findViewById(R.id.dashboardEvents);
        CardView dashDiscussions = view.findViewById(R.id.dashboardDiscussions);

        dashFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.FoodFragment);
            }
        });
        dashMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.MarketplaceFragment);
            }
        });
        dashEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.EventsFragment);
            }
        });
        dashDiscussions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.DiscussionsFragment);
            }
        });
    }

}

