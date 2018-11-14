package com.studioabir.retrofit.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getcall(View view) {

        startActivity(new Intent(getApplicationContext(), MyGetActivity.class));

    }

    public void postcall(View view) {

        startActivity(new Intent(getApplicationContext(), MyPostActivity.class));

    }
}
