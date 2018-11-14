package com.studioabir.retrofit.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPostActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private StudentAdapter adapter;
    private List<student> students;
    private ApiInterface apiInterface;

    //------Spnier------------//
    private Spinner spinner;
    private ArrayAdapter<String> classadap;
    private String itemname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post);

        spinner = findViewById(R.id.myspinner);
        recyclerView = findViewById(R.id.myrecy);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        String[] getdata = getResources().getStringArray(R.array.classlist);
        classadap = new ArrayAdapter<String>(this,R.layout.spinerdesign, getdata);
        classadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(classadap);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemname = parent.getItemAtPosition(position).toString();
                FetchInformation(itemname);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void FetchInformation(String type)
    {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<student>> call = apiInterface.getStudent(type);

        call.enqueue(new Callback<List<student>>() {
            @Override
            public void onResponse(Call<List<student>> call, Response<List<student>> response) {

                students = response.body();
                adapter = new StudentAdapter(students,MyPostActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<student>> call, Throwable t) {

            }
        });


    }


}
