package com.example.task5_dynamiclist;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar loader;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loader = findViewById(R.id.loadingProgress);
        recyclerView = findViewById(R.id.advancedRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Simulate fetching data dynamically with a 3-second delay
        new Handler().postDelayed(() -> {
            List<String> dynamicData = new ArrayList<>();
            dynamicData.add("Task 1: Hello World App");
            dynamicData.add("Task 2: Button Interaction");
            dynamicData.add("Task 3: List Display");
            dynamicData.add("Task 4: Basic UI Layout");
            dynamicData.add("Task 5: Fetch & Display Data");

            // Hide the loader and show the list
            loader.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            // Set the adapter
            recyclerView.setAdapter(new SimpleAdapter(dynamicData));
        }, 3000);
    }

    // FIXED: Changed SimpleAdapter.ViewHolder to just ViewHolder
    private static class SimpleAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<String> data;

        SimpleAdapter(List<String> data) { this.data = data; }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflating your custom item_task layout
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_task, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // Binding data to your custom TextViews
            holder.tvTitle.setText(data.get(position));
            holder.tvStatus.setText("Status: Fetched from Database");
        }

        @Override
        public int getItemCount() { return data.size(); }
    }

    // Matches the IDs in your item_task.xml
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvStatus;

        ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTaskTitle);
            tvStatus = v.findViewById(R.id.tvTaskStatus);
        }
    }
}