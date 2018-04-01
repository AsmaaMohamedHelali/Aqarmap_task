package com.example.android.aqarmaptask.utils.webservice;



import com.example.android.aqarmaptask.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyTask {

    private static MyTask instance;
    private static MyTaskAPI apiService;

    private MyTask() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(Level.BODY);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.serverURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(MyTask.okClient())
                .build();



        apiService = retrofit.create(MyTaskAPI.class);
    }
    private static OkHttpClient okClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build();
    }

    public static MyTask getInstance() {
        if (instance == null) {
            instance = new MyTask();
        }
        return instance;
    }

    public MyTaskAPI getMyAppService() {
        return apiService;
    }
}