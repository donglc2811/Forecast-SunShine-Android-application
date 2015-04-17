package com.donglc.forecast;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.donglc.forecast.R;

public class DayWeatherAdapter extends BaseAdapter {
    private Context mContext;
    private List<DayWeatherItem> mDayWeatherItems = new ArrayList<>();
    private int mItemRes;

    public DayWeatherAdapter(Context context, List<DayWeatherItem> dayWeatherItems, int itemRes) {
        this.mContext = context;
        this.mDayWeatherItems = dayWeatherItems;
        this.mItemRes = itemRes;
    }

    @Override
    public int getCount() {
        return mDayWeatherItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mDayWeatherItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemHolder holder;

        if (convertView == null) {

            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(mItemRes, parent, false);

            // well set up the ViewHolder
            holder = new ItemHolder();
            holder.mImgHolder = (ImageView) convertView.findViewById(R.id.img_weather);
            holder.mTvDayHolder = (TextView) convertView.findViewById(R.id.tv_day);
            holder.mTvWeatherStatusHolder = (TextView) convertView.findViewById(R.id.tv_weatherStatus);
            holder.mTvHighDegreeHolder = (TextView) convertView.findViewById(R.id.tv_highDegree);
            holder.mTvLowDegreeHolder = (TextView) convertView.findViewById(R.id.tv_lowDegree);

            // store the holder with the view.
            convertView.setTag(holder);

        } else {
            holder = (ItemHolder) convertView.getTag();
        }

        DayWeatherItem d = mDayWeatherItems.get(position);

        holder.mImgHolder.setImageBitmap(d.getmNoneColoredBitmap());
        holder.mTvDayHolder.setText(d.getmDay());
        holder.mTvWeatherStatusHolder.setText(d.getmStatus());
        holder.mTvHighDegreeHolder.setText("" + d.getmHighDegree());
        holder.mTvLowDegreeHolder.setText("" + d.getmLowDegree());

        return convertView;
    }
}
// declare a class holder
class ItemHolder {
    ImageView mImgHolder;
    TextView mTvDayHolder;
    TextView mTvWeatherStatusHolder;
    TextView mTvHighDegreeHolder;
    TextView mTvLowDegreeHolder;
}