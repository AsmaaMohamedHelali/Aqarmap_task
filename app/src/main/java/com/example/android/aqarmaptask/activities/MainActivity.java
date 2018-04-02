package com.example.android.aqarmaptask.activities;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.aqarmaptask.R;
import com.example.android.aqarmaptask.models.MergedSearchListsResponses;
import com.example.android.aqarmaptask.models.locations.locationsResponse.Location;
import com.example.android.aqarmaptask.models.locations.locationsResponse.LocationSection;
import com.example.android.aqarmaptask.models.locations.locationsResponse.LocationsResponse;
import com.example.android.aqarmaptask.models.prices.pricesResponse.PriceFilter;
import com.example.android.aqarmaptask.models.prices.pricesResponse.PricesResponse;
import com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse.PropertyType;
import com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse.PropertyTypesResponse;
import com.example.android.aqarmaptask.models.sections.SectionsResponse.SectionsResponse;
import com.example.android.aqarmaptask.utils.Localization;
import com.example.android.aqarmaptask.utils.network.NetworkUtil;
import com.example.android.aqarmaptask.utils.webservice.MyTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.ceryle.radiorealbutton.RadioRealButton;
import co.ceryle.radiorealbutton.RadioRealButtonGroup;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function4;
import io.reactivex.schedulers.Schedulers;
import ir.hamsaa.RtlMaterialSpinner;


