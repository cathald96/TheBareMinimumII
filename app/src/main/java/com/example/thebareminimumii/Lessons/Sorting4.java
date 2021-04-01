package com.example.thebareminimumii.Lessons;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thebareminimumii.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sorting4 extends AppCompatActivity implements ValueEventListener {
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;
    // ImageView image;
    private Dialog loadingDialog;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference =firebaseDatabase.getReference("Sorting4");
    private DatabaseReference firstDatabase = databaseReference.child("firsttext");
    private DatabaseReference secondDatabase = databaseReference.child("secondtext");
    private DatabaseReference thirdDatabase = databaseReference.child("thirdtext");
    private DatabaseReference fourthDatabase = databaseReference.child("fourthtext");
    private DatabaseReference fifthDatabase = databaseReference.child("fifthtext");
    private DatabaseReference sixthDatabase = databaseReference.child("sixthtext");
    private DatabaseReference seventhDatabase = databaseReference.child("seventhtext");
    private DatabaseReference eighthDatabase = databaseReference.child("eighthtext");
    private DatabaseReference ninthDatabase = databaseReference.child("ninthtext");
    private DatabaseReference tenthDatabase = databaseReference.child("tenthtext");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textlayout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // image=(ImageView) findViewById(R.id.first);
        textView1=(TextView)findViewById(R.id.first);
        textView2=(TextView)findViewById(R.id.second);
        textView3=(TextView)findViewById(R.id.third);
        textView4=(TextView)findViewById(R.id.fourth);
        textView5=(TextView)findViewById(R.id.fifth);
        textView6=(TextView)findViewById(R.id.sixth);
        textView7=(TextView)findViewById(R.id.seventh);
        textView8=(TextView)findViewById(R.id.eighth);
        textView9=(TextView)findViewById(R.id.ninth);
        textView10=(TextView)findViewById(R.id.tenth);
        loadingDialog = new Dialog(Sorting4.this);
        loadingDialog.setContentView(R.layout.loading_dialog);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.background2);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if(snapshot.getValue(String.class)!=null)
        {
            String key = snapshot.getKey();
            if(key.equals("firsttext"))
            {
                String first = snapshot.getValue(String.class);
                textView1.setText(first);
            }

            if(key.equals("secondtext"))
            {
                String second = snapshot.getValue(String.class);
                textView2.setText(second);
            }
            if(key.equals("thirdtext"))
            {
                String third = snapshot.getValue(String.class);
                textView3.setText(third);
            }
            if(key.equals("fourthtext"))
            {
                String fourth = snapshot.getValue(String.class);
                textView4.setText(fourth);
            }
            if(key.equals("fifthtext"))
            {
                String fifth = snapshot.getValue(String.class);
                textView5.setText(fifth);
            }
            if(key.equals("sixthtext"))
            {
                String sixth = snapshot.getValue(String.class);
                textView6.setText(sixth);
            }
            if(key.equals("seventhtext"))
            {
                String seventh = snapshot.getValue(String.class);
                textView7.setText(seventh);
                textView7.setGravity(Gravity.LEFT);
            }
            if(key.equals("eighthtext"))
            {
                String eighth = snapshot.getValue(String.class);
                textView8.setText(eighth);
            }
            if(key.equals("ninthtext"))
            {
                String ninth = snapshot.getValue(String.class);
                textView9.setText(ninth);
            }
            if(key.equals("tenthtext"))
            {
                String tenth = snapshot.getValue(String.class);
                textView10.setText(tenth);
                textView10.setTextSize(7);
            }
        }
        loadingDialog.cancel();

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        firstDatabase.addValueEventListener(this);
        secondDatabase.addValueEventListener(this);
        thirdDatabase.addValueEventListener(this);
        fourthDatabase.addValueEventListener(this);
        fifthDatabase.addValueEventListener(this);
        sixthDatabase.addValueEventListener(this);
        seventhDatabase.addValueEventListener(this);
        eighthDatabase.addValueEventListener(this);
        ninthDatabase.addValueEventListener(this);
        tenthDatabase.addValueEventListener(this);
    }
}

