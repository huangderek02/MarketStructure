package com.example.marketstructure;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.marketstructure.StateDesignPattern.Event;
import com.example.marketstructure.StateDesignPattern.OrderStatus;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    public static OrderStatus status;

    private static final String TAG = "RecyclerViewAdapter";

    private final ArrayList<Listing> arrayList;
    private final Context context;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public RecyclerViewAdapter(ArrayList<Listing> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_textbook_image;
        TextView tv_price;
        TextView tv_condition;
        TextView tv_seller;
        TextView tv_listing_status;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_textbook_image = itemView.findViewById(R.id.iv_textbook_image_cl);
            this.tv_price = itemView.findViewById(R.id.tv_price_display_cl);
            this.tv_condition = itemView.findViewById(R.id.tv_condition_display_cl);
            this.tv_seller = itemView.findViewById(R.id.tv_seller_display_cl);
            this.tv_listing_status = itemView.findViewById(R.id.tv_listing_status_display_cl);
        }
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
         View view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
         //RecyclerViewHolder holder = new RecyclerViewHolder(view);
         return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        Listing listing = arrayList.get(position);
        Resources resources = this.context.getApplicationContext().getResources();
        int textbookImageId = resources.getIdentifier("textbookImageName", "drawable", "drawable");
        holder.iv_textbook_image.setImageResource(textbookImageId);
        holder.tv_price.setText(listing.getListingPrice());
        holder.tv_condition.setText(listing.getCondition());
        holder.tv_seller.setText(listing.getSellerUsername());
        holder.tv_listing_status.setText(listing.getListingStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(view.getContext(),DisplayListingDetailsActivity.class);
                b.putExtra("listing",listing);
                context.startActivity(b);
                status = new OrderStatus();
                status.getState().handle(Event.ListingSelectedToView);
                Log.e(TAG,"OrderStatus is in" + RecyclerViewAdapter.status.getState().toString() + "State");
            }
        });


    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
