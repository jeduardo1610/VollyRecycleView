package com.example.m14x.vollyrecycleview.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.m14x.vollyrecycleview.Model.ObjectDescription;
import com.example.m14x.vollyrecycleview.R;

import java.util.List;

/**
 * Created by m14x on 27/01/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<ObjectDescription> mDataSet;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        private TextView mData;
        private TextView mWrapperType;
        private TextView mKind;
        private TextView mArtistId;
        private TextView mCollectionId;
        private TextView mTrackId;
        private TextView mArtistName;
        private TextView mCollectionName;
        private Button mButton;



        public ViewHolder(View v) {
            super(v);
            mData = (TextView) v.findViewById(R.id.mData);
            mWrapperType = (TextView) v.findViewById(R.id.wrapperType);
            mKind = (TextView) v.findViewById(R.id.kind);
            mArtistId = (TextView) v.findViewById(R.id.artistId);
            mCollectionId = (TextView) v.findViewById(R.id.collectionId);
            mTrackId = (TextView) v.findViewById(R.id.trackId);
            mArtistName = (TextView) v.findViewById(R.id.artistId);
            mCollectionName = (TextView) v.findViewById(R.id.collectionId);
            mButton = (Button) v.findViewById(R.id.button);
        }
    }

    public MyAdapter (List<ObjectDescription> DataSet) {mDataSet = DataSet;}
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        v.setClickable(true);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        holder.mWrapperType.setText(mDataSet.get(position).getWrapperType());
        holder.mKind.setText(mDataSet.get(position).getKind());
        holder.mArtistId.setText(mDataSet.get(position).getArtistId());
        holder.mCollectionId.setText(mDataSet.get(position).getCollectionId());
        holder.mTrackId.setText(mDataSet.get(position).getTrackId());
        holder.mArtistName.setText(mDataSet.get(position).getArtistName());
        holder.mCollectionName.setText(mDataSet.get(position).getCollectionName());

        try{
            YoYo.with(Techniques.Tada)
                    .duration(700)
                    .playOn(holder.itemView);
        }
        catch(Exception e){}

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
