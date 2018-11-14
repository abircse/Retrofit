package com.studioabir.retrofit.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("reademployee.php")
    Call<List<employee>> getEmployee();

    @GET("searchstudent.php")
    Call<List<student>> getStudent(@Query("class_level") String class_level);
}
