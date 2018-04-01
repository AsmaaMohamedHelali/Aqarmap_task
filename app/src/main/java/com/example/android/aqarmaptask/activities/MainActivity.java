package com.example.android.aqarmaptask.activities;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.aqarmaptask.R;
import com.example.android.aqarmaptask.models.MergedSearchListsResponses;
import com.example.android.aqarmaptask.models.locations.locationsResponse.LocationsResponse;
import com.example.android.aqarmaptask.models.prices.pricesResponse.PricesResponse;
import com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse.PropertyTypesResponse;
import com.example.android.aqarmaptask.models.sections.SectionsResponse.SectionsResponse;
import com.example.android.aqarmaptask.utils.network.NetworkUtil;
import com.example.android.aqarmaptask.utils.webservice.MyTask;
import com.isapanah.awesomespinner.AwesomeSpinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ceryle.radiorealbutton.RadioRealButton;
import co.ceryle.radiorealbutton.RadioRealButtonGroup;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function4;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private CompositeDisposable disposable;
    @BindView(R.id.progressbar)
    ContentLoadingProgressBar loadingProgressBar;
    @BindView(R.id.iv_no_network)
    ImageView ivNoNetwork;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.sp_locations)
    AwesomeSpinner spLocations;
    @BindView(R.id.sp_sections)
    AwesomeSpinner spSections;
    @BindView(R.id.sp_type)
    AwesomeSpinner spType;
    @BindView(R.id.sp_maxPrices)
    AwesomeSpinner spMaxPrice;
    @BindView(R.id.sp_minPrices)
    AwesomeSpinner spMinPrice;
    @BindView(R.id.rg_search)
    RadioRealButtonGroup rgSearch;
    @BindView(R.id.rb_rent)
    RadioRealButton rbRent;
    @BindView(R.id.rb_sale)
    RadioRealButton rbSale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        radioGroupListeners();
        loadingProgressBar.setVisibility(View.VISIBLE);
        checkNetwork();
    }
    private void radioGroupListeners(){
        rgSearch.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClickedButton(RadioRealButton button, int position) {
                Toast.makeText(MainActivity.this, "Clicked! Position: " + button.getLabelFor(), Toast.LENGTH_SHORT).show();
            }
        });

// onPositionChanged listener detects if there is any change in position
        rgSearch.setOnPositionChangedListener(new RadioRealButtonGroup.OnPositionChangedListener() {

            @Override
            public void onPositionChanged(RadioRealButton button, int currentPosition, int lastPosition) {
                Toast.makeText(MainActivity.this, "Position Changed! Position: " + currentPosition, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkNetwork() {
        switch (NetworkUtil.getConnectivityStatus(this)) {
            case OFFLINE:
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(this, getString(R.string.offline), Toast.LENGTH_SHORT).show();
                break;
            case WIFI_CONNECTED_WITHOUT_INTERNET:
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(this, getString(R.string.offline), Toast.LENGTH_SHORT).show();
                break;
            case MOBILE_DATA_CONNECTED:
            case WIFI_CONNECTED_WITH_INTERNET:
                callallFilterLists();
                break;
        }
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void handleResults(MergedSearchListsResponses mergedSearchListsResponses) {
        loadingProgressBar.setVisibility(View.GONE);
        if (mergedSearchListsResponses.getSectionsResponse() != null) {
            if(mergedSearchListsResponses.getSectionsResponse().getSections().size()>=2) {
                rbRent.setText(mergedSearchListsResponses.getSectionsResponse().getSections().get(0).getTitle());
                rbRent.setLabelFor(mergedSearchListsResponses.getSectionsResponse().getSections().get(0).getId());
                rbSale.setText(mergedSearchListsResponses.getSectionsResponse().getSections().get(1).getTitle());
                rbSale.setLabelFor(mergedSearchListsResponses.getSectionsResponse().getSections().get(1).getId());
            }
        } else {
            Toast.makeText(this, "errorrrrrrrrrrrr", Toast.LENGTH_SHORT).show();
        }
    }


    private void handleError(Throwable t) {
        loadingProgressBar.setVisibility(View.GONE);
        Log.e("Observer", "" + t.toString());
        Toast.makeText(this, "ERROR IN GETTING RESPONSE",
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
