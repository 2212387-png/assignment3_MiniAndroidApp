package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.widget.TextView;

public class NotesListActivity extends AppCompatActivity {

    DBHelper db;
    TextView tvNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        db = new DBHelper(this);
        tvNotes = findViewById(R.id.tvNotes);

        Cursor c = db.getNotes();
        StringBuilder data = new StringBuilder();

        while (c.moveToNext()) {
            data.append("Title: ")
                    .append(c.getString(1))
                    .append("\n")
                    .append("Note: ")
                    .append(c.getString(2))
                    .append("\n\n");
        }

        tvNotes.setText(data.toString());
    }
}
