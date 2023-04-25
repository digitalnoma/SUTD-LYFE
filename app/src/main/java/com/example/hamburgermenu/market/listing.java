package com.example.hamburgermenu.market;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hamburgermenu.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listing#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listing extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String listing_title;

    private String listing_userID;

    private String listing_information;

    private String listing_price;

    private String telegram_username;

    private Button btn_upload;

    private Button btn_back;
    private ImageView image_view;
    private Uri imageUri;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private String listingID;

    FirebaseStorage storage = FirebaseStorage.getInstance("gs://sutd-lyfe-15801.appspot.com");
    StorageReference storageRef = storage.getReference();




    public listing() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment listing.
     */
    // TODO: Rename and change types and number of parameters
    public static listing newInstance(String param1, String param2) {
        listing fragment = new listing();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    public static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);

        Button  PostListingButton = view.findViewById(R.id.post2);


        btn_upload = view.findViewById(R.id.btn_upload2);
        btn_back = view.findViewById(R.id.back);
        image_view = view.findViewById(R.id.image_view2);

        PostListingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                   System.out.println("Registered");

                   if (imageUri != null) {

                       String listingID = generateRandomString();
                       System.out.println(imageUri);

                       System.out.println("Sending to Firebase");
                       mDatabase = FirebaseDatabase.getInstance("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();


                       EditText listingInfoEditText = getActivity().findViewById(R.id.information2);
                       listing_information = listingInfoEditText.getText().toString();

                       System.out.println(listing_information);

                       EditText listingPriceEditText = getActivity().findViewById(R.id.price2);
                       listing_price = listingPriceEditText.getText().toString();

                       System.out.println(listing_price);

                       EditText listingTitleEditText = getActivity().findViewById(R.id.title2);
                       listing_title = listingTitleEditText.getText().toString();

                       listing_userID = "";
                       telegram_username = "";


                       Item newListing = new Item(listingID, imageUri, listing_title, listing_price, listing_information, listing_userID, telegram_username);

                       newListing.uploadToFirebase();


                   } else {
                       // Handle error
                   }
               }
           });

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            imageUri = data.getData();
                            image_view.setImageURI(imageUri);

                        } else {
                            // Handle error
                        }
                    }
                });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Selecting pictures");
                Intent photoPicker = new Intent();
                photoPicker.setAction(Intent.ACTION_GET_CONTENT);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate( R.id.MarketplaceFragment);
            }
        });




        // Inflate the layout for this fragment
        return view;
    }

}