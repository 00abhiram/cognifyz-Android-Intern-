package com.example.task7_sqlitedatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText name, roll, email, cgpa;
    Button btnAdd, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this); // Init Database

        name = findViewById(R.id.etName);
        roll = findViewById(R.id.etRoll);
        email = findViewById(R.id.etEmail);
        cgpa = findViewById(R.id.etCgpa);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);

        // Save Data Logic
        btnAdd.setOnClickListener(v -> {
            boolean inserted = db.insertStudent(name.getText().toString(),
                    roll.getText().toString(), email.getText().toString(), cgpa.getText().toString());

            if (inserted) {
                Toast.makeText(this, "Success: Record Saved!", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(this, "Error: Record Not Saved", Toast.LENGTH_SHORT).show();
            }
        });

        // Retrieve Data Logic
        btnView.setOnClickListener(v -> {
            Cursor res = db.getAllStudents();
            if (res.getCount() == 0) {
                showDialog("Error", "No records found in database.");
                return;
            }

            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("ID: ").append(res.getString(0)).append("\n");
                buffer.append("Name: ").append(res.getString(1)).append("\n");
                buffer.append("Roll: ").append(res.getString(2)).append("\n");
                buffer.append("CGPA: ").append(res.getString(4)).append("\n\n");
            }
            showDialog("Registered Students", buffer.toString());
        });
    }

    private void showDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }

    private void clearFields() {
        name.setText(""); roll.setText(""); email.setText(""); cgpa.setText("");
    }
}