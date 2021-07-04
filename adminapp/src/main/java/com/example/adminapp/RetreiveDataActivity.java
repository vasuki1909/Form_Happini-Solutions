package com.example.adminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class RetreiveDataActivity extends AppCompatActivity {

    ListView myListView;
    List<Userdata> userdata;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreive_data);
        myListView = findViewById(R.id.myListView);
        userdata = new ArrayList<>();
        reff = FirebaseDatabase.getInstance().getReference().child("Form_data");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userdata.clear();
                for(DataSnapshot studentDatasnap: snapshot.getChildren()){
                    Userdata user  = studentDatasnap.getValue(Userdata.class);
                    userdata.add(user);
                }
                ListAdapter adapter = new ListAdapter(RetreiveDataActivity.this,userdata);
                myListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}