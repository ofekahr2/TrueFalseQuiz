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

public class SecondQuestionActivity extends AppCompatActivity {
    boolean correctAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sec_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnTrue = findViewById(R.id.sec_btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = true;
                boolean isCorrect = (userAnswer == correctAnswer);

                Intent intent = new Intent(SecondQuestionActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", "צרפת גדולה מגרמניה בשטחה (כ-551,000 קמ\"ר לעומת כ-357,000 קמ\"ר).");
                intent.putExtra("questionNum", 2);
                startActivity(intent);
            }
        });

        Button btnFalse = findViewById(R.id.sec_btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = false;
                boolean isCorrect = (userAnswer == correctAnswer);

                Intent intent = new Intent(SecondQuestionActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("explanation", "צרפת גדולה מגרמניה בשטחה (כ-551,000 קמ\"ר לעומת כ-357,000 קמ\"ר).");
                intent.putExtra("questionNum", 2);
                startActivity(intent);
            }
        });
    }
}
