package com.studioabir.retrofit.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {


    private List<employee> employees;
    private Context context;

    public EmployeeAdapter(List<employee> employees, Context context) {
        this.employees = employees;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {

        viewHolder.NAME.setText(employees.get(i).getName());
        viewHolder.DESIGNATION.setText(employees.get(i).getDesignation());
        Picasso.with(context).load(employees.get(i).getPhoto()).into(viewHolder.PHOTO);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView NAME,DESIGNATION;
        ImageView PHOTO;

        public MyViewHolder(View itemView) {
            super(itemView);

            NAME = itemView.findViewById(R.id.myname);
            DESIGNATION = itemView.findViewById(R.id.mypost);
            PHOTO = itemView.findViewById(R.id.myimage);
        }
    }
}

