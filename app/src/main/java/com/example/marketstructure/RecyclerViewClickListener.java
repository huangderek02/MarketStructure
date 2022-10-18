package com.example.marketstructure;

import android.view.View;

interface RecyclerViewClickListener {
    default void onItemClick(View v,int pos){

    }
}
