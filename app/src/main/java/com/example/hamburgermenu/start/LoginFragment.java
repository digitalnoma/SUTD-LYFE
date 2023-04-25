package com.example.hamburgermenu.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.hamburgermenu.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class  LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button login = view.findViewById(R.id.login);
        Button register = view.findViewById(R.id.register);
        EditText email = view.findViewById(R.id.inputEmail);
        EditText password = view.findViewById(R.id.inputPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailString = email.getText().toString().substring(0, email.getText().toString().indexOf("@"));

                DatabaseReference adminRef = FirebaseDatabase.getInstance("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Accounts").child(emailString);

                adminRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String adminValue = dataSnapshot.getValue(String.class);

                        if (adminValue != null && adminValue.equals(password.getText().toString())) {
                            Navigation.findNavController(v).navigate( R.id.HomeFragment);
                        }
                        // Do something with the admin value, such as displaying it to the user
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Handle errors here
                    }
                });




            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate( R.id.registrationFragment);
            }
        });
    }

}