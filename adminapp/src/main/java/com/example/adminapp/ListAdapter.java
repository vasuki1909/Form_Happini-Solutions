package com.example.adminapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
private Activity mContext;
List<Userdata> userdata;



    public ListAdapter(Activity mcontext, List<Userdata> userdata) {
        super(mcontext, R.layout.list_item,userdata);
        this.mContext = mcontext;
        this.userdata= userdata;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null,true);
        TextView listname = listItemView.findViewById(R.id.listname);
        TextView listmob = listItemView.findViewById(R.id.listmob);
        TextView listservice = listItemView.findViewById(R.id.listservice);
       // TextView listrating = listItemView.findViewById(R.id.listrating);
        TextView listremark = listItemView.findViewById(R.id.listremark);

        Userdata x = userdata.get(position);
        listname.setText(x.getMname());
        listmob.setText(x.getMnumber());
        listservice.setText(x.getSpinner());
       // listrating.setText(String.valueOf(x.getRating()));
        listremark.setText(x.getMremarks());
        return listItemView;
    }

}
