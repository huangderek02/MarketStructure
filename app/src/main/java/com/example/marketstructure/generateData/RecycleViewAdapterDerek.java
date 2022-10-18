package com.example.marketstructure.generateData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketstructure.R;
import com.example.marketstructure.generateData.DataInRecycleView;

import java.util.List;

public class RecycleViewAdapterDerek extends RecyclerView.Adapter<RecycleViewAdapterDerek.ViewHolder> {

    private List<DataInRecycleView> mDataList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView DataIv;
        TextView DataTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            DataIv = itemView.findViewById(R.id.recycle_view_iv);
            DataTv = itemView.findViewById(R.id.recycle_view_tv);
        }
    }

    public RecycleViewAdapterDerek(List<DataInRecycleView> mDataList) {
        this.mDataList = mDataList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataInRecycleView data = mDataList.get(position);
        holder.DataTv.setText(data.getIsbn());
        holder.DataTv.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mDataList != null){
            return mDataList.size();
        }
        return 0;
    }
}
