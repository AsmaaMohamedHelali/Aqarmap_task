package com.example.android.aqarmaptask.utils.webservice;



import com.example.android.aqarmaptask.models.locations.locationsResponse.LocationsResponse;
import com.example.android.aqarmaptask.models.prices.pricesResponse.PricesResponse;
import com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse.PropertyTypesResponse;
import com.example.android.aqarmaptask.models.sections.SectionsResponse.SectionsResponse;
import com.example.android.aqarmaptask.utils.Constants;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface MyTaskAPI {


    @GET(Constants.apiURL + "/section.json")
    Observable<SectionsResponse> getSections();
    @GET(Constants.apiURL + "/property_type.json")
    Observable<PropertyTypesResponse> getPropertyType();
    @GET(Constants.apiURL + "/price_filter.json")
    Observable<PricesResponse> getPriceFilter();
    @GET(Constants.apiURL + "/locations.json")
    Observable<LocationsResponse> getLocations();
//    @GET(Constants.apiURL + "/search.json")
//    Observable<LocationsResponse> getSearchResult();



}
