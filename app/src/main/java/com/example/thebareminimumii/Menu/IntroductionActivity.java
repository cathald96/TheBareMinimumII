package com.example.thebareminimumii.Menu;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.thebareminimumii.Lessons.Intro1;
import com.example.thebareminimumii.Lessons.Intro2;
import com.example.thebareminimumii.Lessons.Intro3;
import com.example.thebareminimumii.Lessons.Intro4;
import com.example.thebareminimumii.Questions.QuestionsActivity;
import com.example.thebareminimumii.R;

public class IntroductionActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            Intent button1 = new Intent(IntroductionActivity.this, Intro1.class);
            startActivity(button1);
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            Intent button2 = new Intent(IntroductionActivity.this, Intro2.class);
            startActivity(button2);
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            Intent button3 = new Intent(IntroductionActivity.this, Intro3.class);
            startActivity(button3);
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            Intent button4 = new Intent(IntroductionActivity.this, Intro4.class);
            startActivity(button4);
        });
        button5 = findViewById(R.id.Quiz);
        button5.setOnClickListener(v -> {
            Intent button5 = new Intent(IntroductionActivity.this, QuestionsActivity.class);
            startActivity(button5);
        });

    }
    @Override
    public void onBackPressed()
    {
        Intent back = new Intent(IntroductionActivity.this, Menu.class);
        startActivity(back);
    }
}
