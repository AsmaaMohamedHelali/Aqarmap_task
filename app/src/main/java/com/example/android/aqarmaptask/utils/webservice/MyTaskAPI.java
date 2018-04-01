package com.example.android.aqarmaptask.utils.webservice;


import com.example.android.aqarmaptask.models.sections.SectionsResponse.SectionsResponse;
import com.example.android.aqarmaptask.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface MyTaskAPI {


    @GET(Constants.apiURL + "/section.json")
    Call<SectionsResponse> getSections();


}
