package com.example.android.aqarmaptask.activities;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.aqarmaptask.R;
import com.example.android.aqarmaptask.adapters.SearchResultAdapter;
import com.example.android.aqarmaptask.models.search.searchResponse.SearchResponse;

import butterknife.BindView;

public class SearchResultActivity extends AppCompatActivity {
    private SearchResponse searchResponse;
    private SearchResultAdapter searchResultAdapter;
    @BindView(R.id.rv_results)
    RecyclerView rvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getDataFromIntent();
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvResults.setLayoutManager(layoutManager);

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        rvResults.setHasFixedSize(true);

        // COMPLETED (13) Pass in this as the ListItemClickListener to the GreenAdapter constructor
        /*
         * The GreenAdapter is responsible for displaying each item in the list.
         */
        searchResultAdapter = new SearchResultAdapter(searchResponse);
        rvResults.setAdapter(searchResultAdapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.home) {
                NavUtils.navigateUpFromSameTask(this);            }

            return super.onOptionsItemSelected(item);
          }

    public void getDataFromIntent() {
       searchResponse = getIntent().getExtras().getParcelable("SEARCHRESULT");    }
}
