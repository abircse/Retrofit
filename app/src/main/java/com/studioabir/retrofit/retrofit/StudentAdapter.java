package com.studioabir.retrofit.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {


    private List<student> students;
    private Context context;

    public StudentAdapter(List<student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_student,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {

        viewHolder.NAME.setText(students.get(i).getName());
        viewHolder.MYCLASS.setText(students.get(i).getClasslevel());


    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView NAME,MYCLASS;

        public MyViewHolder(View itemView) {
            super(itemView);

            NAME = itemView.findViewById(R.id.mmmm);
            MYCLASS = itemView.findViewById(R.id.nnnn);
        }
    }
}

