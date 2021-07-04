package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button retrivedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrivedata = findViewById(R.id.btn);

        retrivedata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              Intent i = new Intent(MainActivity.this,RetreiveDataActivity.class);
              startActivity(i);
              finish();
           }
       });

    }
}

