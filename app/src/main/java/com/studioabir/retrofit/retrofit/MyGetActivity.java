package com.studioabir.retrofit.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyGetActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private EmployeeAdapter adapter;
    private List<employee> employees;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_get);

        recyclerView = findViewById(R.id.myrecylear);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<employee>> call = apiInterface.getEmployee();

        call.enqueue(new Callback<List<employee>>() {
            @Override
            public void onResponse(Call<List<employee>> call, Response<List<employee>> response) {

                employees = response.body();
                adapter = new EmployeeAdapter(employees,getApplicationContext());
                recyclerView.setAdapter(adapter);
                // if nedded to get specific object for set in text view use index no in get menthod like below
                //Toast.makeText(MyGetActivity.this, "name is "+employees.get(1).getDesignation(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<List<employee>> call, Throwable t) {

            }
        });
    }
}
