package com.example.hamburgermenu.market;

import android.net.Uri;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Item {

    private String listingID;
    private Uri imageUri;
    private String listing_title;
    private String listing_price;
    private String listing_information;
    private String listing_userID;
    private String telegram_username;

    FirebaseStorage storage = FirebaseStorage.getInstance("gs://sutd-lyfe-15801.appspot.com");
    StorageReference storageRef = storage.getReference();

    public void insertAll(FirebaseDatabase mDatabase, String listingID,String listing_userID, String listing_title, String listing_price, String listing_information, String telegram_username) {

        DatabaseReference refLink = mDatabase.getReference("MarketplaceListing/"+listingID+"/title");
        refLink.setValue(listing_title);

        DatabaseReference refLink2 = mDatabase.getReference("MarketplaceListing/"+listingID+"/information");
        refLink2.setValue(listing_information);

        DatabaseReference refLink3 = mDatabase.getReference("MarketplaceListing/"+listingID+"/userID");
        refLink3.setValue(listing_userID);

        DatabaseReference refLink4 = mDatabase.getReference("MarketplaceListing/"+listingID+"/listingID");
        refLink4.setValue(listingID);

        DatabaseReference refLink5 = mDatabase.getReference("MarketplaceListing/"+listingID+"/price");
        refLink5.setValue(listing_price);

        DatabaseReference refLink6 = mDatabase.getReference("MarketplaceListing/"+listingID+"/telegram_username");
        refLink6.setValue(telegram_username);






        System.out.println("Inserted all");
    }

    public String pathBuilderImages(String listingID) {
        return "MarketplaceListingImages/"+listingID+".jpg";

    }

    public void uploadToFirebase() {

        System.out.println("Uploading to MarketplaceListingImages Begun");
        //Inserting listing details into Firebase Realtime Database
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app");

        insertAll(mDatabase,this.listingID,this.listing_userID,this.listing_title,this.listing_price,this.listing_information,this.telegram_username);

        //Inserting listing image into Firebase Storage
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference imageRef = storageRef.child(pathBuilderImages(listingID));
        UploadTask uploadTask = imageRef.putFile(imageUri);

        System.out.println("Uploading finished");






    }

    public Item(String listingID, Uri imageUri, String listing_title, String listing_price, String listing_information, String listing_userID, String telegram_username) {
        this.listingID = listingID;
        this.imageUri = imageUri;
        this.listing_title = listing_title;
        this.listing_price = listing_price;
        this.listing_information = listing_information;
        this.listing_userID = listing_userID;
        this.telegram_username = telegram_username;

    }
}
