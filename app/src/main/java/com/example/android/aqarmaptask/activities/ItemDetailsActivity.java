package com.example.android.aqarmaptask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.aqarmaptask.R;
import com.example.android.aqarmaptask.models.search.searchResponse.SearchResponse;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class ItemDetailsActivity extends AppCompatActivity {
    private SearchResponse searchResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ButterKnife.bind(this);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getDataFromIntent();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    public void getDataFromIntent() {
        Bundle bundle = getIntent().getBundleExtra("bundle");
        if (bundle != null) {
            searchResponse = (SearchResponse) bundle.getSerializable("SEARCHRESULT");
        }
    }
}
