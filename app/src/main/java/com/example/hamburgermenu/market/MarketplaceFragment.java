package com.example.hamburgermenu.market;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamburgermenu.MainActivity;
import com.example.hamburgermenu.R;
import com.example.hamburgermenu.decorator.VerticalCardPaddingDecoration;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;

public class MarketplaceFragment extends Fragment {

    private Button postLsiting;
    private GridViewAdapter adapter;
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> prices = new ArrayList<>();

    private ArrayList<String> sellers = new ArrayList<>();

    private ArrayList<String> images = new ArrayList<>();

    ArrayList<ArrayList<String>> ListingInformation = new ArrayList<ArrayList<String>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("/MarketplaceListing/");


        View rootView = inflater.inflate(R.layout.fragment_marketplace, container, false);

        RecyclerView dataList = rootView.findViewById(R.id.dataList); // retrieve RecyclerView type dataList from fragment_home2.xml file
        dataList.setVisibility(View.VISIBLE);
        dataList.setHasFixedSize(true);
        dataList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        getDataFromFirebase(dataList);


        return rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        Button postListing = getView().findViewById(R.id.createlistingbutton);
        postListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.listing);
            }
        });

        Button back = getView().findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.HomeFragment);
            }
        });


//        Button home = view.findViewById(R.id.buttontohome);
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(v).navigate( R.id.HomeFragment);
//            }
//        })
          RecyclerView dataList = getView().findViewById(R.id.dataList);
          dataList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }



    private void getDataFromFirebase(RecyclerView dataList) {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("/MarketplaceListing/");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot ) {
                // Get the data as a string
                HashMap<String, HashMap> data = (HashMap<String,HashMap>) dataSnapshot.getValue();

                if (data != null) {
                for (String key : data.keySet()) {


                    ArrayList<String> listingData = new ArrayList<String>();

                    images.add(key);
                    listingData.add(key);
                    listingData.add((data.get(key)).get("title").toString());
                    listingData.add((data.get(key)).get("userID").toString());
                    listingData.add((data.get(key)).get("price").toString());

                    ListingInformation.add(listingData);

                }

                FirebaseStorage storage = FirebaseStorage.getInstance("gs://sutd-lyfe-15801.appspot.com");
                StorageReference storageRef = storage.getReference();

                for (int i = 0; i < ListingInformation.size(); i++) {
                    System.out.println(ListingInformation);


                    titles.add(ListingInformation.get(i).get(1));
                    prices.add(ListingInformation.get(i).get(3));
                    sellers.add(ListingInformation.get(i).get(2));
                }



                storageRef = storageRef.child("MarketplaceList/"+ListingInformation.get(0).get(0));
                System.out.println(storageRef);


//
//                images.add(R.drawable.arduino_uno);
//                images.add(R.drawable.corsair_rm650);
//                images.add(R.drawable.corsair_ddr4_64gb_ram);


                adapter = new GridViewAdapter(getContext(), titles, prices, sellers, images);
                dataList.setAdapter(adapter);
                adapter.setData(titles, prices, sellers, images);
                int padding = getResources().getDimensionPixelSize(R.dimen.card_padding);
                dataList.addItemDecoration(new VerticalCardPaddingDecoration(padding));}

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
    }
}