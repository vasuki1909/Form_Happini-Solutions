package com.example.form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    public EditText name,mob,remarks;
    public Button submit;
    ///public RatingBar ratingBar;
    DatabaseReference reff;
    private FirebaseAuth mFirebaseAuth;
    int maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        mFirebaseAuth = FirebaseAuth.getInstance();

        Spinner myspinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        myspinner.setAdapter(myadapter);

        name = findViewById(R.id.form_name);
        mob = findViewById(R.id.form_mob);
        remarks = findViewById(R.id.form_remarks);
        submit = findViewById(R.id.btn);
       // ratingBar = findViewById(R.id.rating_bar);
        Member member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Form_data");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxid = (int) snapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Data entered successfully!", Toast.LENGTH_LONG).show();
                member.setMname(name.getText().toString().trim());
                member.setMnumber(mob.getText().toString().trim());
                member.setMremarks(remarks.getText().toString().trim());
               // member.setRating(ratingBar.getRating());
                member.setSpinner(myspinner.getSelectedItem().toString().trim());

                reff.push().setValue(member);

            }
        });
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        mFirebaseAuth.signOut();
        Toast.makeText(HomeActivity.this,"Logged out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        return super.onOptionsItemSelected(item);

    }
}