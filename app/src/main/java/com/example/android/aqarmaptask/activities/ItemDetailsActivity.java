package com.example.android.aqarmaptask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.aqarmaptask.R;
import com.example.android.aqarmaptask.models.search.searchResponse.Item;
import com.example.android.aqarmaptask.models.search.searchResponse.SearchResponse;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class ItemDetailsActivity extends AppCompatActivity {
    private Item itemData;
    @BindView(R.id.ivImage)
    ImageView ivImage;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.desc)
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ButterKnife.bind(this);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getDataFromIntent();
        setDataOnRes();

    }

    private void setDataOnRes() {
        Picasso.with(this).load(itemData.getMainPhoto().getFile().getThumbnails().getLarge())
                .placeholder(R.drawable.placeholder)
                .into(ivImage);
        title.setText(itemData.getTitle()+" ,"+itemData.getId());
        desc.setText(itemData.getDescription());

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
            itemData = (Item) bundle.getSerializable("ITEMDetails");
        }
    }
}
