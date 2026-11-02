package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.result_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvResult = findViewById(R.id.tvResult);
        TextView tvExplanation = findViewById(R.id.tvExplanation);
        View mainLayout = findViewById(R.id.result_main);

        boolean isCorrect = getIntent().getBooleanExtra("isCorrect", false);
        String explanation = getIntent().getStringExtra("explanation");
        int questionNum = getIntent().getIntExtra("questionNum", 1);

        if (isCorrect) {
            tvResult.setText("צדקת!, כל הכבוד");
            mainLayout.setBackgroundColor(getColor(R.color.result_correct));
        } else {
            tvResult.setText("טעית..., איזה באסה");
            mainLayout.setBackgroundColor(getColor(R.color.result_wrong));
        }

        if (explanation != null) {
            tvExplanation.setText(explanation);
        }

        Button btnBack = findViewById(R.id.btnBack);
        if (questionNum == 1) {
            btnBack.setText("לשאלה הבאה");
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this, SecondQuestionActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        } else if (questionNum == 2) {
            btnBack.setText("לשאלה הבאה");
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this, ThirdQuestionActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            btnBack.setText("לשחק מחדש");
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
