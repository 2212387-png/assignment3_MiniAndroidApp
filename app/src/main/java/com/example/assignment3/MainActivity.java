package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAdd).setOnClickListener(v ->
                startActivity(new Intent(this, AddNoteActivity.class)));

        findViewById(R.id.btnView).setOnClickListener(v ->
                startActivity(new Intent(this, NotesListActivity.class)));

        findViewById(R.id.btnQuiz).setOnClickListener(v ->
                startActivity(new Intent(this, QuizActivity.class)));
    }
}
