package com.example.task4_basic_ui_layout;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.taskListView);

        String[]tasks={
                "Task 1:Hello World App",
                "Task 2:Button interaction",
                "Task 3:List Display",
                "Task 4:Basic UI Layout",
                "Task 5:Fetch & Display Data",
                "Task 6:Simple Form",
                "Task 7:Hello World App",
                "Task 8:Hello World App"
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                tasks
        );
        listView.setAdapter(adapter);
        Button btn = findViewById(R.id.btnGoToDetails);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            startActivity(intent);
        });
    }
}