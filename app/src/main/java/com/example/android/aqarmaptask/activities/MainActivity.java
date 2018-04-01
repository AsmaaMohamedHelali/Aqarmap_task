package com.example.android.aqarmaptask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.aqarmaptask.R;
import com.example.android.aqarmaptask.models.MergedSearchListsResponses;
import com.example.android.aqarmaptask.models.locations.locationsResponse.LocationsResponse;
import com.example.android.aqarmaptask.models.prices.pricesResponse.PricesResponse;
import com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse.PropertyTypesResponse;
import com.example.android.aqarmaptask.models.sections.SectionsResponse.SectionsResponse;
import com.example.android.aqarmaptask.utils.webservice.MyTask;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function4;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private CompositeDisposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callallFilterLists();
    }

    private void callallFilterLists() {
        Observable.just(MyTask.getInstance().getMyAppService()).subscribeOn(Schedulers.computation())
                .flatMap(s -> {
                            Observable<SectionsResponse> sectionsResponseObservable
                                    = s.getSections().subscribeOn(Schedulers.io());
                            Observable<LocationsResponse> locationsResponseObservable
                                    = s.getLocations().subscribeOn(Schedulers.io());
                            Observable<PricesResponse> pricesResponseObservable
                                    = s.getPriceFilter().subscribeOn(Schedulers.io());
                            Observable<PropertyTypesResponse> propertyTypesResponseObservable
                                    = s.getPropertyType().subscribeOn(Schedulers.io());
                            return Observable.zip(sectionsResponseObservable, locationsResponseObservable,
                                    pricesResponseObservable, propertyTypesResponseObservable, new Function4<SectionsResponse, LocationsResponse, PricesResponse, PropertyTypesResponse, MergedSearchListsResponses>() {
                                        @Override
                                        public MergedSearchListsResponses apply(SectionsResponse sectionsResponse, LocationsResponse locationsResponse, PricesResponse pricesResponse, PropertyTypesResponse propertyTypesResponse) throws Exception {
                                            return new MergedSearchListsResponses(sectionsResponse, locationsResponse,
                                                    pricesResponse, propertyTypesResponse);
                                        }
                                    });
                        }
                ).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(MergedSearchListsResponses mergedSearchListsResponses) {
        if (mergedSearchListsResponses.getSectionsResponse() != null) {
            Toast.makeText(this, "result successfully isa", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "errorrrrrrrrrrrr", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleError(Throwable t) {
        Log.e("Observer", "" + t.toString());
        Toast.makeText(this, "ERROR IN GETTING COUPONS",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        //dispose subscriptions
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
        super.onDestroy();
    }
}
