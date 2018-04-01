package com.example.android.aqarmaptask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.aqarmaptask.R;
import com.example.android.aqarmaptask.models.sections.SectionsResponse.SectionsResponse;
import com.example.android.aqarmaptask.utils.webservice.MyTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callallFilterLists();
    }
    private void callallFilterLists() {
        Call<SectionsResponse> call =
                MyTask.getInstance().getMyAppService().getSections();
        call.enqueue(new Callback<SectionsResponse>() {

            @Override
            public void onResponse(Call<SectionsResponse> call, Response<SectionsResponse> response) {
                if (response.isSuccessful()) {


                }
            }


            @Override
            public void onFailure(Call<SectionsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();

            }

        });

    }
}
