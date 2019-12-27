package com.example.mcqapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mcqapp.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView t1_question,totalTxt,correctTxt,wrongTxt,levelTxt;
    int total=0;
    int correct=0;
    int wrong=0;
    String level="Easy";
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        t1_question = (TextView) findViewById(R.id.questionsTxt);
        totalTxt = (TextView) findViewById(R.id.totalTxt);
        correctTxt = (TextView) findViewById(R.id.correctTxt);
        wrongTxt = (TextView) findViewById(R.id.wrongTxt);
        levelTxt = (TextView) findViewById(R.id.levelTxt);

        updateQuestion();

    }

        private void updateQuestion()
        {
            if(total<10)
            {
                reference  = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final Question  question = dataSnapshot.getValue(Question.class);

                        t1_question.setText(question.getQuestion());
                        b1.setText(question.getOption1());
                        b2.setText(question.getOption2());
                        b3.setText(question.getOption3());
                        b4.setText(question.getOption4());


                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                                                                   }
                                    },1500);
                                }
                                else {

                                    //if answer is wrong
                                    wrong++;
                                    b1.setBackgroundColor(Color.RED);

                                    if(b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed( () -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    },1500);
                                 }
                            }
                        });

                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);
                                }
                                else {

                                    //if answer is wrong
                                    wrong++;
                                    b2.setBackgroundColor(Color.RED);

                                    if(b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed( () -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    },1500);
                                }
                            }
                        });


                        b3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);
                                }
                                else {

                                    //if answer is wrong
                                    wrong++;
                                    b3.setBackgroundColor(Color.RED);

                                    if(b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed( () -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    },1500);
                                }
                            }
                        });

                        b4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(b4.getText().toString().equals(question.getAnswer()))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);
                                }
                                else {

                                    //if answer is wrong
                                    wrong++;
                                    b4.setBackgroundColor(Color.RED);

                                    if(b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed( () -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    },1500);
                                }
                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            else if(total<20 && correct>=7) {
                level="Medium";
                reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final Question question = dataSnapshot.getValue(Question.class);

                        t1_question.setText(question.getQuestion());
                        b1.setText(question.getOption1());
                        b2.setText(question.getOption2());
                        b3.setText(question.getOption3());
                        b4.setText(question.getOption4());


                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    }, 1500);
                                } else {

                                    //if answer is wrong
                                    wrong++;
                                    b1.setBackgroundColor(Color.RED);

                                    if (b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed(() -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }, 1500);
                                }
                            }
                        });

                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    }, 1500);
                                } else {

                                    //if answer is wrong
                                    wrong++;
                                    b2.setBackgroundColor(Color.RED);

                                    if (b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed(() -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }, 1500);
                                }
                            }
                        });


                        b3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    }, 1500);
                                } else {

                                    //if answer is wrong
                                    wrong++;
                                    b3.setBackgroundColor(Color.RED);

                                    if (b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed(() -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }, 1500);
                                }
                            }
                        });

                        b4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    }, 1500);
                                } else {

                                    //if answer is wrong
                                    wrong++;
                                    b4.setBackgroundColor(Color.RED);

                                    if (b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed(() -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }, 1500);
                                }
                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
                else if(total<30 && correct>=15)
            {
                level="Difficult";
                reference  = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final Question  question = dataSnapshot.getValue(Question.class);

                        t1_question.setText(question.getQuestion());
                        b1.setText(question.getOption1());
                        b2.setText(question.getOption2());
                        b3.setText(question.getOption3());
                        b4.setText(question.getOption4());


                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);
                                }
                                else {

                                    //if answer is wrong
                                    wrong++;
                                    b1.setBackgroundColor(Color.RED);

                                    if(b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed( () -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    },1500);
                                }
                            }
                        });

                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);
                                }
                                else {

                                    //if answer is wrong
                                    wrong++;
                                    b2.setBackgroundColor(Color.RED);

                                    if(b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed( () -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    },1500);
                                }
                            }
                        });


                        b3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);
                                }
                                else {

                                    //if answer is wrong
                                    wrong++;
                                    b3.setBackgroundColor(Color.RED);

                                    if(b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed( () -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    },1500);
                                }
                            }
                        });

                        b4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(b4.getText().toString().equals(question.getAnswer()))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                            updateQuestion();
                                        }
                                    },1500);
                                }
                                else {

                                    //if answer is wrong
                                    wrong++;
                                    b4.setBackgroundColor(Color.RED);

                                    if(b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    }
                                    else if(b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    }

                                    Handler handler = new Handler();
                                    handler.postDelayed( () -> {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    },1500);
                                }
                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
                else
            {
                OpenResult();
            }
            checkLevel(levelTxt);
            countTotal(totalTxt);
            countCorrect(correctTxt);
            countWrong(wrongTxt);
            total++;
        }

        public void countTotal(TextView tv)
        {
                tv.setText(String.valueOf(total));
        }

        public void countCorrect(TextView tv)
        {
                tv.setText(String.valueOf(correct));
        }

        public void countWrong(TextView tv)
        {
            tv.setText(String.valueOf(wrong));
        }

        public void checkLevel(TextView tv) { tv.setText(String.valueOf(level));}

        public void OpenResult() {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("total", String.valueOf(total));
            intent.putExtra("correct", String.valueOf(correct));
            intent.putExtra("wrong", String.valueOf(wrong));
            startActivity(intent);
        return;
        }
    }
