package com.example.think_twice_code_once.callmessage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by think-twice-code-once on 31/1/17.
 */
public class CustomListViewAdapter extends ArrayAdapter<RowItem> {
    Context context;

    public CustomListViewAdapter(Context context, int resourceId,
                                 List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView txName;
        TextView txPhoneNume;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.contact_all, null);
            holder = new ViewHolder();
            holder.txPhoneNume = (TextView) convertView.findViewById(R.id.phoneNumber);
            holder.txName = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txPhoneNume.setText(rowItem.getPhoneNumber());
        holder.txName.setText(rowItem.getName());

        return convertView;
    }
}

