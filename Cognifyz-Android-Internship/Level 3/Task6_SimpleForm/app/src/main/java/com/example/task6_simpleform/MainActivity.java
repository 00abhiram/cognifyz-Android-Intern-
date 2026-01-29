package com.example.task6_simpleform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etDept = findViewById(R.id.etDept);
        Button btnSubmit =findViewById(R.id.btnSubmit);

        LinearLayout resultCard = findViewById(R.id.resultCard);
        TextView tvDisplayResult = findViewById(R.id.tvDisplayResult);

        btnSubmit.setOnClickListener(v -> {
            // Get text from all fields
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String dept = etDept.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || dept.isEmpty()) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
            } else {
                String resultSummary = "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Phone: " + phone + "\n" +
                        "Department: " + dept;

                tvDisplayResult.setText(resultSummary);
                resultCard.setVisibility(View.VISIBLE);

                Toast.makeText(this, "Registration Completed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}