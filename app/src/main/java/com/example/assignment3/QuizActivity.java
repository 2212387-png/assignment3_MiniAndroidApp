package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    RadioGroup rgQ1, rgQ2;
    Button btnSubmit;
    TextView tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rgQ1 = findViewById(R.id.rgQ1);
        rgQ2 = findViewById(R.id.rgQ2);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvScore = findViewById(R.id.tvScore);

        SharedPreferences sp = getSharedPreferences("quiz", MODE_PRIVATE);
        tvScore.setText("Last Score: " + sp.getInt("score", 0));

        btnSubmit.setOnClickListener(v -> {

            int score = 0;

            if (rgQ1.getCheckedRadioButtonId() == R.id.rbQ1_4) {
                score++;
            }

            if (rgQ2.getCheckedRadioButtonId() == R.id.rbQ2_Paris) {
                score++;
            }

            tvScore.setText("Score: " + score);
            sp.edit().putInt("score", score).apply();

            Toast.makeText(this, "Quiz Submitted", Toast.LENGTH_SHORT).show();
        });
    }
}
