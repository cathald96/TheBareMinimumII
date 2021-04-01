package com.example.thebareminimumii.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thebareminimumii.R;

public class ScoreActivity extends AppCompatActivity {
    private TextView score;
    private Button done;
    int MenuCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = findViewById(R.id.score);
        done = findViewById(R.id.done);


        String score_string = getIntent().getStringExtra("SCORE");
        score.setText(score_string);



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ScoreActivity.this, Menu.class);
                ScoreActivity.this.startActivity(intent);
                ScoreActivity.this.finish();
            }
        });



    }

}