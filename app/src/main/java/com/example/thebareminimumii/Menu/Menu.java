package com.example.thebareminimumii.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.thebareminimumii.Auth.LoginActivity;
import com.example.thebareminimumii.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Menu extends AppCompatActivity{

    Button btnLogout;
    GridLayout mainGridLayout;
    public static int counter;
    private FirebaseFirestore firestore;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseName =firebaseDatabase.getReference("Users");

   // private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymenu);
        mainGridLayout = (GridLayout) findViewById(R.id.mainGridLayout);
        setSingleEvent(mainGridLayout);

        counter = new MenuCount().getCounter();



        btnLogout = findViewById(R.id.button5);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent signout = new Intent(Menu.this, LoginActivity.class);
                startActivity(signout);
            }
        });
    }

    private void setSingleEvent(GridLayout mainGridLayout) {

        for(int i =0;i<mainGridLayout.getChildCount();i++)
        {
            CardView cardView = (CardView)mainGridLayout.getChildAt(i);
            final int final1 =i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(final1==0)
                    {
                        Intent intent = new Intent(Menu.this, IntroductionActivity.class);
                        startActivity(intent);
                    }
                    else if(final1==1&&counter<1)
                    {
                        Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                       // Intent intent = new Intent(Menu.this, MethodActivity.class);
                       //startActivity(intent);
                    }
                    else if(final1==1&&counter>=1)
                    {
                       // Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Menu.this,MethodActivity.class);
                        startActivity(intent);
                    }

                    else if(final1==2&&counter<2)
                    {
                       // Intent intent = new Intent(Menu.this,MethodActivity2.class);
                       // startActivity(intent);
                       Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                    }
                    else if(final1==2&&counter>=2)
                    {
                        //Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Menu.this, MethodActivity2.class);
                        startActivity(intent);
                    }
                    else if(final1==3&&counter<3)
                    {
                        //Intent intent = new Intent(Menu.this,RegexActivity.class);
                        // startActivity(intent);
                        Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                    }
                    else if(final1==3&&counter>=3)
                    {
                         //Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Menu.this, RegexActivity.class);
                        startActivity(intent);
                    }
                    else if(final1==4&&counter<4)
                    {
                      //  Intent intent = new Intent(Menu.this,RecursionActivity.class);
                       // startActivity(intent);
                        Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                    }
                    else if(final1==4&&counter>=4)
                    {
                        // Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Menu.this, RecursionActivity.class);
                       startActivity(intent);
                    }
                    else if(final1==5&&counter<5)
                    {
                         //Intent intent = new Intent(Menu.this,FSMActivity.class);
                        // startActivity(intent);
                        Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                    }
                    else if(final1==5&&counter>=5)
                    {
                         //Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Menu.this, FSMActivity.class);
                       startActivity(intent);
                    }
                    else if(final1==6&&counter<6)
                    {
                        // Intent intent = new Intent(Menu.this,SortingActivity.class);
                        // startActivity(intent);
                        Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                    }
                    else if(final1==6&&counter>=6)
                    {
                         //Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(Menu.this, SortingActivity.class);
                        startActivity(intent);
                    }
                    else if(final1==7&&counter<7)
                    {
                        // Intent intent = new Intent(Menu.this,ClassesActivity.class);
                        // startActivity(intent);
                        Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                    }
                    else if(final1==7&&counter>=7)
                    {
                        // Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Menu.this, ClassesActivity.class);
                        startActivity(intent);
                    }
                    else if(final1==8&&counter<8)
                    {
                        // Intent intent = new Intent(Menu.this,InheritanceActivity.class);
                       //  startActivity(intent);
                        Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                    }
                    else if(final1==8&&counter>=8)
                    {
                         //Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Menu.this, InheritanceActivity.class);
                        startActivity(intent);
                    }
                    else if(final1==9&&counter<9)
                    {
                         //Intent intent = new Intent(Menu.this,TMActivity.class);
                         //startActivity(intent);
                        Toast.makeText(Menu.this,"Complete previous quiz to unlock",Toast.LENGTH_SHORT).show();
                    }
                    else if(final1==9&&counter>=9)
                    {
                        //Toast.makeText(Menu.this,"Unavailable",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Menu.this, TMActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }

    }
    @Override
    public void onBackPressed()
    {
        Intent back = new Intent(Menu.this, Menu.class);
        startActivity(back);
    }
}
