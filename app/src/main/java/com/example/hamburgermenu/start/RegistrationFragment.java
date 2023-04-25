package com.example.hamburgermenu.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.hamburgermenu.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button registered = view.findViewById(R.id.registered);
        EditText email = view.findViewById(R.id.regInputEmail);
        EditText pw = view.findViewById(R.id.regInputPassword);
        EditText cpw = view.findViewById(R.id.regConfirmPassword);


        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pw.getText().toString().equals(cpw.getText().toString())) {

                    String emailString = email.getText().toString().substring(0, email.getText().toString().indexOf("@"));

                    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app");
                    DatabaseReference refLink = mDatabase.getReference("Accounts/");

                    refLink.child(emailString).setValue(pw.getText().toString());


                    Toast.makeText(getContext(), "Registered!", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(v).navigate(R.id.HomeFragment);
                } else {
                    Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}