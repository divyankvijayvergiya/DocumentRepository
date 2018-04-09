package com.example.documentrepository.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.documentrepository.Models.MainItems;
import com.example.documentrepository.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by divyankvijayvergiya on 09/04/18.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainViewHolder> {
    private ArrayList<MainItems> mainItemsArrayList;
    private static ListItemClickListener listItemClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int clickItemIndex);

    }

    public MainListAdapter(ArrayList<MainItems> mainItemsArrayList, ListItemClickListener listItemClickListener) {
        this.mainItemsArrayList = mainItemsArrayList;
        this.listItemClickListener = listItemClickListener;
    }

    @Override
    public MainListAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.main_list_items;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachToBooleanImmediately = false;
        View view = layoutInflater.inflate(layoutIdForListItem, parent, shouldAttachToBooleanImmediately);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainListAdapter.MainViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mainItemsArrayList != null) {
            return mainItemsArrayList.size();
        } else {
            return 0;
        }
    }


    class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView imageView;
        public final TextView textView;

        public MainViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.main_image);
            textView = itemView.findViewById(R.id.main_title);
            itemView.setOnClickListener(this);
        }

        void onBind(int position) {
            if (!mainItemsArrayList.isEmpty()) {
                Picasso.with(itemView.getContext()).load(mainItemsArrayList.get(position).getImage()).placeholder(R.drawable.placeholder_repo).into(imageView);
                textView.setText(mainItemsArrayList.get(position).getName());

            }
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            listItemClickListener.onListItemClick(clickedPosition);
        }
    }
}
