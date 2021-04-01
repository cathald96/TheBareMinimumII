package com.example.thebareminimumii.Auth;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thebareminimumii.Menu.Menu;
import com.example.thebareminimumii.R;


public class WelcomeActivity extends AppCompatActivity {
    TextView t0, t1,t2,t3,t4,t5;
    ImageView img1;

    Button b1;
    private long clickTime = 0;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t0 = findViewById(R.id.t0);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        img1 = findViewById(R.id.img1);
        b1 = findViewById(R.id.b1);
        setContentView(R.layout.activity_welcome);

        View view = findViewById(R.id.View01);
        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (SystemClock.elapsedRealtime() - clickTime < 500) {
                    System.out.println("?");
                } else {
                    clickTime = SystemClock.elapsedRealtime();

                    counter++;
                }
                if (counter > 0) {
                    TextView tv = findViewById(R.id.t1);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 1) {
                    TextView tv = findViewById(R.id.t2);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 2) {
                    TextView tv = findViewById(R.id.t3);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 3) {
                    TextView tv = findViewById(R.id.t4);
                    tv.setVisibility(View.VISIBLE);
                    ImageView img1 = findViewById(R.id.img1);
                    img1.setVisibility(View.VISIBLE);
                }
                if (counter > 4) {
                    TextView tv = findViewById(R.id.t4);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 5) {
                    TextView tv = findViewById(R.id.t5);
                    tv.setVisibility(View.VISIBLE);
                }


                if (counter > 6) {
                    Button b1 = findViewById(R.id.b1);
                    b1.setVisibility(View.VISIBLE);
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(WelcomeActivity.this, Menu.class);
                            startActivity(i);
                        }
                    });
                }
                return true;
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent back = new Intent(WelcomeActivity.this, HomeActivity.class);
        startActivity(back);
    }
}