public class MainActivity extends AppCompatActivity {
    private CompositeDisposable disposable;
    @BindView(R.id.progressbar)
    ContentLoadingProgressBar loadingProgressBar;
    @BindView(R.id.iv_no_network)
    ImageView ivNoNetwork;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.sp_locations)
    RtlMaterialSpinner spLocations;
    @BindView(R.id.sp_sections)
    RtlMaterialSpinner spSections;
    @BindView(R.id.sp_type)
    RtlMaterialSpinner spType;
    @BindView(R.id.sp_maxPrices)
    RtlMaterialSpinner spMaxPrice;
    @BindView(R.id.sp_minPrices)
    RtlMaterialSpinner spMinPrice;
    @BindView(R.id.rg_search)
    RadioRealButtonGroup rgSearch;
    @BindView(R.id.rb_rent)
    RadioRealButton rbRent;
    @BindView(R.id.rb_sale)
    RadioRealButton rbSale;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    List<PriceFilter> rentPrices, salePrices;
    @OnClick(R.id.iv_no_network)
    public void refresh(View view) {
        ivNoNetwork.setVisibility(View.GONE);
        setUpUnVisibiliy();
        checkNetwork();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Localization.setLocale(this,"en");
        setUpUnVisibiliy();
        checkNetwork();
    }

    private void setUpUnVisibiliy() {
        llSearch.setVisibility(View.GONE);
        loadingProgressBar.setVisibility(View.VISIBLE);
        btnSearch.setVisibility(View.GONE);
    }
    private void setUpVisibiliy() {
        llSearch.setVisibility(View.VISIBLE);
        loadingProgressBar.setVisibility(View.GONE);
        btnSearch.setVisibility(View.VISIBLE);
    }


    private void checkNetwork() {
        switch (NetworkUtil.getConnectivityStatus(this)) {
            case OFFLINE:
            case WIFI_CONNECTED_WITHOUT_INTERNET:
                loadingProgressBar.setVisibility(View.GONE);
                ivNoNetwork.setVisibility(View.VISIBLE);
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

    private void radioGroupListeners() {
        rgSearch.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClickedButton(RadioRealButton button, int position) {
                Toast.makeText(MainActivity.this, "Clicked! Position: " + button.getLabelFor(), Toast.LENGTH_SHORT).show();
                if (position == 1) {
                    if (rentPrices != null)
                        setPricesListSpinner(rentPrices);

                } else {
                    if (salePrices != null)
                        setPricesListSpinner(salePrices);
                }
            }
        });

    }

    private void setLocationListSpinner(List<Location> locationListSpinner) {
        ArrayAdapter<Location> locationArrayAdapter = new ArrayAdapter<Location>(this, android.R.layout.simple_spinner_item, locationListSpinner);
        spLocations.setAdapter(locationArrayAdapter);
        spLocations.setSelection(1);
        spLocations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Location selectedLocation = (Location) adapterView.getSelectedItem();
                setSectionListSpinner(selectedLocation.getId(), locationListSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setSectionListSpinner(int locationId, List<Location> locationListSpinner) {
        List<LocationSection> locationSections = null;
        for (int i = 0; i < locationListSpinner.size(); i++) {
            if (locationListSpinner.get(i).getId() == locationId) {
                locationSections = locationListSpinner.get(i).getSections();
                break;
            }
        }
        if (locationSections != null) {
            ArrayAdapter<LocationSection> locationArrayAdapter = new ArrayAdapter<LocationSection>(this, android.R.layout.simple_spinner_item, locationSections);
            spSections.setAdapter(locationArrayAdapter);
            spSections.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    public void setPropertyTypeListSpinner(List<PropertyType> propertyTypeListSpinner) {
        ArrayAdapter<PropertyType> locationArrayAdapter = new ArrayAdapter<PropertyType>(this, android.R.layout.simple_spinner_item, propertyTypeListSpinner);
        spType.setAdapter(locationArrayAdapter);
        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setPricesListSpinner(List<PriceFilter> priceFilter) {
        ArrayAdapter<PriceFilter> priceFilterArrayAdapter = new ArrayAdapter<PriceFilter>(this, android.R.layout.simple_spinner_item, priceFilter);
        spMinPrice.setAdapter(priceFilterArrayAdapter);
        spMinPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spMaxPrice.setAdapter(priceFilterArrayAdapter);
        spMaxPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void handleResults(MergedSearchListsResponses mergedSearchListsResponses) {
        setUpVisibiliy();
        if (mergedSearchListsResponses.getSectionsResponse() != null) {
            if (mergedSearchListsResponses.getSectionsResponse().getSections().size() >= 2) {
                rbRent.setText(mergedSearchListsResponses.getSectionsResponse().getSections().get(0).getTitle());
                rbRent.setLabelFor(mergedSearchListsResponses.getSectionsResponse().getSections().get(0).getId());
                rbSale.setText(mergedSearchListsResponses.getSectionsResponse().getSections().get(1).getTitle());
                rbSale.setLabelFor(mergedSearchListsResponses.getSectionsResponse().getSections().get(1).getId());
                if (mergedSearchListsResponses.getPricesResponse().getPriceFilters() != null) {
                    rentPrices = dividingPrices(mergedSearchListsResponses.getSectionsResponse().getSections().get(0).getId()
                            , mergedSearchListsResponses.getPricesResponse().getPriceFilters());
                    salePrices = dividingPrices(mergedSearchListsResponses.getSectionsResponse().getSections().get(1).getId()
                            , mergedSearchListsResponses.getPricesResponse().getPriceFilters());

                }
                if (rentPrices != null)
                    setPricesListSpinner(rentPrices);

            }
        }
        if (mergedSearchListsResponses.getLocationsResponse() != null) {
            if (mergedSearchListsResponses.getLocationsResponse().getLocations().size() > 0) {
                setLocationListSpinner(mergedSearchListsResponses.getLocationsResponse().getLocations());
            }

        }
        if (mergedSearchListsResponses.getPropertyTypesResponse() != null) {
            if (mergedSearchListsResponses.getPropertyTypesResponse().getPropertyTypes().size() > 0)
                setPropertyTypeListSpinner(mergedSearchListsResponses.getPropertyTypesResponse().getPropertyTypes());
        }
        radioGroupListeners();

    }

    private List<PriceFilter> dividingPrices(int id, List<PriceFilter> pricesFilter) {
        List<PriceFilter> dividedPrices = new ArrayList<PriceFilter>();
        for (int i = 0; i < pricesFilter.size(); i++) {
            if (pricesFilter.get(i).getSection().getId() == id) {
                dividedPrices.add(pricesFilter.get(i));
            }
        }
        return dividedPrices;
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
