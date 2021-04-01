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
import com.example.thebareminimumii.Questions.Method2QuestionsActivity;
import com.example.thebareminimumii.R;

public class MethodActivity2 extends AppCompatActivity {
    Button button1,button2,button3,button4,button5;
    private Dialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            Intent button1 = new Intent(MethodActivity2.this, Method21.class);
            startActivity(button1);
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            Intent button2 = new Intent(MethodActivity2.this, Method22.class);
            startActivity(button2);
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            Intent button3 = new Intent(MethodActivity2.this, Method23.class);
            startActivity(button3);
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            Intent button4 = new Intent(MethodActivity2.this, Method24.class);
            startActivity(button4);
        });
        button5 = findViewById(R.id.Quiz);
        button5.setOnClickListener(v -> {
            Intent button5 = new Intent(MethodActivity2.this, Method2QuestionsActivity.class);
            startActivity(button5);
        });

    }
    @Override
    public void onBackPressed()
    {
        Intent back = new Intent(MethodActivity2.this, Menu.class);
        startActivity(back);
    }
}