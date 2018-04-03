/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.aqarmaptask.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.aqarmaptask.R;
import com.example.android.aqarmaptask.activities.ItemDetailsActivity;
import com.example.android.aqarmaptask.activities.MainActivity;
import com.example.android.aqarmaptask.activities.SearchResultActivity;
import com.example.android.aqarmaptask.models.search.searchResponse.SearchResponse;
import com.squareup.picasso.Picasso;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.NumberViewHolder> {


    private SearchResponse searchResponse;
    private Context context;


    public SearchResultAdapter(SearchResponse searchResponse,Context context) {
        this.searchResponse = searchResponse;
        this.context=context;
    }


    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.search_results_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        holder.itemTitle.setText(searchResponse.getListings().getItems().get(position).getTitle());
        holder.itemPrice.setText(searchResponse.getListings().getItems().get(position).getPrice()+"");
        holder.itemAddress.setText(searchResponse.getListings().getItems().get(position).getAddress());
        Picasso.with(context).load(searchResponse.getListings().getItems().get(position)
                .getMainPhoto().getFile().getThumbnails().getLarge())
                .placeholder(R.drawable.placeholder)
                .into(holder.itemImage);
        holder.cvResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("SEARCHRESULT", searchResponse);
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        if(searchResponse.getListings().getItems()!=null){
            return searchResponse.getListings().getItems().size();
        }
        return 0;
    }


    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView itemTitle, itemPrice, itemAddress;
        ImageView itemImage;
        CardView cvResult;

        public NumberViewHolder(View itemView) {
            super(itemView);

            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemPrice = (TextView) itemView.findViewById(R.id.item_price);
            itemAddress = (TextView) itemView.findViewById(R.id.item_address);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            cvResult = (CardView) itemView.findViewById(R.id.card_view);
        }


    }
}
