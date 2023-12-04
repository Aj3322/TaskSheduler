package com.example.tasksheduler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TaskManager taskManager;
    private TaskAdapter taskAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Task Scheduler");

        taskManager = new TaskManager();
        taskAdapter = new TaskAdapter(this, new ArrayList<>());

        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(v -> showBottomSheetDialog());
        Button btn = findViewById(R.id.btnUpdate);
        btn.setOnClickListener(v -> updateTaskList());


        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(taskAdapter);

        // Add sample tasks
        TaskModule taskModule1 = new TaskModule("Task 1", "Description 1", 2, new Date());
        TaskModule taskModule2 = new TaskModule("Task 2", "Description 2", 1, new Date());

        taskManager.addTask(taskModule1);
        taskManager.addTask(taskModule2);

        updateTaskList();
    }

    private void updateTaskList() {
        taskAdapter.clear();

        List<TaskModule> tasksFromManager = taskManager.getAllTasks();
        taskAdapter.addAll(tasksFromManager);

        // Notify the adapter that the data set has changed
        taskAdapter.notifyDataSetChanged();
    }




    public void addTask(View view) {

       EditText  etTitle = view.findViewById(R.id.etTitle);
       EditText etDescription = view.findViewById(R.id.etDescription);
       EditText etPriority = view.findViewById(R.id.etPriority);

        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();
        String priority = etPriority.getText().toString();


        TaskModule newTaskModule = new TaskModule(title, description, Integer.parseInt(priority), new Date());
        taskManager.addTask(newTaskModule);
        // Clear input fields
        etTitle.getText().clear();
        etDescription.getText().clear();
        etPriority.getText().clear();
    }


    private void showBottomSheetDialog() {
        AddTaskBottomSheetFragment bottomSheetFragment = new AddTaskBottomSheetFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }
}
