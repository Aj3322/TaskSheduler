package com.example.tasksheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<TaskModule> {
    public TaskAdapter(Context context, List<TaskModule> taskModules) {
        super(context, 0, taskModules);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskModule taskModule = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itam_task, parent, false);
        }

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvPriority = convertView.findViewById(R.id.tvPriority);
        TextView tvdis = convertView.findViewById(R.id.tvDis);


        tvTitle.setText(taskModule.getTitle());
        tvPriority.setText(String.valueOf(taskModule.getPriority()));
        tvdis.setText(taskModule.getDescription());


        return convertView;
    }
}

