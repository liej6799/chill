package com.liej6799.chillmobile.ui.main;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.liej6799.chillmobile.R;

import java.util.List;
import java.util.Objects;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context mContext;
    private final List<String> mData;
    private final LayoutInflater mInflater;
    private MainItemClickListener mClickListener;


    // data is passed into the constructor
    MainAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_main, parent, false);
        return new MainAdapter.ViewHolder(view);
    }

    @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = mData.get(position);
        holder.name.setText(item);

        holder.cv_item_main.setCardBackgroundColor(ResourcesCompat.getColor(mContext.getResources(), R.color.gray, null));
        holder.cv_item_main.setClickable(true);


        if (Objects.equals(item, "Fill Mask Task"))
        {
            holder.cv_item_main.setCardBackgroundColor(ResourcesCompat.getColor(mContext.getResources(), R.color.purple_500, null));
            holder.cv_item_main.setClickable(false);

        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        CardView cv_item_main;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_item_main);
            cv_item_main = itemView.findViewById(R.id.cv_item_main);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    void setClickListener(MainAdapter.MainItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    // convenience method for getting data at click position
    String getString(int id) {
        return mData.get(id);
    }
    // parent activity will implement this method to respond to click events
    public interface MainItemClickListener {
        void onItemClick(View view, int position);
    }

}