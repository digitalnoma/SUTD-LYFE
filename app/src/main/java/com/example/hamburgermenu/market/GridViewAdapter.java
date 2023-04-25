package com.example.hamburgermenu.market;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamburgermenu.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder>{
    // ViewHolder is a wrapper (able to call onto multiple f(x)) that contains the layout for an individual item in the list
    // The Adapter (GridViewAdapter) creates ViewHolder objects as needed and sets data for those views. Hence we associate views to their data
    Context context;
    private ArrayList<String> titles;
    private ArrayList<String> prices;
    private ArrayList<String> sellers;

    private ArrayList<String> images;

    LayoutInflater inflater; // custom layout design

    // Constructor for the class below
    public GridViewAdapter(Context context, ArrayList<String> titles, ArrayList<String> prices,
                           ArrayList<String> sellers, ArrayList<String> images) {
        this.context = context;
        this.titles = titles;
        this.images = images;
        this.prices = prices;
        this.sellers = sellers;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public GridViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println(this.images);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marketplace_custom_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewAdapter.ViewHolder holder, int position) {

        FirebaseStorage storage = FirebaseStorage.getInstance();
        String image = images.get(position);
        System.out.println(image);
        StorageReference storageRef = storage.getReferenceFromUrl("gs://sutd-lyfe-15801.appspot.com/MarketplaceListingImages/"+image+".jpg");

        String title = titles.get(position);
        String price = prices.get(position);
        String seller = sellers.get(position);



        holder.title.setText(title);
        holder.price.setText(price);
        holder.seller.setText(seller);

        final long FIVE_MEGABYTE = 5 * 1024 * 1024;
        storageRef.getBytes(FIVE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                holder.image.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors that occur during the download
            }
        });


    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView price;
        public TextView seller;
        public ImageView image;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textView);
            image = (ImageView) itemView.findViewById(R.id.imageView2);
            price = (TextView) itemView.findViewById(R.id.item_price);
            seller = (TextView) itemView.findViewById(R.id.item_seller);
        }
    }
    public void setData(ArrayList<String> titles, ArrayList<String> prices, ArrayList<String> sellers, ArrayList<String> images) {
        this.titles = titles;

        this.images = images;




        this.prices = prices;

        this.sellers = sellers;
        notifyDataSetChanged();
    }
}
