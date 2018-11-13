package com.studioabir.retrofit.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("reademployee.php")
    Call<List<employee>> getEmployee();
}
