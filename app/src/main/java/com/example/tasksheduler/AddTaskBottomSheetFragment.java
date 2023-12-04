package com.example.tasksheduler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddTaskBottomSheetFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog, container, false);

        // Find the button in the dialog layout
        Button btnAddTask = view.findViewById(R.id.btn);

        // Set click listener for the button
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the addTask method in MainActivity
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).addTask(view);
                }
            }
        });

        return view;
    }
}
