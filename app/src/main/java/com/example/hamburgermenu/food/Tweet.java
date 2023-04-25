// This fragment contains the tweet data structure for TweetFragment that is an abstract data type that contains the
// listing title, information, price and image.

// This data structure is used to carry information from the TweetFragment POST request to transfer data in an organised structure
// to the firebase server such that it can be stored in a sorted manner.



package com.example.hamburgermenu.food;

import android.net.Uri;
import android.provider.ContactsContract;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Tweet {




    private Uri imageUri;
    private String title;
    private String price;
    private String information;
    private String userid;

    private String listingID;

    private HashMap<String, Object> listingData;



    FirebaseStorage storage = FirebaseStorage.getInstance("gs://sutd-lyfe-15801.appspot.com");
    StorageReference storageRef = storage.getReference();

    public String pathBuilderImages(String listingID) {
        return "ListingImages/"+listingID+".jpg";

    }



    public void insertAll(FirebaseDatabase mDatabase, String title, String price, String information, String userID, String listingID) {

        DatabaseReference refLink = mDatabase.getReference("Listing/"+listingID+"/title");
        refLink.setValue(title);

        DatabaseReference refLink2 = mDatabase.getReference("Listing/"+listingID+"/information");
        refLink2.setValue(price);

        DatabaseReference refLink3 = mDatabase.getReference("Listing/"+listingID+"/userID");
        refLink3.setValue(userID);

        DatabaseReference refLink4 = mDatabase.getReference("Listing/"+listingID+"/listingID");
        refLink4.setValue(listingID);
        System.out.println("Inserted all");
    }

    public void uploadToFirebase() {

        System.out.println("Uploading Begun");
        //Inserting listing details into Firebase Realtime Database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app");

        insertAll(mDatabase,this.title,this.price,this.information,this.userid,this.listingID);

        //Inserting listing image into Firebase Storage
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imageRef = storageRef.child(pathBuilderImages(listingID));
        UploadTask uploadTask = imageRef.putFile(imageUri);

        System.out.println("Uploading finished");






    }



    public Tweet(String listingID, Uri imageUri , String title , String price, String information, String userid) {

        this.listingID = listingID;
        this.imageUri = imageUri;
        this.title = title;
        this.price = price;
        this.information = information;
        this.userid = userid;


    }


}