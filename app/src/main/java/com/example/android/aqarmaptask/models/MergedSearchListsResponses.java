package com.example.android.aqarmaptask.models;

import com.example.android.aqarmaptask.models.locations.locationsResponse.LocationsResponse;
import com.example.android.aqarmaptask.models.prices.pricesResponse.PricesResponse;
import com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse.PropertyType;
import com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse.PropertyTypesResponse;
import com.example.android.aqarmaptask.models.sections.SectionsResponse.SectionsResponse;

/**
 * Created by asmaa on 01/04/18.
 */

public class MergedSearchListsResponses {

    SectionsResponse sectionsResponse;
    LocationsResponse locationsResponse;
    PricesResponse pricesResponse;
    PropertyTypesResponse propertyTypesResponse;


    public MergedSearchListsResponses(SectionsResponse sectionsResponse, LocationsResponse
            locationsResponse, PricesResponse pricesResponse, PropertyTypesResponse propertyTypesResponse) {
        this.sectionsResponse = sectionsResponse;
        this.locationsResponse = locationsResponse;
        this.pricesResponse = pricesResponse;
        this.propertyTypesResponse = propertyTypesResponse;
    }

    public SectionsResponse getSectionsResponse() {
        return sectionsResponse;
    }

    public LocationsResponse getLocationsResponse() {
        return locationsResponse;
    }
}
