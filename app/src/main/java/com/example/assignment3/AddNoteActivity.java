package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText title, content;
    Button saveBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        title = findViewById(R.id.etTitle);
        content = findViewById(R.id.etContent);
        saveBtn = findViewById(R.id.btnSave);
        db = new DBHelper(this);

        if (savedInstanceState != null) {
            title.setText(savedInstanceState.getString("title"));
            content.setText(savedInstanceState.getString("content"));
        }

        saveBtn.setOnClickListener(v -> {
            boolean inserted = db.insertNote(
                    title.getText().toString(),
                    content.getText().toString()
            );

            if (inserted)
                Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("title", title.getText().toString());
        outState.putString("content", content.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
