package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdQuestionActivity extends AppCompatActivity {
    boolean correctAnswer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.third_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnTrue = findViewById(R.id.third_btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = true;
                boolean isCorrect = (userAnswer == correctAnswer);

                Intent intent = new Intent(ThirdQuestionActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", "האוקיינוס השקט הוא האוקיינוס הגדול והעמוק ביותר בכדור הארץ!");
                intent.putExtra("questionNum", 3);
                startActivity(intent);
            }
        });

        Button btnFalse = findViewById(R.id.third_btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = false;
                boolean isCorrect = (userAnswer == correctAnswer);

                Intent intent = new Intent(ThirdQuestionActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", "האוקיינוס השקט הוא האוקיינוס הגדול והעמוק ביותר בכדור הארץ!");
                intent.putExtra("questionNum", 3);
                startActivity(intent);
            }
        });
    }
}
