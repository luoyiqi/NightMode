
package com.awaysoft.nightlymode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PreferenceAdapter extends BaseAdapter {
    private Context mContext;

    public PreferenceAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return PreferenceConfig.getCount();
    }

    @Override
    public Object getItem(int position) {
        return PreferenceConfig.get(position);
    }

    @Override
    public long getItemId(int position) {
        return PreferenceConfig.get(position).hashCode();
    }

    @Override
    public int getItemViewType(int position) {
        return PreferenceConfig.get(position).getType();
    }

    @Override
    public boolean isEnabled(int position) {
        return PreferenceConfig.get(position).getType() != PreferenceConfig.HEADER;
    }

    @Override
    public int getViewTypeCount() {
        return PreferenceConfig.getTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        View view = null;

        if (convertView != null && convertView.getTag() instanceof Integer
                && type == (Integer) convertView.getTag()) {
            view = convertView;
        } else {
            view = PreferenceConfig.getView(mContext, position);
        }

        //PreferenceConfig.get(position).setEnable(view, PreferenceConfig.isEnable(position));
        PreferenceConfig.get(position).bindView(view);
        return view;
    }
}
