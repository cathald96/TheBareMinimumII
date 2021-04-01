package com.example.thebareminimumii.Questions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thebareminimumii.Menu.Menu;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.thebareminimumii.Menu.Menu.counter;

import com.example.thebareminimumii.Menu.MenuCount;
import com.example.thebareminimumii.R;
import com.example.thebareminimumii.Menu.ScoreActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class InheritanceQuestionsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView q,qCount,timer;
    private Button o1,o2,o3,o4;
    private List<Question> questionList;
    private int qNum;
    private CountDownTimer countdown;
    private int score;
    private FirebaseFirestore firestore;
    DatabaseReference databaseName;
    private Dialog loadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        // databaseName = FirebaseDatabase.getInstance().getReference("counter");

        q=findViewById(R.id.question);
        qCount=findViewById(R.id.question_number);
        timer=findViewById(R.id.countdown);

        o1=findViewById(R.id.option1);
        o2=findViewById(R.id.option2);
        o3=findViewById(R.id.option3);
        o4=findViewById(R.id.option4);

        o1.setOnClickListener(this);
        o2.setOnClickListener(this);
        o3.setOnClickListener(this);
        o4.setOnClickListener(this);

        loadingDialog = new Dialog(InheritanceQuestionsActivity.this);
        loadingDialog.setContentView(R.layout.loading_dialog);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.background2);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();

        //questionList = new ArrayList<>();
        firestore = FirebaseFirestore.getInstance();


        getQuestions();
        score=0;



    }

    private void getQuestions()
    {
        questionList = new ArrayList<>();
        firestore.collection("Quiz").document("Inheritance")
                .collection("Questions")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot Questions = task.getResult();

                    for (QueryDocumentSnapshot doc : Questions) {
                        questionList.add(new Question(doc.getString("Question"),
                                doc.getString("A"),
                                doc.getString("B"),
                                doc.getString("C"),
                                doc.getString("D"),
                                Integer.valueOf(doc.getString("Answer"))
                        ));

                    }
                    setQuestion();

                } else {
                    Toast.makeText(InheritanceQuestionsActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
                loadingDialog.cancel();
            }
        });




    }



    private void setQuestion()
    {
        timer.setText(String.valueOf(10));
        q.setText(questionList.get(0).getQ());
        o1.setText(questionList.get(0).getOption1());
        o2.setText(questionList.get(0).getOption2());
        o3.setText(questionList.get(0).getOption3());
        o4.setText(questionList.get(0).getOption4());

        qCount.setText(String.valueOf(1)+"/"+String.valueOf(questionList.size()));

        startTimer();
        qNum=0;
    }

    private void startTimer()
    {
        countdown =new CountDownTimer(11100,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished<10000)
                    timer.setText(String.valueOf(millisUntilFinished/1000));
                if(millisUntilFinished < 10000)
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }

            @Override
            public void onFinish() {
                changeQuestion();

            }
        };
        countdown.start();
    }

    @Override
    public void onClick(View v)
    {
        int selectedOption =0;

        switch(v.getId())
        {
            case R.id.option1:
                selectedOption =1;
                break;
            case R.id.option2:
                selectedOption=2;
                break;
            case R.id.option3:
                selectedOption=3;
                break;
            case R.id.option4:
                selectedOption=4;
                break;

            default:

        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        countdown.cancel();
        checkAnswer(selectedOption,v);

    }

    private void checkAnswer(int selectedOption,View view)
    {
        if(selectedOption==questionList.get(qNum).getCorrectAns())
        {
            //Correct
            ((Button)view).setBackgroundResource(R.drawable.correct);
            score++;
        }
        else
        {
            //wrong
            ((Button)view).setBackgroundResource(R.drawable.incorrect);

            switch (questionList.get(qNum).getCorrectAns())
            {
                case 1:
                    o1.setBackgroundResource(R.drawable.correct);
                    break;
                case 2:
                    o2.setBackgroundResource(R.drawable.correct);
                    break;
                case 3:
                    o3.setBackgroundResource(R.drawable.correct);
                    break;
                case 4:
                    o4.setBackgroundResource(R.drawable.correct);
                    break;
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
            }
        }, 2000);
    }

    private void changeQuestion()
    {
        if(qNum<questionList.size()-1)
        {
            qNum++;

            playAnim(q,0,0);
            playAnim(o1,0,1);
            playAnim(o2,0,2);
            playAnim(o3,0,3);
            playAnim(o4,0,4);
            qCount.setText(String.valueOf(qNum+1)+ "/"+String.valueOf(questionList.size()));


            timer.setText(String.valueOf(10));
            startTimer();



        }

        else if(String.valueOf(score).equals(String.valueOf(questionList.size()))&& counter<=9){
            counter = 9;
            MenuCount counter = new MenuCount(Menu.counter);
            // databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
            Intent intent = new Intent(InheritanceQuestionsActivity.this, ScoreActivity.class);
            intent.putExtra("SCORE",String.valueOf(score)+"/"+String.valueOf(questionList.size()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            InheritanceQuestionsActivity.this.finish();

        }


        else
        { // go to Score Activity and cancel countdown
            Intent intent = new Intent(InheritanceQuestionsActivity.this,ScoreActivity.class);
            countdown.cancel();
            intent.putExtra("SCORE",String.valueOf(score)+"/"+String.valueOf(questionList.size()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            InheritanceQuestionsActivity.this.finish();

        }
    }


    private void playAnim(View view, final int value,int viewnum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (value == 0) {
                            switch (viewnum) {
                                case 0:
                                    ((TextView) view).setText(questionList.get(qNum).getQ());
                                    break;
                                case 1:
                                    ((Button) view).setText(questionList.get(qNum).getOption1());
                                    break;
                                case 2:
                                    ((Button) view).setText(questionList.get(qNum).getOption2());
                                    break;
                                case 3:
                                    ((Button) view).setText(questionList.get(qNum).getOption3());
                                    break;
                                case 4:
                                    ((Button) view).setText(questionList.get(qNum).getOption4());
                                    break;
                            }
                            if (viewnum != 0)
                                ((Button) view).setBackgroundResource(R.drawable.purple_button);

                            playAnim(view, 1, viewnum);

                        }

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }


    @Override
    public void onBackPressed () {
        super.onBackPressed();
        countdown.cancel();
        finish();


    }
}
