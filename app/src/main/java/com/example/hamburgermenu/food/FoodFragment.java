package com.example.hamburgermenu.food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamburgermenu.MainActivity;
import com.example.hamburgermenu.R;
import com.example.hamburgermenu.RecycleViewAdapter;
import com.example.hamburgermenu.news_banner;

import java.util.ArrayList;


public class FoodFragment extends Fragment implements FetchDataTask.DataListener {

    ArrayList<news_banner> news_banners = new ArrayList<>();

    RecyclerView recyclerView;
    RecycleViewAdapter<RecyclerView.ViewHolder> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Button home = view.findViewById(R.id.buttontohome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.HomeFragment);
            }
        });
        Button createPost = view.findViewById(R.id.createTweet);
        createPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.tweetFragment);
            }
        });

        FetchDataTask task = new FetchDataTask();
        task.setListener((FetchDataTask.DataListener) this); // Set the listener to this activity
        task.execute(); // Start the task

    }

    @Override
    public void onDataFetched(ServerData data) {
        // This method will be called when the data is fetched
        String[] newsTitleArray = data.getNewsTitle();
        String[] newsDateArray = data.getNewsDate();

        // You can use the newsTitleArray and newsDateArray here
        setUpNewsBanner(newsTitleArray, newsDateArray);

        recyclerView = getView().findViewById(R.id.news_recycle_view);
        adapter = new RecycleViewAdapter<RecyclerView.ViewHolder>(this.getActivity() , news_banners);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }

    private void setUpNewsBanner(String[] newsTitleArray, String[] newsDateArray) {

        for (int i = 0; i < newsTitleArray.length; i++) {
            news_banners.add(new news_banner(newsTitleArray[i], newsDateArray[i]));
        }
    }
}
