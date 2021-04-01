package com.example.thebareminimumii.Menu;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thebareminimumii.Lessons.Method21;
import com.example.thebareminimumii.Lessons.Method22;
import com.example.thebareminimumii.Lessons.Method23;
import com.example.thebareminimumii.Lessons.Method24;
import com.example.thebareminimumii.Lessons.Regex1;
import com.example.thebareminimumii.Lessons.Regex2;
import com.example.thebareminimumii.Lessons.Regex3;
import com.example.thebareminimumii.Lessons.Regex4;
import com.example.thebareminimumii.Questions.Method2QuestionsActivity;
import com.example.thebareminimumii.Questions.RegexQuestionsActivity;
import com.example.thebareminimumii.R;

public class RegexActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5;
    private Dialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            Intent button1 = new Intent(RegexActivity.this, Regex1.class);
            startActivity(button1);
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            Intent button2 = new Intent(RegexActivity.this, Regex2.class);
            startActivity(button2);
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            Intent button3 = new Intent(RegexActivity.this, Regex3.class);
            startActivity(button3);
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            Intent button4 = new Intent(RegexActivity.this, Regex4.class);
            startActivity(button4);
        });
        button5 = findViewById(R.id.Quiz);
        button5.setOnClickListener(v -> {
            Intent button5 = new Intent(RegexActivity.this, RegexQuestionsActivity.class);
            startActivity(button5);
        });

    }
    @Override
    public void onBackPressed()
    {
        Intent back = new Intent(RegexActivity.this, Menu.class);
        startActivity(back);
    }
}

